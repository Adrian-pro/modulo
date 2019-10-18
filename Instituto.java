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
public class Instituto {
    
    
        Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
     public int Inserta_Instituto(int id_tipo_identificacion, String ruc_instituto, String razon_social_instituto, String telefono_instituto, String direccion_instituto, String nombre_representante_legal_instituto, String correo_instituto)throws SQLException {
        
       String sql="";
       int n = 0;
       int id_instituto=0;
       
       try {
            String consul="SELECT id_instituto FROM instituto WHERE  ruc_instituto='"+ruc_instituto+"'";
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                id_instituto= rs.getInt(1);
            }
            
                if(id_instituto==0){

                   sql="INSERT INTO instituto (id_tipo_identificacion,ruc_instituto,razon_social_instituto,telefono_instituto, direccion_instituto, nombre_representante_legal_instituto, correo_instituto) VALUES (?,?,?,?,?,?,?)";
                   PreparedStatement pst = cn.prepareStatement(sql);
                   pst.setInt(1, id_tipo_identificacion);
                   pst.setString(2, ruc_instituto);
                   pst.setString(3, razon_social_instituto);
                   pst.setString(4, telefono_instituto);
                   pst.setString(5, direccion_instituto);
                   pst.setString(6, nombre_representante_legal_instituto);
                   pst.setString(7, correo_instituto);

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
