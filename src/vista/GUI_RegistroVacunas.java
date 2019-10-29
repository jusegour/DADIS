/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorAdministrador;
import controlador.ControladorDoctor;
import controlador.ControladorHijo;
import controlador.ControladorLogin;
import controlador.ControladorRegistro_Vacuna;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Hijo;

/**
 *
 * @author Estudiante
 */
public class GUI_RegistroVacunas extends javax.swing.JFrame {

    ControladorRegistro_Vacuna ctrlv = new ControladorRegistro_Vacuna();
    ControladorAdministrador ctrl = new ControladorAdministrador();
    ControladorDoctor cd=new ControladorDoctor();
    public static int idhijo, idpadre;
    private static final ImageIcon icono = new ImageIcon(GUI_RegistroVacunas.class.getResource("/imagenes/jeringa.png"));
    Conexion cn = new Conexion();

    public GUI_RegistroVacunas() {
        initComponents();
        this.setIconImage(icono.getImage());
        this.setResizable(false);
        lblnombre.setText(lblnombre.getText()+" "+ControladorLogin.nombredoctor+" "+ControladorLogin.apellidodoctor);
        try{
        cn.conectarme();
        cd.setCon(cn.getCon());
        Image foto = cd.getFoto(ControladorLogin.iddoctor).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon icono=new ImageIcon(foto);
            if (icono!=null) {
                lblfoto.setIcon(icono);
                lblfoto.updateUI();
            }else{
            lblfoto.updateUI();
            }
            
        }catch(Exception e){
        e.printStackTrace();
        }
        
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

        jLabel5 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_hijo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_registro = new javax.swing.JTable();
        lblregistros = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro General de Vacunas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblnombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblnombre.setText("Dr");
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, 30));

        lblfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/padre (2).png"))); // NOI18N
        getContentPane().add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 260));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Registro civil Hijo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 30, 130, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Buscar Hijo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 77, 87, -1));
        jPanel2.add(txtidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 77, 147, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 72, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 400, 140));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fotomurales-ilustracion-de-fondo-suave-de-color-abstracto.jpg.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 700));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 1080, 229));

        tabla_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_registro);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 1080, 259));

        lblregistros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lblregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 230, 20));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1110, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Conexion cn = new Conexion();
        if (txtidentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Digite RC del Hijo");
        }else{
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
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabla_hijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_hijoMouseClicked
        int fila = tabla_hijo.getSelectedRow();
        
        idhijo = Integer.parseInt(tabla_hijo.getValueAt(fila, 0).toString());
        idpadre = Integer.parseInt(tabla_hijo.getValueAt(fila, 11).toString());

        try {
            cn.conectarme();
            ctrlv.setCon(cn.getCon());

            String matriz[][] = new String[ctrlv.consultard().size()][8];
            for (int i = 0; i < ctrlv.consultard().size(); i++) {
                matriz[i][0] = ctrlv.consultard().get(i).getIdregistro();
                matriz[i][1] = ctrlv.consultard().get(i).getFecha_aplicacion();
                matriz[i][2] = ctrlv.consultard().get(i).getIdhijo();
                matriz[i][3] = ctrlv.consultard().get(i).getIdpadre();
                matriz[i][4] = ctrlv.consultard().get(i).getIddoctor();
                matriz[i][5] = ctrlv.consultard().get(i).getIdvacuna();
                matriz[i][6] = ctrlv.consultard().get(i).getFecha_proxima();
                matriz[i][7]=ctrlv.consultard().get(i).getDosis();
            }

            for (int i = 0; i < matriz.length; i++) {
                System.out.println(Arrays.toString(matriz[i]));
            }
            mostrarregistro();

        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }//GEN-LAST:event_tabla_hijoMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GUI_MenuDoctor d = new GUI_MenuDoctor();
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    public void mostrarregistro() throws SQLException {
        String matriz[][] = new String[ctrlv.consultard().size()][19];
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
            matriz[i][18]=ctrlv.listarfechasd().get(i).getDosis();

        }

        tabla_registro.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idhijo", "Nombre-Hijo", "Apellido-Hijo", "Registro Civil", "idpadre", "Nombre-Padre", "Apellido-Padre", "CC-Padre", "iddoctor", "Nombre-Doctor", "Apellido-Doctor", "CC-Doctor", "Clinica", "idvacuna", "Vacuna aplicada", "idregistro", "Fecha aplicacion", "Fecha proxima","Dosis"}));

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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblregistros;
    private javax.swing.JTable tabla_hijo;
    private javax.swing.JTable tabla_registro;
    private javax.swing.JTextField txtidentificacion;
    // End of variables declaration//GEN-END:variables
}
