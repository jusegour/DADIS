/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorAdministrador;
import controlador.ControladorHijo;
import controlador.ControladorRegistro_Vacuna;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Hijo;

/**
 *
 * @author Estudiante
 */
public class GUI_RegistroVacunas extends javax.swing.JFrame {

    ControladorRegistro_Vacuna ctrlv = new ControladorRegistro_Vacuna();
    ControladorAdministrador ctrl = new ControladorAdministrador();
    public static int idhijo, idpadre;
    Conexion cn = new Conexion();

    public GUI_RegistroVacunas() {
        initComponents();
        lblreg.setText("");
        tabla_registro.setEnabled(false);
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            mostrarhijos();

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }

    }

    public void mostrarhijos() throws SQLException {
        String matriz[][] = new String[ctrl.listarhijo().size()][12];
        for (int i = 0; i < ctrl.listarhijo().size(); i++) {
            matriz[i][0] = String.valueOf(ctrl.listarhijo().get(i).getIdhijo());
            matriz[i][1] = ctrl.listarhijo().get(i).getPrimer_nombre();
            matriz[i][2] = ctrl.listarhijo().get(i).getSegundo_nombre();
            matriz[i][3] = ctrl.listarhijo().get(i).getPrimer_apellido();
            matriz[i][4] = ctrl.listarhijo().get(i).getSegundo_apellido();
            matriz[i][5] = String.valueOf(ctrl.listarhijo().get(i).getFecha_nacimiento());
            matriz[i][6] = ctrl.listarhijo().get(i).getEdad();
            matriz[i][7] = ctrl.listarhijo().get(i).getDireccion();
            matriz[i][8] = ctrl.listarhijo().get(i).getEstrato();
            matriz[i][9] = ctrl.listarhijo().get(i).getSexo();
            matriz[i][10] = ctrl.listarhijo().get(i).getIdentificacion();
            matriz[i][11] = String.valueOf(ctrl.listarhijo().get(i).getIdpadre());

        }
        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idHijo", "primer_nombre", "segundo_nombre", "primer_apellido", "segundo_apellido", "Fecha_nacimiento", "Edad", "Direccion", "estrato", "sexo", "identificacion", "idpadre"}));
        System.out.println(ctrl.listarhijo().size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_hijo = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_registro = new javax.swing.JTable();
        lblreg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar Hijo");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Registro civil Hijo");

        tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_hijo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_hijoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_hijo);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tabla_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_registro);

        lblreg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblreg.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnBuscar))
                            .addComponent(btnVolver)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblreg, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblreg, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Conexion cn = new Conexion();

        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            ArrayList<Hijo> lista = ctrl.buscarhijos(1, txtidentificacion.getText().trim());
            String matriz[][] = new String[lista.size()][12];
            for (int i = 0; i < lista.size(); i++) {
                matriz[i][0] = String.valueOf(ctrl.listarhijo().get(i).getIdhijo());
                matriz[i][1] = ctrl.listarhijo().get(i).getPrimer_nombre();
                matriz[i][2] = ctrl.listarhijo().get(i).getSegundo_nombre();
                matriz[i][3] = ctrl.listarhijo().get(i).getPrimer_apellido();
                matriz[i][4] = ctrl.listarhijo().get(i).getSegundo_apellido();
                matriz[i][5] = String.valueOf(ctrl.listarhijo().get(i).getFecha_nacimiento());
                matriz[i][6] = ctrl.listarhijo().get(i).getEdad();
                matriz[i][7] = ctrl.listarhijo().get(i).getDireccion();
                matriz[i][8] = ctrl.listarhijo().get(i).getEstrato();
                matriz[i][9] = ctrl.listarhijo().get(i).getSexo();
                matriz[i][10] = ctrl.listarhijo().get(i).getIdentificacion();
                matriz[i][11] = String.valueOf(ctrl.listarhijo().get(i).getIdpadre());

            }
            tabla_hijo.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idHijo", "primer_nombre", "segundo_nombre", "primer_apellido", "segundo_apellido", "Fecha_nacimiento", "Edad", "Direccion", "estrato", "sexo", "identificacion", "idpadre"}));

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GUI_Doctor d = new GUI_Doctor();
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tabla_hijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_hijoMouseClicked
        int fila = tabla_hijo.getSelectedRow();
        idhijo = Integer.parseInt(tabla_hijo.getValueAt(fila, 0).toString());
        idpadre = Integer.parseInt(tabla_hijo.getValueAt(fila, 11).toString());

        try {
            cn.conectarme();
            ctrlv.setCon(cn.getCon());

            String matriz[][] = new String[ctrlv.consultard().size()][7];
            for (int i = 0; i < ctrlv.consultard().size(); i++) {
                matriz[i][0] = ctrlv.consultard().get(i).getIdregistro();
                matriz[i][1] = ctrlv.consultard().get(i).getFecha_aplicacion();
                matriz[i][2] = ctrlv.consultard().get(i).getIdhijo();
                matriz[i][3] = ctrlv.consultard().get(i).getIdpadre();
                matriz[i][4] = ctrlv.consultard().get(i).getIddoctor();
                matriz[i][5] = ctrlv.consultard().get(i).getIdvacuna();
                matriz[i][6] = ctrlv.consultard().get(i).getFecha_proxima();
            }

            for (int i = 0; i < matriz.length; i++) {
                System.out.println(Arrays.toString(matriz[i]));
            }
            mostrarregistro();

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }

    }//GEN-LAST:event_tabla_hijoMouseClicked

    public void mostrarregistro() throws SQLException {
        String matriz[][] = new String[ctrlv.consultard().size()][18];
        for (int i = 0; i < ctrlv.consultard().size(); i++) {
            matriz[i][0] = String.valueOf(ctrlv.listarhijod().get(i).getIdhijo());
            matriz[i][1] = ctrlv.listarhijod().get(i).getPrimer_nombre();
            matriz[i][2] = ctrlv.listarhijod().get(i).getPrimer_apellido();
            matriz[i][3] = ctrlv.listarhijod().get(i).getIdentificacion();
            matriz[i][4] = String.valueOf(ctrlv.listarpadred().get(i).getIdpadre());
            matriz[i][5] = ctrlv.listarpadred().get(i).getPrimer_nombre();
            matriz[i][6] = ctrlv.listarpadred().get(i).getPrimer_apellido();
            matriz[i][7] = ctrlv.listarpadred().get(i).getIdentificacion();
            matriz[i][8] = ctrlv.listardoctord().get(i).getIddoctor();
            matriz[i][9] = ctrlv.listardoctord().get(i).getPrimer_nombre();
            matriz[i][10] = ctrlv.listardoctord().get(i).getPrimer_apellido();
            matriz[i][11] = ctrlv.listardoctord().get(i).getIdentificacion();
            matriz[i][12] = ctrlv.listardoctord().get(i).getClinica();
            matriz[i][13] = String.valueOf(ctrlv.listarvacunad().get(i).getIdvacuna());
            matriz[i][14] = ctrlv.listarvacunad().get(i).getNombre();
            matriz[i][15] = ctrlv.listarfechasd().get(i).getIdregistro();
            matriz[i][16] = ctrlv.listarfechasd().get(i).getFecha_aplicacion();
            matriz[i][17] = ctrlv.listarfechasd().get(i).getFecha_proxima();

        }

        tabla_registro.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idhijo", "Nombre-Hijo", "Apellido-Hijo", "Registro Civil", "idpadre", "Nombre-Padre", "Apellido-Padre", "CC-Padre", "iddoctor", "Nombre-Doctor", "Apellido-Doctor", "CC-Doctor", "Clinica", "idvacuna", "Vacuna aplicada", "idregistro", "Fecha aplicacion", "Fecha proxima"}));

    }

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
            java.util.logging.Logger.getLogger(GUI_RegistroVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_RegistroVacunas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lblreg;
    private javax.swing.JTable tabla_hijo;
    private javax.swing.JTable tabla_registro;
    private javax.swing.JTextField txtidentificacion;
    // End of variables declaration//GEN-END:variables
}
