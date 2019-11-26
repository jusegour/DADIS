/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorRegistro_Vacuna;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rosme
 */
public class GUI_Nuevo extends javax.swing.JFrame {

    ControladorRegistro_Vacuna ctrl = new ControladorRegistro_Vacuna();
    Conexion con = new Conexion();

    public GUI_Nuevo() {
        initComponents();
        tabla_edad.setOpaque(false);
        tabla_vacuna.setOpaque(false);
        tabla_dosis.setOpaque(false);
        fecha_aplicacion.setOpaque(false);
        laboratorios.setOpaque(false);
        lotes.setOpaque(false);
        ips.setOpaque(false);
        fecha_proxima.setOpaque(false);
        vacunador.setOpaque(false);
        ((DefaultTableCellRenderer) tabla_edad.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) tabla_vacuna.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) tabla_dosis.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) fecha_aplicacion.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) laboratorios.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) lotes.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) ips.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) fecha_proxima.getDefaultRenderer(Object.class)).setOpaque(false);
        ((DefaultTableCellRenderer) vacunador.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);

        jScrollPane3.setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);

        jScrollPane5.setOpaque(false);
        jScrollPane5.getViewport().setOpaque(false);

        jScrollPane6.setOpaque(false);
        jScrollPane6.getViewport().setOpaque(false);

        jScrollPane7.setOpaque(false);
        jScrollPane7.getViewport().setOpaque(false);

        jScrollPane8.setOpaque(false);
        jScrollPane8.getViewport().setOpaque(false);

        jScrollPane9.setOpaque(false);
        jScrollPane9.getViewport().setOpaque(false);

        jScrollPane10.setOpaque(false);
        jScrollPane10.getViewport().setOpaque(false);

        try {
            con.conectarme();
            ctrl.setCon(con.getCon());
            cargaredades();
            cargarvacunas();
            cargardosis();
            cargarfecha_aplicacion();
            laboratorios();
            n_lotes();
            ips();
            cargarfecha_proxima();
            vacunador();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void laboratorios() throws SQLException {
        String matriz[][] = new String[ctrl.lab_lote_ips().size()][1];
        for (int i = 0; i < ctrl.lab_lote_ips().size(); i++) {
            matriz[i][0] = ctrl.lab_lote_ips().get(i).getLaboratorio();
        }
        laboratorios.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void vacunador() throws SQLException {
        String matriz[][] = new String[ctrl.vacunador().size()][1];
        for (int i = 0; i < ctrl.vacunador().size(); i++) {
            matriz[i][0] = ctrl.vacunador().get(i).getPrimer_nombre() + " " + ctrl.vacunador().get(i).getPrimer_apellido();
        }
        vacunador.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void n_lotes() throws SQLException {
        String matriz[][] = new String[ctrl.lab_lote_ips().size()][1];
        for (int i = 0; i < ctrl.lab_lote_ips().size(); i++) {
            matriz[i][0] = ctrl.lab_lote_ips().get(i).getNum_lote();
        }
        lotes.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void ips() throws SQLException {
        String matriz[][] = new String[ctrl.lab_lote_ips().size()][1];
        for (int i = 0; i < ctrl.lab_lote_ips().size(); i++) {
            matriz[i][0] = ctrl.lab_lote_ips().get(i).getIps();
        }
        ips.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void cargarfecha_aplicacion() throws SQLException {
        String matriz[][] = new String[ctrl.fechas().size()][1];
        for (int i = 0; i < ctrl.fechas().size(); i++) {
            matriz[i][0] = ctrl.fechas().get(i).getFecha_aplicacion();
        }
        fecha_aplicacion.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void cargarfecha_proxima() throws SQLException {
        String matriz[][] = new String[ctrl.fechas().size()][1];
        for (int i = 0; i < ctrl.fechas().size(); i++) {
            matriz[i][0] = ctrl.fechas().get(i).getFecha_proxima();
        }
        fecha_proxima.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void cargaredades() throws SQLException {
        String matriz[][] = new String[ctrl.edades().size()][1];
        for (int i = 0; i < ctrl.edades().size(); i++) {
            matriz[i][0] = ctrl.edades().get(i).getEdad();
        }
        tabla_edad.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void cargarvacunas() throws SQLException {
        String matriz[][] = new String[ctrl.vacunas().size()][1];
        for (int i = 0; i < ctrl.vacunas().size(); i++) {
            matriz[i][0] = ctrl.vacunas().get(i).getNombre();
        }
        tabla_vacuna.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    public void cargardosis() throws SQLException {
        String matriz[][] = new String[ctrl.dosis().size()][1];
        for (int i = 0; i < ctrl.dosis().size(); i++) {
            matriz[i][0] = ctrl.dosis().get(i).getDosis();
        }
        tabla_dosis.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{""}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        fecha_aplicacion = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_dosis = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_edad = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vacuna = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        lotes = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        laboratorios = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        ips = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        fecha_proxima = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        vacunador = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 0, 490));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 20, 500));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 10, 490));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 10, 490));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 10, 490));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 10, 490));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 10, 490));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Laboratorio");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha de Aplicacion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dosis");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Me protege de");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("IPS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha Proxima");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Vacunador");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 20, -1, -1));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 10, 490));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("N° de Lote");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fecha_aplicacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fecha_aplicacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(fecha_aplicacion);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 200, 440));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        tabla_dosis.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabla_dosis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_dosis);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 140, 440));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_edad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabla_edad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tabla_edad.setOpaque(false);
        jScrollPane1.setViewportView(tabla_edad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 90, 440));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_vacuna.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tabla_vacuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_vacuna);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 270, 440));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lotes.setBackground(new java.awt.Color(255, 255, 255));
        lotes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(lotes);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 140, 440));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        laboratorios.setBackground(new java.awt.Color(255, 255, 255));
        laboratorios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        laboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(laboratorios);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 140, 440));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ips.setBackground(new java.awt.Color(255, 255, 255));
        ips.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(ips);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 130, 440));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fecha_proxima.setBackground(new java.awt.Color(255, 255, 255));
        fecha_proxima.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fecha_proxima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(fecha_proxima);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 150, 440));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        vacunador.setBackground(new java.awt.Color(255, 255, 255));
        vacunador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        vacunador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(vacunador);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 50, 140, 440));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/negro.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 50));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/negro.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 810, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/niños.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GUI_Hijo h = new GUI_Hijo();
        h.setVisible(true);
        h.setLocationRelativeTo(null);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Nuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Nuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JTable fecha_aplicacion;
    private javax.swing.JTable fecha_proxima;
    private javax.swing.JLabel fondo;
    private javax.swing.JTable ips;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable laboratorios;
    private javax.swing.JTable lotes;
    private javax.swing.JTable tabla_dosis;
    private javax.swing.JTable tabla_edad;
    private javax.swing.JTable tabla_vacuna;
    private javax.swing.JTable vacunador;
    // End of variables declaration//GEN-END:variables
}
