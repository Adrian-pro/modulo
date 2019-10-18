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
public class Carrera {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Carrera(String codigo_carrera, String nombre_carrera, String titulo_carrera, String tipo_carrera)throws SQLException {
        
       String sql="";
       int n = 0;
       int id_carrera=0;
       
       try {
            String consul="SELECT id_carrera FROM carrera WHERE codigo_carrera='"+codigo_carrera+"' AND nombre_carrera='"+nombre_carrera+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_carrera= rs.getInt(1);
            }
            
                if(id_carrera==0){

                   sql="INSERT INTO carrera (codigo_carrera,nombre_carrera,titulo_carrera,tipo_carrera) VALUES (?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, codigo_carrera);
                   pst.setString(2, nombre_carrera);
                   pst.setString(3, titulo_carrera);
                   pst.setString(4, tipo_carrera);
                  
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
