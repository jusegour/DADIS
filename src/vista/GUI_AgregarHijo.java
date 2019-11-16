/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorHijo;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Hijo;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_AgregarHijo extends javax.swing.JFrame {

    private static final ImageIcon icono = new ImageIcon(GUI_AgregarHijo.class.getResource("/imagenes/jeringa.png"));
    public GUI_AgregarHijo() {
        initComponents();
        this.setIconImage(icono.getImage());
        this.setResizable(false);
        
    }

    public void limpiar() {

        txtpnombre.setText("");
        txtsnombre.setText("");
        txtpapellido.setText("");;
        txtsapellido.setText("");
       
        txtdireccion.setText("");

        txtidentificacion.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtsapellido = new javax.swing.JTextField();
        txtsnombre = new javax.swing.JTextField();
        txtpapellido = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtpnombre = new javax.swing.JTextField();
        combo_sexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        combo_estrato = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        lblfond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsapellidoActionPerformed(evt);
            }
        });
        txtsapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsapellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txtsapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 208, 103, -1));

        txtsnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsnombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtsnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 141, 103, -1));

        txtpapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpapellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txtpapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 103, -1));
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 103, -1));

        txtpnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpnombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtpnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 116, 103, -1));

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));
        getContentPane().add(combo_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 179, 148, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("HIJOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, -1, -1));

        combo_estrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1\t", "2", "3", "4", "5", "6" }));
        getContentPane().add(combo_estrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 141, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Agregar Hijo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 65, -1, -1));

        txtidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidentificacionKeyTyped(evt);
            }
        });
        getContentPane().add(txtidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 217, 148, -1));

        jLabel9.setText("Primer Nombre");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 116, -1, -1));

        jLabel10.setText("Segundo Nombre");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 144, -1, -1));

        jLabel11.setText("Direccion");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel12.setText("Segundo Apellido");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 211, -1, -1));

        jLabel13.setText("Primer Apellido");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 173, -1, -1));

        jLabel15.setText("Estrato");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 144, -1, -1));

        jLabel16.setText("Identificacion");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 220, -1, -1));

        jLabel18.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 116, -1, -1));

        jLabel20.setText("Sexo");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 182, -1, -1));

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 405, -1, -1));

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 405, -1, -1));

        fecha_nacimiento.setDateFormatString("yyyy-MMM-dd");
        getContentPane().add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 110, -1, -1));

        lblfond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsapellidoActionPerformed

    private void txtsapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsapellidoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtsapellidoKeyTyped

    private void txtsnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsnombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtsnombreKeyTyped

    private void txtpapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpapellidoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtpapellidoKeyTyped

    private void txtpnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpnombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtpnombreKeyTyped

    private void txtidentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificacionKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
        
        if (validar<'0') {
            evt.consume();
        }
        if (txtidentificacion.getText().length()==10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtidentificacionKeyTyped

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        Hijo pa = new Hijo();

        if (txtpnombre.getText().isEmpty() || txtsnombre.getText().isEmpty() || txtpapellido.getText().isEmpty()
                || txtsapellido.getText().isEmpty() || txtdireccion.getText().isEmpty()
                || combo_estrato.getSelectedIndex() == 0 || combo_sexo.getSelectedIndex() == 0 || txtidentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");

        } else {
            pa.setPrimer_nombre(txtpnombre.getText());
            pa.setSegundo_nombre(txtsnombre.getText());
            pa.setPrimer_apellido(txtpapellido.getText());
            pa.setSegundo_apellido(txtsapellido.getText());
            
            pa.setDireccion(txtdireccion.getText());
            String fecha = "";

            try {
                String formato = fecha_nacimiento.getDateFormatString();
                Date date = fecha_nacimiento.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                fecha = String.valueOf(sdf.format(date));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Al menos elija una FECHA DE NACIMIENTO VALIDA ", "Error..!!", JOptionPane.ERROR_MESSAGE);

            }
            pa.setFecha_nacimiento(fecha);
            pa.setEstrato(combo_estrato.getSelectedItem().toString());
            pa.setSexo(combo_sexo.getSelectedItem().toString());
            pa.setIdentificacion(txtidentificacion.getText());

            ControladorHijo ctrl = new ControladorHijo();
            Conexion con = new Conexion();

            try {
                con.conectarme();
                ctrl.setCon(con.getCon());
                ctrl.registrar(pa);
                JOptionPane.showMessageDialog(null, "REGISTRADO EXITOSAMENTE");
                limpiar();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        GUI_Hijo p = new GUI_Hijo();
        this.dispose();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(GUI_AgregarHijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarHijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarHijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarHijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_AgregarHijo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> combo_estrato;
    private javax.swing.JComboBox<String> combo_sexo;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblfond;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtidentificacion;
    private javax.swing.JTextField txtpapellido;
    private javax.swing.JTextField txtpnombre;
    private javax.swing.JTextField txtsapellido;
    private javax.swing.JTextField txtsnombre;
    // End of variables declaration//GEN-END:variables
}
