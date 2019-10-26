/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.ControladorHijo;
import controlador.ControladorVacuna;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Hijo;
import modelo.Vacuna;

/**
 *
 * @author JUAN S. GOMEZ URIBE
 */
public class GUI_Vacuna extends javax.swing.JFrame {
ControladorVacuna ctrl=new ControladorVacuna();
    public GUI_Vacuna() {
        initComponents();
        this.setResizable(false);
        txtid.setEnabled(false);
        txtnombre.setEditable(false);
        
        
        Conexion cn = new Conexion();
        try {
            cn.conectarme();
            ctrl.setCon(cn.getCon());
            mostrarprogramas();
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    
    public void mostrarprogramas() throws SQLException {
        String matriz[][] = new String[ctrl.listarvacuna().size()][3];
        for (int i = 0; i < ctrl.listarvacuna().size(); i++) {
            matriz[i][0] = String.valueOf(ctrl.listarvacuna().get(i).getIdvacuna());
            matriz[i][1] = ctrl.listarvacuna().get(i).getNombre();

        }
        tablaprograma.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idvacuna", "Nombre"}));
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
        txtnombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnmenu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("GESTION DE VACUNAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("Listado de Vacunas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        combobuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Nombre" }));
        combobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobuscarActionPerformed(evt);
            }
        });
        jPanel2.add(combobuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 32, 73, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 320, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 300, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel3.setText("Busqueda");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 543, 101));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 75, -1));

        btnNuevo.setText("Registrar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 103, -1));

        jLabel10.setText("Nombre");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel4.setText("Id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtid.setEditable(false);
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 41, -1));

        btnmenu.setText("Volver al menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 630, 510));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Blanco.jpg"))); // NOI18N
        jPanel1.add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -60, 630, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 580, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {

            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        GUI_AgregarVacuna apa = new GUI_AgregarVacuna();
        apa.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Vacuna pa = new Vacuna();
        ControladorVacuna ctrl = new ControladorVacuna();
        Conexion cn = new Conexion();
        pa.setIdvacuna(Integer.parseInt(txtid.getText()));
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Vacuna pa = new Vacuna();
        ControladorVacuna cp = new ControladorVacuna();
        Conexion cn = new Conexion();
        pa.setIdvacuna(Integer.parseInt(txtid.getText()));
        pa.setNombre(txtnombre.getText());
        

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

    private void tablaprogramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaprogramaMouseClicked
        // TODO add your handling code here:
        

        
        txtnombre.setEditable(true);

        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        int fila = tablaprograma.getSelectedRow();
        txtid.setText(tablaprograma.getValueAt(fila, 0).toString());
        txtnombre.setText(tablaprograma.getValueAt(fila, 1).toString());
        
        
    }//GEN-LAST:event_tablaprogramaMouseClicked

    private void combobuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (combobuscar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione medoto de busqueda");
        } else {

            Conexion cn = new Conexion();

            try {
                cn.conectarme();
                ctrl.setCon(cn.getCon());
                ArrayList<Vacuna> lista = ctrl.buscarvacunas(combobuscar.getSelectedIndex(), txtBuscar.getText().trim());
                String matriz[][] = new String[lista.size()][3];
                for (int i = 0; i < lista.size(); i++) {
                    matriz[i][0] = String.valueOf(ctrl.listarvacuna().get(i).getIdvacuna());
                    matriz[i][1] = ctrl.listarvacuna().get(i).getNombre();
                    
                    

                }
                tablaprograma.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]{"idVacuna", "Nombre"}));

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
       GUI_MenuDoctor gd=new GUI_MenuDoctor();
       gd.setVisible(true);
       gd.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

   public void limpiartabla() {
        DefaultTableModel df = (DefaultTableModel) tablaprograma.getModel();
        int a = tablaprograma.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            df.removeRow(df.getRowCount() - 1);
        }
    }

    public void limpiar() {
        txtid.setText("");
        txtnombre.setText("");
        
        

        

    }
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
            java.util.logging.Logger.getLogger(GUI_Vacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Vacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Vacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Vacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Vacuna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnmenu;
    private javax.swing.JComboBox<String> combobuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JTable tablaprograma;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
