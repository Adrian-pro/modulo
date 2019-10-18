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
public class TipoIdentificacion {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_TipoIdentificacion(String nombre_tipo_identificacion)throws SQLException {
         
        
       String sql="";
       int n = 0;
       int id_tipo_identificacion=0;
       
       try {
            String consul="SELECT id_tipo_identificacion FROM tipo_identificacion WHERE  nombre_tipo_identificacion='"+nombre_tipo_identificacion+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_tipo_identificacion= rs.getInt(1);
            }
            
                if(id_tipo_identificacion==0){

                   sql="INSERT INTO tipo_identificacion (nombre_tipo_identificacion) VALUES (?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, nombre_tipo_identificacion);

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
