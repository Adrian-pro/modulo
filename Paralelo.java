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
public class Paralelo {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Paralelo(String nombre_paralelo)throws SQLException {
         
        
       String sql="";
       int n = 0;
       int id_paralelo=0;
       
       try {
            String consul="SELECT id_paralelo FROM paralelo WHERE  nombre_paralelo='"+nombre_paralelo+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_paralelo= rs.getInt(1);
            }
            
                if(id_paralelo==0){

                   sql="INSERT INTO paralelo (nombre_paralelo) VALUES (?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, nombre_paralelo);

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
