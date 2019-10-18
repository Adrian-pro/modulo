/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Conexion {
 
    
     // VARIABLE PARA CONEXION A BASE DE DATOS (PONER PUERTO Y NOMBRE DE SU BASE DE DATOS)
     private String cadcon="jdbc:mysql://localhost:3306/vinculacion";
     // VARIABLE PARA CONEXION A BASE DE DATOS (PONER USUARIO)
     private String user="root";
     // VARIABLE PARA CONEXION A BASE DE DATOS (PONER CLAVE)
     private String password="";
    
   // ESTABLECEMOS CONEXION NULA 
   Connection conect = null;
   
   //CREAMOS  METODO PARA CONEXION
   public Connection conexion()
    {
      try {
           // USAMOS EL JDBC DRIVER DE MYSQL PARA LA CONEXION
           Class.forName("com.mysql.jdbc.Driver");
           // INICIAMOS CONEXION A BASE DE DATOS
           conect = DriverManager.getConnection(cadcon, user, password);
           
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
         // DEVOLVEMOS RESPUESTA DE CONEXION
        return conect;
     
    }
    
    // INSTANCIAMOS VARIABLE CONEXION EN PUBLIC STATIC PARA PODER LLAMARLA DESDE CUALQUIER PARTE DEL PROYECTO.
    public static Connection conexion;
   
    
    
   // CREAMOS METODO PARA CONEXION A BASE DE DATOS PARA CREAR VARIABLE DE INICIO DE SESION O VARIABLES GLOBALES 
   public Conexion obtener(){
     
      try {
            // USAMOS EL JDBC DRIVER DE MYSQL PARA LA CONEXION
            Class.forName("com.mysql.jdbc.Driver");
            // INICIAMOS CONEXION A BASE DE DATOS
            setConexion(DriverManager.getConnection(cadcon, user, password));
            
            
            // LLAMAMOS NUESTRO CONSTRUCTOR GET PARA VERIFICAR CONEXION
            if(getConexion() != null){
            // IMPRIMIMOS MENSAJE EN CONSOLA    
                System.out.println("Conexion Exitosa!");
            }else{
            // IMPRIMIMOS MENSAJE EN CONSOLA  
                System.out.println("Conexion Fallida!");                
            }
            
      } catch (Exception e) {
              e.printStackTrace();
      }
    // DEVOLVEMOS RESPUESTA DE CONEXION
      return this;
   }
   
   
   
   // CREAMOS CONSTRUCTORES GET PARA DEVOLVER CONEXION
    public Connection getConexion() {
     return conexion;
    }  
   
   // CREAMOS CONSTRUCTORES SET PARA OBTENER CONEXION
   public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }   
   
   
   
   // CREAMOS METODO PARA CONSULTAR A BASE DE DATOS
   public ResultSet consultar(String sql) {
       // DEFINIMOS VARIABLE DE TIPO RESULSET (ARRAY) 
       ResultSet resultado;
        try {
            
            // INSTANCIAMOS CONEXION A BASE DE DATOS LLAMANDO NUESTRO CONSTRUCTOR GET PARA OBTENER CONEXION A BASE DE DATOS 
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            // EJECUTAMOS SENTENCIA SQL A BASE DE DATOS
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            // IMPRIMIMOS EN CONSOLA SI EXISTIO ALGUN ERROR
            e.printStackTrace();
            // DEVOLVEMOS RESPUESTA NULA DE BASE DE DATOS
            return null;
        }   
        // DEVOLVEMOS RESULTADO DE BASE DE DATOS
        return resultado;
    }

   
   
   // CREAMOS METODO PARA FORMAR SENTENCIAS SQL
    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
  
    
}
