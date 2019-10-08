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
    public static int idhijo;

    public GUI_Hijo() {
        
        initComponents();
        tablaprograma.setEnabled(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("GESTION DE HIJOS");

        jLabel2.setText("Listado de Hijos");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        combobuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Identificacion", "Primer Nombre", "Primer Apellido", " ", " " }));
        combobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(combobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnBuscar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Busqueda");

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

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Agregar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

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

        txtsnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsnombreKeyTyped(evt);
            }
        });

        txtpapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpapellidoKeyTyped(evt);
            }
        });

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        txtpnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpnombreKeyTyped(evt);
            }
        });

        combo_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino" }));

        combo_estrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1\t", "2", "3", "4", "5", "6" }));

        jLabel9.setText("Primer Nombre");

        jLabel10.setText("Segundo Nombre");

        jLabel11.setText("Direccion");

        jLabel12.setText("Segundo Apellido");

        txtidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidentificacionKeyTyped(evt);
            }
        });

        jLabel13.setText("Primer Apellido");

        jLabel14.setText("Edad");

        jLabel15.setText("Estrato");

        jLabel16.setText("Identificacion");

        jLabel18.setText("Fecha de Nacimiento");

        jLabel20.setText("Sexo");

        jLabel4.setText("Id");

        txtid.setEditable(false);

        btnRegistro.setText("Ver Registro de Vacuna");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(1018, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(52, 52, 52)
                        .addComponent(btnRegistro)
                        .addGap(151, 151, 151))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtpapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(combo_sexo, 0, 148, Short.MAX_VALUE)
                        .addComponent(txtidentificacion)
                        .addComponent(combo_estrato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(264, 264, 264))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistro))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18)
                    .addComponent(fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(combo_estrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(combo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(txtsnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(txtpapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtsapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtpnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        idhijo=Integer.parseInt(txtid.getText());
        System.out.println(idhijo);
        try{
            cn.conectarme();
            rv.setCon(cn.getCon());
            rv.consultar();
            
        
        }catch(SQLException e){
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
        GUI_ConsultarRegistro cr=new GUI_ConsultarRegistro();
        cr.setVisible(true);
        cr.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
