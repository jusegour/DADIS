/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_MenuDoctor extends javax.swing.JFrame {

    private static final ImageIcon icono = new ImageIcon(GUI_MenuDoctor.class.getResource("/imagenes/jeringa.png"));
    public GUI_MenuDoctor() {
        initComponents();
        this.setIconImage(icono.getImage());
        this.setResizable(false);
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

        btninformacion = new javax.swing.JButton();
        btnvacunas = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btnAviso = new javax.swing.JButton();
        lblinstrucciones = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninformacion.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btninformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctor.png"))); // NOI18N
        btninformacion.setText("Informacion de Doctor");
        btninformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninformacionActionPerformed(evt);
            }
        });
        getContentPane().add(btninformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        btnvacunas.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnvacunas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jeringa.png"))); // NOI18N
        btnvacunas.setText("Informacion de Vacunas");
        btnvacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvacunasActionPerformed(evt);
            }
        });
        getContentPane().add(btnvacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 260, -1));

        btnconsultar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seo.png"))); // NOI18N
        btnconsultar.setText("Consultar Registros de Vacunas");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 300, 70));

        btnagregar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-file.png"))); // NOI18N
        btnagregar.setText("Agregar Registro de Vacuna");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        btnAviso.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnAviso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/email.png"))); // NOI18N
        btnAviso.setText("Enviar Aviso");
        btnAviso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvisoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        lblinstrucciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblinstrucciones.setForeground(new java.awt.Color(255, 255, 255));
        lblinstrucciones.setText("Presione aqui para ver las Instrucciones");
        lblinstrucciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblinstrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblinstruccionesMouseClicked(evt);
            }
        });
        getContentPane().add(lblinstrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 290, 30));

        btnVolver.setText("Volver al Login");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-wallpaper-24.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninformacionActionPerformed
        // TODO add your handling code here:
        GUI_Doctor d=new GUI_Doctor();
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btninformacionActionPerformed

    private void btnvacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvacunasActionPerformed
        // TODO add your handling code here:
        GUI_Vacuna v=new GUI_Vacuna();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnvacunasActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
        GUI_BuscarRegistro rv=new GUI_BuscarRegistro();
        rv.setVisible(true);
        rv.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        GUI_AgregarRegistro ar=new GUI_AgregarRegistro();
        ar.setVisible(true);
        ar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnAvisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvisoActionPerformed
        GUI_EnvioAviso e=new GUI_EnvioAviso();
        e.setVisible(true);
        e.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnAvisoActionPerformed

    private void lblinstruccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinstruccionesMouseClicked
        InstruccionDoctor ins=new InstruccionDoctor();
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblinstruccionesMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Login l=null;
        try {
            l = new Login();
        } catch (ParseException ex) {
            Logger.getLogger(GUI_MenuDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_MenuDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        l.setVisible(true);
        l.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MenuDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAviso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btninformacion;
    private javax.swing.JButton btnvacunas;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblinstrucciones;
    // End of variables declaration//GEN-END:variables
}
