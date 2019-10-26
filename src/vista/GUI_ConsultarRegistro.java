/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorLogin;
import controlador.ControladorPadre;
import controlador.ControladorRegistro_Vacuna;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author PC5
 */
public class GUI_ConsultarRegistro extends javax.swing.JFrame {

    ControladorRegistro_Vacuna ctrl = new ControladorRegistro_Vacuna();
    Conexion cn = new Conexion();
    ControladorPadre ctrlp=new ControladorPadre();

    public GUI_ConsultarRegistro() {
        initComponents();
        this.setResizable(false);
        lblnombre.setText(lblnombre.getText() + " " + ControladorLogin.nombrepadre + " " + ControladorLogin.apellidopadre);
        try {
            cn.conectarme();
            ctrlp.setCon(cn.getCon());
            Image foto = ctrlp.getFoto(ControladorLogin.idpadre).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
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
        tabla_hijo.setEnabled(false);
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            mostrarregistro();
            

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void mostrarregistro() throws SQLException {

        String matriz[][] = new String[ctrl.consultar().size()][19];
        for (int i = 0; i <ctrl.consultar().size(); i++) {
            matriz[i][0] = String.valueOf(ctrl.listarhijo().get(i).getIdhijo());
            matriz[i][1] = ctrl.listarhijo().get(i).getPrimer_nombre();
            matriz[i][2] = ctrl.listarhijo().get(i).getPrimer_apellido();
            matriz[i][3] = ctrl.listarhijo().get(i).getIdentificacion();
            matriz[i][4] = String.valueOf(ctrl.listarpadre().get(i).getIdpadre());
            matriz[i][5] = ctrl.listarpadre().get(i).getPrimer_nombre();
            matriz[i][6] = ctrl.listarpadre().get(i).getPrimer_apellido();
            matriz[i][7] = ctrl.listarpadre().get(i).getIdentificacion();
            matriz[i][8] = ctrl.listardoctor().get(i).getIddoctor();
            matriz[i][9] = ctrl.listardoctor().get(i).getPrimer_nombre();
            matriz[i][10] = ctrl.listardoctor().get(i).getPrimer_apellido();
            matriz[i][11] = ctrl.listardoctor().get(i).getIdentificacion();
            matriz[i][12] = ctrl.listardoctor().get(i).getClinica();
            matriz[i][13] = String.valueOf(ctrl.listarvacuna().get(i).getIdvacuna());
            matriz[i][14] = ctrl.listarvacuna().get(i).getNombre();
            matriz[i][15] = ctrl.listarfechas().get(i).getIdregistro();
            matriz[i][16] = ctrl.listarfechas().get(i).getFecha_aplicacion();
            matriz[i][17] = ctrl.listarfechas().get(i).getFecha_proxima();
            matriz[i][18]=ctrl.listarfechas().get(i).getDosis();

        }

        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idhijo", "Nombre-Hijo", "Apellido-Hijo", "Registro Civil", "idpadre", "Nombre-Padre", "Apellido-Padre", "CC-Padre", "iddoctor", "Nombre-Doctor", "Apellido-Doctor", "CC-Doctor", "Clinica", "idvacuna", "Vacuna aplicada", "idregistro", "Fecha aplicacion", "Fecha proxima","Dosis"}));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_hijo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_hijo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1340, 249));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, -1, -1));
        getContentPane().add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 160));

        lblnombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblnombre.setText("Sr");
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 190, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotomurales-ilustracion-de-fondo-suave-de-color-abstracto.jpg.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 250));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GUI_Hijo h = new GUI_Hijo();
        h.setVisible(true);
        h.setLocationRelativeTo(null);
        this.dispose();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_ConsultarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ConsultarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ConsultarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ConsultarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ConsultarRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTable tabla_hijo;
    // End of variables declaration//GEN-END:variables
}
