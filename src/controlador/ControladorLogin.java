/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.Padre;

public class ControladorLogin extends Conexion {
    public static int iddoctor,idpadre;
    public static String nombredoctor,apellidodoctor,nombrepadre,apellidopadre;
    public void validadPadre(Padre p, JFrame ventana, JFrame padre, JFrame agregar) {
        Statement ps = null;
        ResultSet rs = null;
        int resultado = 0;
        String usuario = p.getUsuario();
        String pass = p.getContraseña();
        
        String SQL = "SELECT usuario,contraseña,idpadre,primer_nombre,primer_apellido FROM padre WHERE usuario='" + usuario + "' and contraseña='" + pass + "'";

        try {
            ps = this.getCon().createStatement();
            rs = ps.executeQuery(SQL);

            if (rs.next()) {
                idpadre=rs.getInt(3);
                nombrepadre=rs.getString(4);
                apellidopadre=rs.getString(5);
                resultado = 1;
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO");
                    ventana.dispose();
                    padre.setVisible(true);
                }
            } else {

                int resp = JOptionPane.showConfirmDialog(null, "Usuario no existe,¿Desea Registrarse?");
                if (resp == 0) {
                    ventana.dispose();
                    agregar.setVisible(true);
                }else if(resp==1){
               System.exit(0);
                }else{
                
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void validadDoctor(Doctor p, JFrame ventana, JFrame doctor) {
        Statement ps = null;
        ResultSet rs = null;
        int resultado = 0;
        String usuario = p.getUsuario();
        String pass = p.getContraseña();
        String SQL = "SELECT usuario,contraseña,iddoctor,primer_nombre,primer_apellido FROM doctor WHERE usuario='" + usuario + "' and contraseña='" + pass + "' ";

        try {
            ps = this.getCon().createStatement();
            rs = ps.executeQuery(SQL);

            if (rs.next()) {
                iddoctor=rs.getInt(3);
                nombredoctor=rs.getString(4);
                apellidodoctor=rs.getString(5);
                resultado = 1;
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO");
                    ventana.dispose();
                    doctor.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existe");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
