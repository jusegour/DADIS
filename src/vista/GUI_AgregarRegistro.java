/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CargarCombos;
import controlador.Conexion;
import controlador.ControladorDoctor;
import controlador.ControladorHijo;
import controlador.ControladorLogin;
import controlador.ControladorRegistro_Vacuna;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Hijo;
import modelo.RegistroVacuna;

/**
 *
 * @author PC5
 */
public class GUI_AgregarRegistro extends javax.swing.JFrame {

    ControladorDoctor ctrl = new ControladorDoctor();
    ControladorRegistro_Vacuna ctrlv = new ControladorRegistro_Vacuna();
    ControladorHijo ch = new ControladorHijo();
    Conexion con = new Conexion();
    CargarCombos cc = new CargarCombos();
    Hijo h = new Hijo();
    int idhijo = 0;
    private static final ImageIcon icono = new ImageIcon(GUI_AgregarRegistro.class.getResource("/imagenes/jeringa.png"));

    public GUI_AgregarRegistro() {
        initComponents();
        this.setIconImage(icono.getImage());
        this.setResizable(false);
        lblnombre.setText(lblnombre.getText() + " " + ControladorLogin.nombredoctor + " " + ControladorLogin.apellidodoctor);
        try {
            con.conectarme();
            ctrl.setCon(con.getCon());
            Image foto = ctrl.getFoto(ControladorLogin.iddoctor).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icono = new ImageIcon(foto);
            if (icono != null) {
                lblfoto.setIcon(icono);
                lblfoto.updateUI();
            } else {
                lblfoto.updateUI();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        spin_dia.setValue(1);
        dia_prox.setValue(1);
        spin_dia.setMinimum(1);
        spin_dia.setMaximum(31);
        anio.setMinimum(2019);

        dia_prox.setMinimum(1);
        dia_prox.setMaximum(31);
        anio_prox.setMinimum(2019);

        try {
            con.conectarme();
            cc.setCon(con.getCon());
            cc.consultar_hijos(combo_hijos);

            cc.consultar_vacunas(combo_vacunas);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isNumeric(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_hijos = new javax.swing.JComboBox<>();
        combo_vacunas = new javax.swing.JComboBox<>();
        spin_dia = new com.toedter.components.JSpinField();
        anio = new com.toedter.calendar.JYearChooser();
        mes = new com.toedter.calendar.JMonthChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dia_prox = new com.toedter.components.JSpinField();
        anio_prox = new com.toedter.calendar.JYearChooser();
        mes_prox = new com.toedter.calendar.JMonthChooser();
        txtdosis = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_edad = new javax.swing.JComboBox<>();
        txtlaboratorio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtips = new javax.swing.JTextField();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione un Hijo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel3.setText("Seleccione la vacuna aplicada");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jLabel4.setText("Fecha de Aplicacion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        getContentPane().add(combo_hijos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 255, -1));

        getContentPane().add(combo_vacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 182, -1));
        getContentPane().add(spin_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 45, -1));
        getContentPane().add(anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 63, -1));
        getContentPane().add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, -1));

        jLabel5.setText("Dia");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jLabel6.setText("Mes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        jLabel7.setText("Año");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, -1, -1));

        jLabel8.setText("Dia");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        jLabel9.setText("Mes");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        jLabel10.setText("Año");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        jLabel11.setText("Fecha Proxima Vacuna");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));
        getContentPane().add(dia_prox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 47, -1));
        getContentPane().add(anio_prox, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, 63, -1));
        getContentPane().add(mes_prox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));
        getContentPane().add(txtdosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 180, -1));

        btnRegistrar.setText("Agregar Registro");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        jLabel14.setText("Laboratorio");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        jLabel12.setText("Dosis");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel13.setText("Edad");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        lblfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/padre (2).png"))); // NOI18N
        getContentPane().add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 150));

        lblnombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblnombre.setText("Dr");
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotomurales-ilustracion-de-fondo-suave-de-color-abstracto.jpg.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 640));

        combo_edad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recien Nacido", "2 meses", "4 meses", "6 meses", "7 meses", "12 meses", "18 meses ", "5 años" }));
        combo_edad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_edadItemStateChanged(evt);
            }
        });
        getContentPane().add(combo_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));
        getContentPane().add(txtlaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 130, 20));

        jLabel15.setText("Numero de Lote");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));
        getContentPane().add(txtlote, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 130, 20));

        jLabel16.setText("IPS");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, -1));
        getContentPane().add(txtips, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 120, -1));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 630, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        Conexion con = new Conexion();
        ControladorRegistro_Vacuna ctrl = new ControladorRegistro_Vacuna();

        //SACAR EL id
        String hijo = combo_hijos.getSelectedItem().toString();
        String id = "";
        for (int i = 0; i < hijo.length(); i++) {
            if (isNumeric(String.valueOf(hijo.charAt(i)))) {
                id += hijo.charAt(i);
            }
        }

        idhijo = Integer.parseInt(id);

        try {
            con.conectarme();
            ctrl.setCon(con.getCon());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

        String edad = combo_edad.getSelectedItem().toString();

        if (combo_hijos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un hijo");
        } else if (combo_vacunas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una vacuna");
        } else if (txtdosis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la dosis");
        } else if(txtlaboratorio.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese el Laboratorio");
        } else if(txtlote.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Digite el numero de lote");
        } else if(txtips.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Digite la IPS");
        } else {

            try {
                con.conectarme();
                cc.setCon(con.getCon());
                cc.consultar_padres(idhijo);
            } catch (SQLException ex) {
                Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            String vacuna = combo_vacunas.getSelectedItem().toString();
            String idv = "";
            for (int i = 0; i < vacuna.length(); i++) {
                if (isNumeric(String.valueOf(vacuna.charAt(i)))) {
                    idv += vacuna.charAt(i);
                }
            }

            RegistroVacuna rg = new RegistroVacuna();

            h.setIdhijo(idhijo);
            try {
                con.conectarme();
                ctrl.setCon(con.getCon());

                rg.setIdhijo(id);
                rg.setIdpadre(String.valueOf(CargarCombos.idpadre));
                rg.setIddoctor(String.valueOf(ControladorLogin.iddoctor));
                rg.setIdvacuna(idv);
                rg.setFecha_aplicacion(spin_dia.getValue() + "/" + (mes.getMonth() + 1) + "/" + anio.getYear());
                rg.setFecha_proxima(dia_prox.getValue() + "/" + (mes_prox.getMonth() + 1) + "/" + anio_prox.getYear());
                rg.setDosis(txtdosis.getText());
                rg.setEdad(combo_edad.getSelectedItem().toString());
                h.setIdhijo(idhijo);
                h.setEdad(combo_edad.getSelectedItem().toString());
                rg.setLaboratorio(txtlaboratorio.getText());
                rg.setNum_lote(txtlote.getText());
                rg.setIps(txtips.getText());
                try {

                    con.conectarme();
                    ctrl.setCon(con.getCon());
                    ch.setCon(con.getCon());
                    ch.actualizaredad(h);
                    if (ctrl.registrar(rg)) {
                        JOptionPane.showMessageDialog(null, "REGISTRADO EXITOSAMENTE");
                    }

                } catch (SQLException e) {
                    System.out.println(e.toString());
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GUI_MenuDoctor rv = new GUI_MenuDoctor();
        rv.setVisible(true);
        rv.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void combo_edadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_edadItemStateChanged

    }//GEN-LAST:event_combo_edadItemStateChanged

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
            java.util.logging.Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_AgregarRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser anio;
    private com.toedter.calendar.JYearChooser anio_prox;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> combo_edad;
    private javax.swing.JComboBox<String> combo_hijos;
    private javax.swing.JComboBox<String> combo_vacunas;
    private com.toedter.components.JSpinField dia_prox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    private com.toedter.calendar.JMonthChooser mes;
    private com.toedter.calendar.JMonthChooser mes_prox;
    private com.toedter.components.JSpinField spin_dia;
    private javax.swing.JTextField txtdosis;
    private javax.swing.JTextField txtips;
    private javax.swing.JTextField txtlaboratorio;
    private javax.swing.JTextField txtlote;
    // End of variables declaration//GEN-END:variables
}
