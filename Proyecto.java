/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection; 
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Proyecto {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Proyecto(String codigo_proyecto, String macro_proyecto, String nombre_proyecto, String objetivo_proyecto, int id_usuarios, int id_carrera)throws SQLException {
         
       String sql="";
       int n = 0;
       int id_proyecto=0;
       
       try {
            String consul="SELECT id_proyecto FROM proyecto WHERE  id_carrera='"+id_carrera+"' AND  nombre_proyecto='"+nombre_proyecto+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_proyecto= rs.getInt(1);
            }
            
                if(id_proyecto==0){

                   sql="INSERT INTO proyecto (codigo_proyecto, macro_proyecto, nombre_proyecto, objetivo_proyecto, id_usuarios, id_carrera) VALUES (?,?,?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, codigo_proyecto);
                   pst.setString(2, macro_proyecto);
                   pst.setString(3, nombre_proyecto);
                   pst.setString(4, objetivo_proyecto);
                   pst.setInt(5, id_usuarios);
                   pst.setInt(6, id_carrera);
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
