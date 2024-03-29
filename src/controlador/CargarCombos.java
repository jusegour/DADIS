/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Padre;
import vista.GUI_EnvioAviso;

public class CargarCombos extends Conexion {

    public static int idpadre;

    public void consultar_hijos(JComboBox hijos) throws SQLException {
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT idhijo,primer_nombre,primer_apellido,idpadre FROM hijo ORDER BY idhijo ASC";

        try {
            pst = this.getCon().prepareStatement(SSQL);
            result = pst.executeQuery();

            hijos.addItem("Seleccione Hijo");
            while (result.next()) {

                hijos.addItem(String.valueOf(result.getInt("idhijo") + " " + result.getString("primer_nombre") + " " + result.getString("primer_apellido")));

            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (pst != null) {
                pst.close();
            }
        }

    }

    public void consultar_padres(int idhijo) throws SQLException {
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT idpadre FROM hijo where idhijo=?";

        try {
            pst = this.getCon().prepareStatement(SSQL);
            pst.setInt(1, idhijo);
            result = pst.executeQuery();

            if (result.next()) {

                idpadre = result.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (pst != null) {
                pst.close();
            }
        }

    }

    public void consultar_vacunas(JComboBox vacunas) throws SQLException {
        PreparedStatement pst = null;
        ResultSet result = null;

        String SSQL = "SELECT idvacuna,nombre FROM vacuna ORDER BY idvacuna ASC";

        try {
            pst = this.getCon().prepareStatement(SSQL);
            result = pst.executeQuery();
            vacunas.addItem("Seleccione Vacuna");
            while (result.next()) {

                vacunas.addItem(String.valueOf(result.getInt("idvacuna") + " " + result.getString("nombre")));

            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (pst != null) {
                pst.close();
            }
        }

    }
}
