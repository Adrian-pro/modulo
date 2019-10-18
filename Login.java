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

/**
 *
 * @author Usuario
 */
public class Login {
     Conexion cc= new Conexion();
        Connection cn = cc.conexion();
    
    // CREAMOS METODO QUE RETORNA UN BOLEAN DE RESPUESTA (TRUE O FALSE)
    // EL MISMO QUE ES LLAMADO DESDE EL FORMULARIO LOGIN
     public int login(String usuario, String password)throws SQLException {
     
    
        
    try {
        // INSTANCIO A MI CONTROLADOR CONEXION Y USO EL METODO OBTENER 
         Conexion conexion = new Conexion().obtener();
         
         // DECLARO VARIABLE RESULSET PARA RESPUESTA DE CONSULTA A BASE DE DATOS
         // USO MI INSTACIA CONEXION Y USO EL METODO CONSULTA PARA EJECUTAR SENTENCIA SQL PARA VERIFICAR SI EL USUARIO Y LA CLAVE SON CORRECTOS
         
         ResultSet resultado = conexion.consultar("SELECT id_usuarios, nombre_usuarios, correo_usuarios, cedula_usuarios, celular_usuarios, id_rol FROM usuarios WHERE cedula_usuarios = '" + usuario + "' and clave_usuarios = '" + password + "'" );
         
         // RECORRO VARIABLE RESULSET LA CUAL TIENE LA RESPUESTA DE BASE DE DATOS
         resultado.last();
         // CUENTO NUMERO DE FILAS DE VARIABLE RESULSET
         if (resultado.getRow() > 0){
            
             // SI VARIABLE RESULSET TIENE DATOS QUIERE DECIR QUE USUARIO Y CONTRASEÑA ES CORRECTO
             // INTANCIO MI MODELO USUARIO Y USO EL METODO GETINSTANCE PARA CREAR VARIABLES DE INICIO DE SESION O VARIABLES GLOBALES
             
             Usuario usuarioactual = Usuario.getInstance();
              

               // USO MI INSTANCIA Y ALMACENO VALORES DE BASE DE DATOS EN VARIABLES GLOBALES CREADAS EN EL MODELO USUARIO
              usuarioactual.setid_usuarios(resultado.getInt("id_usuarios"));
              usuarioactual.setnombre_usuarios(resultado.getString("nombre_usuarios"));
              usuarioactual.setcorreo_usuarios(resultado.getString("correo_usuarios"));
              usuarioactual.setcedula_usuarios(resultado.getString("cedula_usuarios"));                            
              usuarioactual.setcelular_usuarios(resultado.getString("celular_usuarios"));                            
              usuarioactual.setid_rol(resultado.getInt("id_rol"));                            
             
            // DEVUELVO RESPUESTA A FORMULRIO LOGIN (TRUE)
            
        String sql="UPDATE consecutivos SET consecutivo_consecutivos = '1' WHERE nombre_consecutivos = 'LOGUEO'"; 
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.executeUpdate();
            
             return 1;
        }else{
             
             
          return 2;
        }
   } catch (SQLException e) {
          // IMPRIMO ERROR EN CONSOLA
            e.printStackTrace();
             // DEVUELVO RESPUESTA A FORMULRIO LOGIN (FALSE)
            return 0;
    }
     // DEVUELVO RESPUESTA A FORMULRIO LOGIN (FALSE)
      
   }

   

    
    
}
