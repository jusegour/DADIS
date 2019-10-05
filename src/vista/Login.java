/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorLogin;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.Padre;

/**
 *
 * @author PC5
 */
public class Login extends javax.swing.JFrame {
    
    public static String user;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_usuario = new javax.swing.JComboBox<>();
        txtpassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dadis.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/User.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo Usuario: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        combo_usuario.setBackground(new java.awt.Color(0, 0, 51));
        combo_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_usuario.setForeground(new java.awt.Color(255, 255, 255));
        combo_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Doctor", "Padre" }));
        combo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(combo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 160, -1));

        txtpassword.setBackground(new java.awt.Color(0, 0, 51));
        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 160, -1));

        btnIngresar.setBackground(new java.awt.Color(0, 0, 51));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Iniciar Sesion");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contraseña: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        txtusuario.setBackground(new java.awt.Color(0, 0, 51));
        txtusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-wallpaper-24.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_usuarioActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        
        user = txtusuario.getText();
        if (txtusuario.getText().isEmpty() || txtpassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
        } else if (txtusuario.getText().isEmpty() && txtpassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        } else {
            if (combo_usuario.getSelectedIndex() == 2) {
                JFrame ventana = this;
                Padre p = new Padre();
                GUI_Padre gp = new GUI_Padre();
                GUI_AgregarPadre gap = new GUI_AgregarPadre();
                p.setUsuario(txtusuario.getText());
                String pass = new String(txtpassword.getPassword());
                p.setContraseña(pass);
                p.setIdentificacion(user);
                
                ControladorLogin cl = new ControladorLogin();
                Conexion cn = new Conexion();
                
                try {
                    cn.conectarme();
                    cl.setCon(cn.getCon());
                    cl.validadPadre(p, ventana, gp, gap);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else if (combo_usuario.getSelectedIndex() == 1) {
                JFrame ventana = this;
                GUI_Doctor gd = new GUI_Doctor();
                Doctor p = new Doctor();
                p.setUsuario(txtusuario.getText());
                String pass = new String(txtpassword.getPassword());
                p.setContraseña(pass);
                
                ControladorLogin cl = new ControladorLogin();
                Conexion cn = new Conexion();
                
                try {
                    cn.conectarme();
                    cl.setCon(cn.getCon());
                    cl.validadDoctor(p, ventana, gd);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Tipo de Usuario");
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> combo_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
