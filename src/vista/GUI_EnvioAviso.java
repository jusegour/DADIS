/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CargarCombos;
import controlador.Conexion;
import controlador.ControladorAviso;
import controlador.ControladorDoctor;
import controlador.ControladorLogin;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Aviso;
import modelo.Hijo;
import modelo.Padre;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_EnvioAviso extends javax.swing.JFrame {

    public static int idhijo,idpadre;
    Hijo h = new Hijo();

    CargarCombos cc = new CargarCombos();
    Conexion con = new Conexion();
    ControladorAviso ca = new ControladorAviso();
    ControladorDoctor ctrld=new ControladorDoctor();
    Aviso a = new Aviso();
    Padre p = new Padre();

    public GUI_EnvioAviso() {
        initComponents();
        this.setResizable(false);
        txtmensaje.setLineWrap(true);
        lblnombre.setText(lblnombre.getText() + " " + ControladorLogin.nombredoctor + " " + ControladorLogin.apellidodoctor);
        try {
            con.conectarme();
            ctrld.setCon(con.getCon());
            Image foto = ctrld.getFoto(ControladorLogin.iddoctor).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icono = new ImageIcon(foto);
            if (icono != null) {
                lblfoto.setIcon(icono);
            } else {
                lblfoto.setIcon(null);
            }
            lblfoto.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtemail.setEditable(false);
        try{
            con.conectarme();
            cc.setCon(con.getCon());
            cc.consultar_hijos(combo_hijos);
        
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo_hijos = new javax.swing.JComboBox<>();
        txtemail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmensaje = new javax.swing.JTextArea();
        btnmenu = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Hijos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        combo_hijos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_hijosItemStateChanged(evt);
            }
        });
        getContentPane().add(combo_hijos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 200, 20));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 200, 20));

        jLabel2.setText("Email Padre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 60, -1));

        jLabel3.setText("Mensaje");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        btnEnviar.setText("Enviar Aviso");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        txtmensaje.setColumns(20);
        txtmensaje.setRows(5);
        jScrollPane1.setViewportView(txtmensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 260, 180));

        btnmenu.setText("Volver al Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));
        getContentPane().add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 190));

        lblnombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblnombre.setText("Dr");
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 150, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotomurales-ilustracion-de-fondo-suave-de-color-abstracto.jpg.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 450));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_hijosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_hijosItemStateChanged
        if (combo_hijos.getSelectedIndex()>0) {
            try{
                con.conectarme();
                ca.setCon(con.getCon());
                char cadena[];
                cadena=combo_hijos.getSelectedItem().toString().toCharArray();
                idhijo=Integer.parseInt(String.valueOf(cadena[0]));
                ca.sacarpadre(idhijo);
                ca.consultaremail(idpadre);
                txtemail.setText(ControladorAviso.email);
                ca.consultarhijo(idhijo);
                ca.consultarfechas(idhijo);
                txtmensaje.setText("Le informamos que "+ControladorAviso.nombrehijo.toUpperCase()+" "
                    + ""+ControladorAviso.apellidohijo.toUpperCase()+", identificado con RC. "+ControladorAviso.registrocivil+
                    ". Tendra su proxima vacuna el dia: "+ControladorAviso.fecha);
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_combo_hijosItemStateChanged

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        a.setDestinatario(txtemail.getText());
        a.setMensaje(txtmensaje.getText());
        ca.enviar(a);
        ca.cambiarestado(idhijo);
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        GUI_MenuDoctor gm=new GUI_MenuDoctor();
        gm.setVisible(true);
        gm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_EnvioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_EnvioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_EnvioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_EnvioAviso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_EnvioAviso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> combo_hijos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextArea txtmensaje;
    // End of variables declaration//GEN-END:variables
}
