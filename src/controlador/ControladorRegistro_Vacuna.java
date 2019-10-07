/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.RegistroVacuna;

public class ControladorRegistro_Vacuna extends Conexion {

    public static String idregistro, idhijo, idpadre, iddoctor, idvacuna, fecha_a, fecha_pro;

    public boolean registrar(RegistroVacuna rg) throws SQLException {

        PreparedStatement ps = null;

        try {

            ps = this.getCon().prepareStatement("INSERT INTO registro_vacunas VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, rg.getFecha_aplicacion());
            ps.setString(3, rg.getIdhijo());
            ps.setString(4, rg.getIdpadre());
            ps.setString(5, rg.getIddoctor());
            ps.setString(6, rg.getIdvacuna());
            ps.setString(7, rg.getFecha_proxima());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

    public boolean consultar(RegistroVacuna r) {
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = this.getCon().prepareStatement("SELECT * FROM registro_vacunas WHERE idhijo=?");
            ps.setString(1, r.getIdhijo());
            rs = ps.executeQuery();
            while (rs.next()) {
                idregistro = String.valueOf(rs.getInt(1));
                fecha_a = rs.getString(2);
                idhijo = String.valueOf(rs.getInt(3));
                idpadre = String.valueOf(rs.getInt(4));
                iddoctor = String.valueOf(rs.getInt(5));
                idvacuna = String.valueOf(rs.getInt(6));
                fecha_pro = rs.getString(7);

            }
           
            return true;

        } catch (SQLException s) {
            System.out.println(s);

            return false;

        }
    }

}
