/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorHijo;
import controlador.ControladorRegistro_Vacuna;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Hijo;
import modelo.RegistroVacuna;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_Hijo extends javax.swing.JFrame {
    
    ControladorHijo ctrl = new ControladorHijo();
    ControladorRegistro_Vacuna rv = new ControladorRegistro_Vacuna();
    RegistroVacuna h = new RegistroVacuna();
    Conexion cn = new Conexion();
    Hijo hijo = new Hijo();
    public static int idhijo;
    
    public GUI_Hijo() {
        
        initComponents();
        this.setResizable(false);
        btnRegistro.setEnabled(false);
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
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            mostrarprogramas();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        
    }
    
    public void mostrarprogramas() throws SQLException {
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
        tablaprograma.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idHijo", "primer_nombre", "segundo_nombre", "primer_apellido", "segundo_apellido", "Fecha_nacimiento", "Edad", "Direccion", "estrato", "sexo", "identificacion", "idpadre"}));
        System.out.println(ctrl.listarhijo().size());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        combobuscar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaprograma = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        btnRegistro = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("GESTION DE HIJOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("Listado de Hijos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 31, -1, -1));
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 100, -1));

        combobuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Identificacion", "Primer Nombre", "Primer Apellido", " ", " " }));
        combobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobuscarActionPerformed(evt);
            }
        });
        jPanel2.add(combobuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 32, 73, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 54, 300, 80));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Busqueda");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 34, -1, -1));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaprogramaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tablaprograma);
        tablaprograma.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 960, 101));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 460, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 460, 75, -1));

        btnNuevo.setText("Agregar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 117, -1, -1));

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
        jPanel1.add(txtsapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 414, 103, -1));

        txtsnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsnombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtsnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 347, 103, -1));

        txtpapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpapellidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtpapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 376, 103, -1));
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 501, 103, -1));

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });
        jPanel1.add(txtedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 461, 103, -1));

        txtpnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpnombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtpnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 322, 103, -1));

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));
        jPanel1.add(combo_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 360, 148, -1));

        combo_estrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1\t", "2", "3", "4", "5", "6" }));
        jPanel1.add(combo_estrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 322, 50, -1));

        jLabel9.setText("Primer Nombre");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 322, -1, -1));

        jLabel10.setText("Segundo Nombre");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 350, -1, -1));

        jLabel11.setText("Direccion");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 501, -1, -1));

        jLabel12.setText("Segundo Apellido");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 417, -1, -1));

        txtidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidentificacionKeyTyped(evt);
            }
        });
        jPanel1.add(txtidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 398, 148, -1));

        jLabel13.setText("Primer Apellido");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 379, -1, -1));

        jLabel14.setText("Edad");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 464, -1, -1));

        jLabel15.setText("Estrato");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 325, -1, -1));

        jLabel16.setText("Identificacion");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 401, -1, -1));

        jLabel18.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 297, -1, -1));

        jLabel20.setText("Sexo");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 363, -1, -1));

        jLabel4.setText("Id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 294, -1, -1));

        txtid.setEditable(false);
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 291, 41, -1));
        jPanel1.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 291, -1, -1));

        btnRegistro.setText("Ver Registro de Vacuna");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 117, -1, -1));

        btnMenu.setText("Volver al Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 589, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 1100, 620));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        if (combobuscar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione medoto de busqueda");
        } else {
            
            Conexion cn = new Conexion();
            
            try {
                cn.conectarme();
                ctrl.setCon(cn.getCon());
                ArrayList<Hijo> lista = ctrl.buscarhijos(combobuscar.getSelectedIndex(), txtBuscar.getText().trim());
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
                    
                }
                tablaprograma.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idHijo", "primer_nombre", "segundo_nombre", "primer_apellido", "segundo_apellido", "Fecha_nacimiento", "Edad", "Direccion", "estrato", "sexo", "identificacion", "idpadre"}));
                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    
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
        
        txtidentificacion.setText("");
        
    }
    private void combobuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobuscarActionPerformed

    private void tablaprogramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaprogramaMouseClicked
        btnRegistro.setEnabled(true);
        int filah=tablaprograma.getSelectedRow();
        idhijo = Integer.parseInt(tablaprograma.getValueAt(filah, 0).toString());
        
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
        
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
        int fila = tablaprograma.getSelectedRow();
        txtid.setText(tablaprograma.getValueAt(fila, 0).toString());
        txtpnombre.setText(tablaprograma.getValueAt(fila, 1).toString());
        txtsnombre.setText(tablaprograma.getValueAt(fila, 2).toString());
        txtpapellido.setText(tablaprograma.getValueAt(fila, 3).toString());
        txtsapellido.setText(tablaprograma.getValueAt(fila, 4).toString());
        txtedad.setText(tablaprograma.getValueAt(fila, 6).toString());
        txtdireccion.setText(tablaprograma.getValueAt(fila, 7).toString());
        combo_estrato.setSelectedItem(tablaprograma.getValueAt(fila, 8));
        combo_sexo.setSelectedItem(tablaprograma.getValueAt(fila, 9));
        txtidentificacion.setText(tablaprograma.getValueAt(fila, 10).toString());
        
        System.out.println(idhijo);
        
        try {
            cn.conectarme();
            rv.setCon(cn.getCon());
            
            String matriz[][] = new String[rv.consultar().size()][7];
            for (int i = 0; i < rv.consultar().size(); i++) {
                matriz[i][0] = rv.consultar().get(i).getIdregistro();
                matriz[i][1] = rv.consultar().get(i).getFecha_aplicacion();
                matriz[i][2] = rv.consultar().get(i).getIdhijo();
                matriz[i][3] = rv.consultar().get(i).getIdpadre();
                matriz[i][4] = rv.consultar().get(i).getIddoctor();
                matriz[i][5] = rv.consultar().get(i).getIdvacuna();
                matriz[i][6] = rv.consultar().get(i).getFecha_proxima();
            }
            
            for (int i = 0; i < matriz.length; i++) {
                System.out.println(Arrays.toString(matriz[i]));
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        

    }//GEN-LAST:event_tablaprogramaMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Hijo pa = new Hijo();
        ControladorHijo cp = new ControladorHijo();
        Conexion cn = new Conexion();
        pa.setIdhijo(Integer.parseInt(txtid.getText()));
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
        
        try {
            cn.conectarme();
            cp.setCon(cn.getCon());
            cp.modificar(pa);
            limpiar();
            limpiartabla();
            mostrarprogramas();
            
            JOptionPane.showMessageDialog(this, "REGISTRO ACTUALIZADO EXITOSAMENTE: ", "Gestion de programas academicos", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "NO SE REALIZÓ LA OPERACION ACTUALIZAR: " + e.toString(), "Gestion de programas academicos", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Hijo pa = new Hijo();
        ControladorHijo ctrl = new ControladorHijo();
        Conexion cn = new Conexion();
        pa.setIdhijo(Integer.parseInt(txtid.getText()));
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            ctrl.eliminar(pa);
            limpiar();
            limpiartabla();
            
            mostrarprogramas();
            JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO EXITOSAMENTE: ", "Gestion de programas academicos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "NO SE REALIZÓ LA OPERACION ELIMINAR: " + ex.toString(), "Gestion de programas academicos", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        GUI_AgregarHijo apa = new GUI_AgregarHijo();
        apa.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnNuevoActionPerformed

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

    private void tablaprogramaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaprogramaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaprogramaMouseEntered

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        GUI_ConsultarRegistro cr = new GUI_ConsultarRegistro();
        cr.setVisible(true);
        cr.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        GUI_MenuPadre mp = new GUI_MenuPadre();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Hijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Hijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Hijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Hijo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Hijo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JComboBox<String> combo_estrato;
    private javax.swing.JComboBox<String> combo_sexo;
    private javax.swing.JComboBox<String> combobuscar;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JTable tablaprograma;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidentificacion;
    private javax.swing.JTextField txtpapellido;
    private javax.swing.JTextField txtpnombre;
    private javax.swing.JTextField txtsapellido;
    private javax.swing.JTextField txtsnombre;
    // End of variables declaration//GEN-END:variables
}
