/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Hijo;
import vista.GUI_Padre;

public class ControladorHijo extends Conexion {

    Conexion cone = new Conexion();

    public boolean registrar(Hijo pa) throws SQLException {

        PreparedStatement ps = null;

        try {

            ps = this.getCon().prepareStatement("INSERT INTO hijo VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, pa.getPrimer_nombre());
            ps.setString(3, pa.getSegundo_nombre());
            ps.setString(4, pa.getPrimer_apellido());
            ps.setString(5, pa.getSegundo_apellido());
            ps.setString(6, pa.getFecha_nacimiento());
            ps.setString(7, pa.getEdad());
            ps.setString(8, pa.getDireccion());
            ps.setString(9, pa.getEstrato());
            ps.setString(10, pa.getSexo());
            ps.setString(11, pa.getIdentificacion());
            ps.setInt(12, ControladorLogin.idpadre);

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

    public boolean modificar(Hijo pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "UPDATE hijo SET primer_nombre=?,segundo_nombre=?,primer_apellido=?,segundo_apellido=?,fecha_nacimiento=?,edad=?,direccion=?,estrato=?,Sexo=?,Identificacion=?,idpadre=? WHERE idhijo=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pa.getPrimer_nombre());
            ps.setString(2, pa.getSegundo_nombre());
            ps.setString(3, pa.getPrimer_apellido());
            ps.setString(4, pa.getSegundo_apellido());
            ps.setString(5, pa.getFecha_nacimiento());
            ps.setString(6, pa.getEdad());
            ps.setString(7, pa.getDireccion());
            ps.setString(8, pa.getEstrato());
            ps.setString(9, pa.getSexo());
            ps.setString(10, pa.getIdentificacion());
            ps.setString(11, null);
            ps.setInt(12, pa.getIdhijo());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean eliminar(Hijo pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "DELETE FROM hijo WHERE idhijo=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pa.getIdhijo());

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    private Hijo load(ResultSet et) throws SQLException {
        Hijo pa = new Hijo();
        pa.setIdhijo(et.getInt(1));
        pa.setPrimer_nombre(et.getString(2));
        pa.setSegundo_nombre(et.getString(3));
        pa.setPrimer_apellido(et.getString(4));
        pa.setSegundo_apellido(et.getString(5));
        pa.setFecha_nacimiento(et.getString(6));
        pa.setEdad(et.getString(7));
        pa.setDireccion(et.getString(8));
        pa.setEstrato(et.getString(9));
        pa.setSexo(et.getString(10));
        pa.setIdentificacion(et.getString(11));
        pa.setIdpadre(et.getInt(12));

        return pa;
    }

    public ArrayList<Hijo> listarhijo() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        try {
            ps = this.getCon().prepareStatement("SELECT * FROM hijo where idpadre=?");
            ps.setInt(1, ControladorLogin.idpadre);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(load(rs));

            }
        } catch (SQLException Ignore) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return lista;
    }

    public ArrayList<Hijo> buscarhijos(int item, String Parametro) throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        String sql = "";

        try {
            if (item == 1) {
                sql = "SELECT * FROM hijo WHERE registro_civil=?";
            }
            if (item == 2) {
                sql = "SELECT * FROM hijo WHERE primer_nombre=?";
            }
            if (item == 3) {
                sql = "SELECT * FROM hijo WHERE primer_apellido=?";
            }
            ps = this.getCon().prepareStatement(sql);
            ps.setString(1, Parametro);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(load(rs));

            }

        } catch (SQLException Ignore) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }
        return lista;
    }

    public void actualizaredad(Hijo h) {
        PreparedStatement ps = null;
        String sql = "update hijo set edad=? where idhijo=?";
        try {
            ps = this.getCon().prepareStatement(sql);
            ps.setString(1, h.getEdad());
            ps.setInt(2, h.getIdhijo());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
