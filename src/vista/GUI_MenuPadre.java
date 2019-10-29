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
public class GUI_MenuPadre extends javax.swing.JFrame {

    private static final ImageIcon icono = new ImageIcon(GUI_MenuPadre.class.getResource("/imagenes/jeringa.png"));
    public GUI_MenuPadre() {
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

        btnhijo = new javax.swing.JButton();
        btnpadre = new javax.swing.JButton();
        lblinstrucciones = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhijo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnhijo.setForeground(new java.awt.Color(255, 0, 0));
        btnhijo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chico.png"))); // NOI18N
        btnhijo.setText("Informacion de Hijos");
        btnhijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhijoActionPerformed(evt);
            }
        });
        getContentPane().add(btnhijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, 80));

        btnpadre.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnpadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/padre.png"))); // NOI18N
        btnpadre.setText("Informacion de Padre");
        btnpadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpadreActionPerformed(evt);
            }
        });
        getContentPane().add(btnpadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 260, 80));

        lblinstrucciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblinstrucciones.setForeground(new java.awt.Color(255, 255, 255));
        lblinstrucciones.setText("Presione aqui para ver las Instrucciones");
        lblinstrucciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblinstrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblinstruccionesMouseClicked(evt);
            }
        });
        getContentPane().add(lblinstrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 290, 30));

        btnVolver.setText("Volver al Login");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/blue-wallpaper-24.jpg"))); // NOI18N
        lblfondo.setText("jLabel1");
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhijoActionPerformed
        // TODO add your handling code here:
        GUI_Hijo h=new GUI_Hijo();
        h.setVisible(true);
        h.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnhijoActionPerformed

    private void btnpadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpadreActionPerformed
        // TODO add your handling code here:
        GUI_Padre p=new GUI_Padre();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnpadreActionPerformed

    private void lblinstruccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinstruccionesMouseClicked
        InstruccionPadre ins=new InstruccionPadre();
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblinstruccionesMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Login l=null;
        try {
           l = new Login();
        } catch (ParseException ex) {
            Logger.getLogger(GUI_MenuPadre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI_MenuPadre.class.getName()).log(Level.SEVERE, null, ex);
        }
       l.setVisible(true);
       l.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(GUI_MenuPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_MenuPadre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MenuPadre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnhijo;
    private javax.swing.JButton btnpadre;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblinstrucciones;
    // End of variables declaration//GEN-END:variables
}
