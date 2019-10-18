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
public class Usuarios {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Usuarios(String cedula, String nombre, String correo, String celular, String clave, int id_rol)throws SQLException {
        
       String sql="";
       int n = 0;
       int id_usuarios=0;
       
       try {
            String consul="SELECT id_usuarios FROM usuarios WHERE  cedula_usuarios='"+cedula+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_usuarios= rs.getInt(1);
            }
            
                if(id_usuarios==0){

                   sql="INSERT INTO usuarios (cedula_usuarios,nombre_usuarios,correo_usuarios,celular_usuarios, clave_usuarios, id_rol) VALUES (?,?,?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, cedula);
                    pst.setString(2, nombre);
                    pst.setString(3, correo);
                    pst.setString(4, celular);
                    pst.setString(5, clave);
                    pst.setInt(6, id_rol);

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
