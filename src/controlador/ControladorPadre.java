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
import modelo.Padre;
import vista.Login;

public class ControladorPadre extends Conexion {

    Conexion cone = new Conexion();

    public boolean registrar(Padre pa) throws SQLException {

        PreparedStatement ps = null;

        try {

            ps = this.getCon().prepareStatement("INSERT INTO padre VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, pa.getPrimer_nombre());
            ps.setString(3, pa.getSegundo_nombre());
            ps.setString(4, pa.getPrimer_apellido());
            ps.setString(5, pa.getSegundo_apellido());
            ps.setInt(6, pa.getEdad());
            ps.setString(7, pa.getDireccion());
            ps.setString(8, pa.getFecha_nacimiento());
            ps.setString(9, pa.getEstrato());
            ps.setString(10, pa.getSexo());
            ps.setString(11, pa.getIdentificacion());
            ps.setString(12, pa.getEmail());
            ps.setString(13, pa.getUsuario());
            ps.setString(14, pa.getContraseña());
            ps.setString(15, pa.getIdusuario());

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

    public boolean modificar(Padre pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "UPDATE padre SET primer_nombre=?,segundo_nombre=?,primer_apellido=?,segundo_apellido=?,edad=?,direccion=?,fecha_nacimiento=?,estrato=?,sexo=?,identificacion=?,email=?,usuario=?,contraseña=? WHERE idpadre=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pa.getPrimer_nombre());
            ps.setString(2, pa.getSegundo_nombre());
            ps.setString(3, pa.getPrimer_apellido());
            ps.setString(4, pa.getSegundo_apellido());
            ps.setInt(5, pa.getEdad());
            ps.setString(6, pa.getDireccion());
            ps.setString(7, pa.getFecha_nacimiento());
            ps.setString(8, pa.getEstrato());
            ps.setString(9, pa.getSexo());
            ps.setString(10, pa.getIdentificacion());
            ps.setString(11, pa.getEmail());
            ps.setString(12, pa.getUsuario());
            ps.setString(13, pa.getContraseña());
            ps.setInt(14, pa.getIdpadre());
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

    public boolean eliminar(Padre pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "DELETE FROM padre WHERE idpadre=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pa.getIdpadre());

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

    private Padre load(ResultSet et) throws SQLException {
        Padre pa = new Padre();
        pa.setIdpadre(et.getInt(1));
        pa.setPrimer_nombre(et.getString(2));
        pa.setSegundo_nombre(et.getString(3));
        pa.setPrimer_apellido(et.getString(4));
        pa.setSegundo_apellido(et.getString(5));
        pa.setEdad(et.getInt(6));
        pa.setDireccion(et.getString(7));
        pa.setFecha_nacimiento(et.getString(8));
        pa.setEstrato(et.getString(9));
        pa.setSexo(et.getString(10));
        pa.setIdentificacion(et.getString(11));
        pa.setEmail(et.getString(12));
        pa.setUsuario(et.getString(13));
        pa.setContraseña(et.getString(14));

        return pa;
    }

    public ArrayList<Padre> listarpadre() throws SQLException {
        
        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Padre> lista = new ArrayList<Padre>();
        try {
            ps = this.getCon().prepareStatement("SELECT * FROM padre where usuario=?");
            ps.setString(1, Login.user);
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

    public ArrayList<Padre> buscarpadres(int item, String Parametro) throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Padre> lista = new ArrayList<Padre>();
        String sql = "";

        try {
            if (item == 1) {
                sql = "SELECT * FROM padre WHERE identificacion=?";
            }
            if (item == 2) {
                sql = "SELECT * FROM padre WHERE primer_nombre=?";
            }
            if (item == 3) {
                sql = "SELECT * FROM padre WHERE primer_apellido=?";
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

}
