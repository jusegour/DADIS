/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Panel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import modelo.Aviso;
import modelo.Padre;
import vista.GUI_EnvioAviso;

public class ControladorAviso extends Conexion {

    public static String email, nombrehijo, apellidohijo, registrocivil, fecha;

    public void enviar(Aviso a) {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        String emisor = "dadisproject@gmail.com";
        String contrasenia = "Dadis123";
        String destinatario = a.getDestinatario();
        String asunto = "Aviso Proxima Vacuna";
        String mensaje = a.getMensaje();

        MimeMessage mail = new MimeMessage(s);

        try {
            mail.setFrom(new InternetAddress(emisor));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport t = s.getTransport("smtp");
            t.connect(emisor, contrasenia);
            t.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            t.close();
            JOptionPane.showMessageDialog(null, "Correo enviado exitosamente");

        } catch (AddressException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void sacarpadre(int i) throws SQLException{
    PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT idpadre from hijo where idhijo=?";
        ps = this.getCon().prepareStatement(SQL);
        ps.setInt(1, GUI_EnvioAviso.idhijo);
        rs = ps.executeQuery();
        if (rs.next()) {
            GUI_EnvioAviso.idpadre = rs.getInt(1);
        }
    }

    public void consultaremail(int idpadre) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT email from padre where idpadre=?";
        ps = this.getCon().prepareStatement(SQL);
        ps.setInt(1, idpadre);
        rs = ps.executeQuery();
        if (rs.next()) {
            email = rs.getString(1);
        }

    }

    public void consultarhijo(int i) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT primer_nombre,primer_apellido,registro_civil from hijo where idhijo=?";

        try {
            ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombrehijo = rs.getString(1);
                apellidohijo = rs.getString(2);
                registrocivil = rs.getString(3);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAviso.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

    public void consultarfechas(int i) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select fecha_proxima from registro_vacunas where idhijo=?";
        try {
            ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                fecha = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAviso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
