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
public class Estudiante {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Estudiante(int id_tipo_identificacion, String ruc_estudiante, String nombre_estudiante, String genero_estudiante, String correo_estudiante, String celular_estudiante, String direccion_estudiante, String fecha_registro_estudiante, int id_carrera, int id_nivel, int id_paralelo, int id_usuarios)throws SQLException {
        
       String sql="";
       int n = 0;
       int id_estudiante=0;
       
       try {
            String consul="SELECT id_estudiante FROM estudiante WHERE ruc_estudiante='"+ruc_estudiante+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_estudiante= rs.getInt(1);
            }
            
                if(id_estudiante==0){

                   sql="INSERT INTO estudiante (id_tipo_identificacion, ruc_estudiante, nombre_estudiante, genero_estudiante, correo_estudiante, celular_estudiante, direccion_estudiante, fecha_registro_estudiante, id_carrera, id_nivel, id_paralelo, id_usuarios) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setInt(1, id_tipo_identificacion);
                   pst.setString(2, ruc_estudiante);
                   pst.setString(3, nombre_estudiante);
                   pst.setString(4, genero_estudiante);
                   pst.setString(5, correo_estudiante);
                   pst.setString(6, celular_estudiante);
                   pst.setString(7, direccion_estudiante);
                   pst.setString(8, fecha_registro_estudiante);
                   pst.setInt(9, id_carrera);
                   pst.setInt(10, id_nivel);
                   pst.setInt(11, id_paralelo);
                   pst.setInt(12, id_usuarios);
                  
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
