/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorDoctor;
import controlador.ControladorLogin;
import controlador.ControladorPadre;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Doctor;
import modelo.Padre;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_Doctor extends javax.swing.JFrame {

    public static int iddoctor;
    ControladorDoctor ctrl = new ControladorDoctor();
    Conexion c = new Conexion();

    public GUI_Doctor() {
        initComponents();
        this.setResizable(false);
        lblnombre.setText(lblnombre.getText() + " " + ControladorLogin.nombredoctor + " " + ControladorLogin.apellidodoctor);
        try {
            c.conectarme();
            ctrl.setCon(c.getCon());
            Image foto = ctrl.getFoto(ControladorLogin.iddoctor).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
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

        txtid.setEditable(false);
        txtpnombre.setEditable(false);
        txtsnombre.setEditable(false);
        txtpapellido.setEditable(false);
        txtsapellido.setEditable(false);
        txtedad.setEditable(false);
        txtdireccion.setEditable(false);
        fecha_nacimiento.setEnabled(false);
        combo_estrato.setEditable(false);
        combo_sexo.setEditable(false);
        txtidentificacion.setEditable(false);
        combo_clinica.setEditable(false);
        txtusuario.setEditable(false);
        txtcontraseña.setEditable(false);
        txttelefono.setEditable(false);
        btnModificar.setEnabled(false);
        
        Conexion cn = new Conexion();
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            mostrarprogramas();
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        iddoctor = Integer.parseInt(tablaprograma.getValueAt(0, 0).toString());

    }

    public void mostrarprogramas() throws SQLException {
        String matriz[][] = new String[ctrl.listardoctor().size()][15];
        for (int i = 0; i < ctrl.listardoctor().size(); i++) {
            matriz[i][0] = String.valueOf(ctrl.listardoctor().get(i).getIddoctor());
            matriz[i][1] = ctrl.listardoctor().get(i).getPrimer_nombre();
            matriz[i][2] = ctrl.listardoctor().get(i).getSegundo_nombre();
            matriz[i][3] = ctrl.listardoctor().get(i).getPrimer_apellido();
            matriz[i][4] = ctrl.listardoctor().get(i).getSegundo_apellido();
            matriz[i][5] = String.valueOf(ctrl.listardoctor().get(i).getEdad());
            matriz[i][6] = ctrl.listardoctor().get(i).getFecha_nacimiento();
            matriz[i][7] = ctrl.listardoctor().get(i).getSexo();
            matriz[i][8] = ctrl.listardoctor().get(i).getDireccion();
            matriz[i][9] = ctrl.listardoctor().get(i).getEstrato();
            matriz[i][10] = ctrl.listardoctor().get(i).getTelefono();
            matriz[i][11] = ctrl.listardoctor().get(i).getClinica();
            matriz[i][12] = ctrl.listardoctor().get(i).getUsuario();
            matriz[i][13] = ctrl.listardoctor().get(i).getContraseña();
            matriz[i][14] = ctrl.listardoctor().get(i).getIdentificacion();

        }
        tablaprograma.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"iddoctor", "primer_nombre", "segundo_nombre", "primer_apellido", "segundo_apellido", "edad", "fecha_nacimiento", "sexo", "direccion", "estrato", "telefono", "clinica", "usuario", "contraseña", "identificacion"}));
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
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaprograma = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        txtsapellido = new javax.swing.JTextField();
        txtsnombre = new javax.swing.JTextField();
        txtpapellido = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        txtpnombre = new javax.swing.JTextField();
        combo_sexo = new javax.swing.JComboBox<>();
        combo_estrato = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        combo_clinica = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnmenu = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE DOCTORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Listado de Doctores");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaprograma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaprograma.setCellSelectionEnabled(true);
        tablaprograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaprogramaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaprograma);
        tablaprograma.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1040, 180));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, -1, -1));

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
        jPanel5.add(txtsapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 396, 103, -1));

        txtsnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsnombreKeyTyped(evt);
            }
        });
        jPanel5.add(txtsnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 337, 103, -1));

        txtpapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpapellidoKeyTyped(evt);
            }
        });
        jPanel5.add(txtpapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 103, -1));
        jPanel5.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 103, -1));

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });
        jPanel5.add(txtedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 439, 103, -1));

        txtpnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpnombreKeyTyped(evt);
            }
        });
        jPanel5.add(txtpnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 103, -1));

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));
        jPanel5.add(combo_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 148, -1));

        combo_estrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1\t", "2", "3", "4", "5", "6" }));
        jPanel5.add(combo_estrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 50, -1));

        jLabel9.setText("Primer Nombre");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 316, -1, -1));

        jLabel10.setText("Segundo Nombre");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 340, -1, -1));

        jLabel11.setText("Direccion");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 473, -1, -1));

        jLabel12.setText("Segundo Apellido");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 399, -1, -1));

        txtidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidentificacionKeyTyped(evt);
            }
        });
        jPanel5.add(txtidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 148, -1));

        jLabel13.setText("Primer Apellido");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 365, -1, -1));
        jPanel5.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 148, -1));

        jLabel14.setText("Edad");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 442, -1, -1));

        jLabel15.setText("Estrato");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 319, -1, -1));
        jPanel5.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 148, -1));

        jLabel16.setText("Identificacion");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 391, -1, -1));

        jLabel17.setText("Usuario");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 463, -1, -1));

        jLabel18.setText("Fecha de Nacimiento");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel19.setText("Contraseña");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 504, -1, -1));

        jLabel20.setText("Sexo");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 355, -1, -1));

        jLabel21.setText("Clinica");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 427, -1, -1));

        jLabel4.setText("Id");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        txtid.setEditable(false);
        jPanel5.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 41, -1));
        jPanel5.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        combo_clinica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "CLINICA DEL NORTE", "CLINICA MADRE BERNARDA" }));
        jPanel5.add(combo_clinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 86, -1));

        jLabel5.setText("Telefono");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 528, -1, -1));
        jPanel5.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 103, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 670));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1210, 670));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmenu.setText("Volver al Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, -1, -1));

        lblnombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblnombre.setText("Dr");
        jPanel1.add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 181, -1));

        lblfoto.setBackground(new java.awt.Color(255, 255, 255));
        lblfoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 160, 200));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotomurales-ilustracion-de-fondo-suave-de-color-abstracto.jpg.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 260, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 670));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiartabla() {
        DefaultTableModel df = (DefaultTableModel) tablaprograma.getModel();
        int a = tablaprograma.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            df.removeRow(df.getRowCount() - 1);
        }
    }

    public void limpiar() {
        txtid.setText("");
        txtpnombre.setText("");
        txtsnombre.setText("");
        txtpapellido.setText("");;
        txtsapellido.setText("");
        txtedad.setText("");
        txtdireccion.setText("");
        combo_sexo.setSelectedIndex(0);
        combo_estrato.setSelectedIndex(0);

        txttelefono.setText("");
        txtidentificacion.setText("");
        combo_clinica.setSelectedIndex(0);
        txtusuario.setText("");
        txtcontraseña.setText("");
    }
    private void tablaprogramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaprogramaMouseClicked
        // TODO add your handling code here:

        txtpnombre.setEditable(true);
        txtsnombre.setEditable(true);
        txtpapellido.setEditable(true);
        txtsapellido.setEditable(true);
        txtedad.setEditable(true);
        txtdireccion.setEditable(true);
        fecha_nacimiento.setEnabled(true);
        combo_estrato.setEditable(true);
        combo_sexo.setEditable(true);
        txtidentificacion.setEditable(true);
        combo_clinica.setEditable(true);
        txtusuario.setEditable(true);
        txtcontraseña.setEditable(true);
        txttelefono.setEditable(true);
        btnModificar.setEnabled(true);
        

        int fila = tablaprograma.getSelectedRow();
        txtid.setText(tablaprograma.getValueAt(fila, 0).toString());
        txtpnombre.setText(tablaprograma.getValueAt(fila, 1).toString());
        txtsnombre.setText(tablaprograma.getValueAt(fila, 2).toString());
        txtpapellido.setText(tablaprograma.getValueAt(fila, 3).toString());
        txtsapellido.setText(tablaprograma.getValueAt(fila, 4).toString());
        txtedad.setText(tablaprograma.getValueAt(fila, 5).toString());
        combo_sexo.setSelectedItem(tablaprograma.getValueAt(fila, 7));

        txtdireccion.setText(tablaprograma.getValueAt(fila, 8).toString());
        combo_estrato.setSelectedItem(tablaprograma.getValueAt(fila, 9));
        txttelefono.setText(tablaprograma.getValueAt(fila, 10).toString());
        combo_clinica.setSelectedItem(tablaprograma.getValueAt(fila, 11).toString());

        txtusuario.setText(tablaprograma.getValueAt(fila, 12).toString());
        txtcontraseña.setText(tablaprograma.getValueAt(fila, 13).toString());
        txtidentificacion.setText(tablaprograma.getValueAt(fila, 14).toString());


    }//GEN-LAST:event_tablaprogramaMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Doctor pa = new Doctor();
        ControladorDoctor cp = new ControladorDoctor();
        Conexion cn = new Conexion();
        pa.setIddoctor(txtid.getText());
        pa.setPrimer_nombre(txtpnombre.getText());
        pa.setSegundo_nombre(txtsnombre.getText());
        pa.setPrimer_apellido(txtpapellido.getText());
        pa.setSegundo_apellido(txtsapellido.getText());
        pa.setEdad(txtedad.getText());
        pa.setDireccion(txtdireccion.getText());
        pa.setFecha_nacimiento(fecha_nacimiento.getDate().toString());
        pa.setEstrato(combo_estrato.getSelectedItem().toString());
        pa.setSexo(combo_sexo.getSelectedItem().toString());
        pa.setIdentificacion(txtidentificacion.getText());
        pa.setClinica(combo_clinica.getSelectedItem().toString());
        pa.setUsuario(txtusuario.getText());
        String valorPass = new String(txtcontraseña.getPassword());
        pa.setContraseña(valorPass);
        pa.setTelefono(txttelefono.getText());

        try {
            cn.conectarme();
            cp.setCon(cn.getCon());
            cp.modificar(pa);
            limpiar();
            limpiartabla();
            mostrarprogramas();

            JOptionPane.showMessageDialog(this, "REGISTRO ACTUALIZADO EXITOSAMENTE: ", "DADIS", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "NO SE REALIZÓ LA OPERACION ACTUALIZAR: " + e.toString(), "DADIS", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtedadKeyTyped

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
    }//GEN-LAST:event_txtidentificacionKeyTyped

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        GUI_MenuDoctor md = new GUI_MenuDoctor();
        md.setVisible(true);
        md.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JComboBox<String> combo_clinica;
    private javax.swing.JComboBox<String> combo_estrato;
    private javax.swing.JComboBox<String> combo_sexo;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTable tablaprograma;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidentificacion;
    private javax.swing.JTextField txtpapellido;
    private javax.swing.JTextField txtpnombre;
    private javax.swing.JTextField txtsapellido;
    private javax.swing.JTextField txtsnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
