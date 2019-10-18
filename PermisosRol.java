/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Usuario;
import java.sql.Connection; 
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class PermisosRol {
    
    
     Conexion cc= new Conexion();
     Connection cn = cc.conexion();
    
     public int Inserta_PermisosRol(int id_rol, int id_formularios, String nombre_permisos_rol, String ver_permisos_rol)throws SQLException {
         
       String sql="";
       int n = 0;
       int id_permisos_rol=0;
       
       try {
            String consul="SELECT id_permisos_rol FROM permisos_rol WHERE  id_rol='"+id_rol+"' AND id_formularios='"+id_formularios+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_permisos_rol= rs.getInt(1);
            }
            
                if(id_permisos_rol==0){

                   sql="INSERT INTO permisos_rol (id_rol,id_formularios,nombre_permisos_rol,ver_permisos_rol) VALUES (?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setInt(1, id_rol);
                   pst.setInt(2, id_formularios);
                   pst.setString(3, nombre_permisos_rol);
                   pst.setString(4, ver_permisos_rol);

                   n=pst.executeUpdate();

                    return n;

                }else{

                 return 2;
                } 
             
         }catch (Exception e) {
              
              e.printStackTrace();
              return n;
         }
         
        
   }
   
 
}
