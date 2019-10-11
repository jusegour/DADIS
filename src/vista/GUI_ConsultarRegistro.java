/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorRegistro_Vacuna;
import java.sql.SQLException;

/**
 *
 * @author PC5
 */
public class GUI_ConsultarRegistro extends javax.swing.JFrame {

    ControladorRegistro_Vacuna ctrl = new ControladorRegistro_Vacuna();
    Conexion cn = new Conexion();

    public GUI_ConsultarRegistro() {
        initComponents();
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
        int total=ctrl.listardoctor().size()+ctrl.listarhijo().size()+ctrl.listarpadre().size()+ctrl.listarvacuna().size()+ctrl.listarfechas().size();
        String matriz[][] = new String[ctrl.listarhijo().size()][18];
        for (int i = 0; i <ctrl.listarhijo().size(); i++) {
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

        }

        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idhijo", "Nombre-Hijo", "Apellido-Hijo", "Registro Civil", "idpadre", "Nombre-Padre", "Apellido-Padre", "CC-Padre", "iddoctor", "Nombre-Doctor", "Apellido-Doctor", "CC-Doctor", "Clinica", "idvacuna", "Vacuna aplicada", "idregistro", "Fecha aplicacion", "Fecha proxima"}));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_hijo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_hijo);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(132, 132, 132)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_hijo;
    // End of variables declaration//GEN-END:variables
}
