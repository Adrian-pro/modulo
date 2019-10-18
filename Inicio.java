/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Formulario.FrmLogin;
/**
 *
 * @author Usuario
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FrmLogin form_login = new FrmLogin();
        form_login.setVisible(true);
        form_login.setLocationRelativeTo(form_login);
    }
    
}
