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
public class Vinculacion {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Vinculacion(String id_proyecto, String  id_estudiante, String id_instituto, String id_tutor, String fecha_inicio, String fecha_finalizo, String fecha_presento, String numero_horas, String presento_anillado, String informe_tutor, String nota_tutor, String nota_vinculacion, int id_usuarios, String numero_vinculacion)throws SQLException {
        
       String sql="";
       int n = 0;
       int id_vinculacion=0;
       
       try {
            String consul="SELECT id_vinculacion FROM vinculacion WHERE id_estudiante='"+id_estudiante+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_vinculacion= rs.getInt(1);
            }
            
                if(id_vinculacion==0){

                   sql="INSERT INTO vinculacion (id_proyecto, id_estudiante, id_instituto, id_tutor, fecha_inicio, fecha_finalizo, fecha_presento, numero_horas, presento_anillado, informe_tutor, nota_tutor, nota_vinculacion, id_usuarios, numero_vinculacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setString(1, id_proyecto);
                   pst.setString(2, id_estudiante);
                   pst.setString(3, id_instituto);
                   pst.setString(4, id_tutor);
                   pst.setString(5, fecha_inicio);
                   pst.setString(6, fecha_finalizo);
                   pst.setString(7, fecha_presento);
                   pst.setString(8, numero_horas);
                   pst.setString(9, presento_anillado);
                   pst.setString(10, informe_tutor);
                   pst.setString(11, nota_tutor);
                   pst.setString(12, nota_vinculacion);
                   pst.setInt(13, id_usuarios);
                   pst.setString(14, numero_vinculacion);
                  
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
