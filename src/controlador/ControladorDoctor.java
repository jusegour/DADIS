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
import modelo.Doctor;
import modelo.Padre;

public class ControladorDoctor extends Conexion {

    Conexion cone = new Conexion();

    public boolean registrar(Doctor pa) throws SQLException {

        PreparedStatement ps = null;

        
        try {

            ps = this.getCon().prepareStatement("INSERT INTO doctor VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, pa.getPrimer_nombre());
            ps.setString(3, pa.getSegundo_nombre());
            ps.setString(4, pa.getPrimer_apellido());
            ps.setString(5, pa.getSegundo_apellido());
            ps.setString(6, pa.getEdad());
            ps.setString(7, pa.getFecha_nacimiento());
            ps.setString(8, pa.getSexo());
            ps.setString(9, pa.getDireccion());
            ps.setString(10, pa.getEstrato());
            ps.setString(11, pa.getTelefono());
            ps.setString(12, pa.getClinica());
            ps.setString(13, pa.getUsuario());
            ps.setString(14, pa.getContraseña());
            ps.setString(15, pa.getIdentificacion());
            ps.setString(16, pa.getIdusuario());
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

    public boolean modificar(Doctor pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "UPDATE doctor SET primer_nombre=?,segundo_nombre=?,primer_apellido=?,segundo_apellido=?,edad=?,fecha_nacimiento=?,sexo=?,direccion=?,estrato=?,telefono=?,clinica=?,usuario=?,contraseña=?,identificacion=? WHERE iddoctor=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pa.getPrimer_nombre());
            ps.setString(2, pa.getSegundo_nombre());
            ps.setString(3, pa.getPrimer_apellido());
            ps.setString(4, pa.getSegundo_apellido());
            ps.setString(5, pa.getEdad());
            ps.setString(6, pa.getFecha_nacimiento());
            ps.setString(7, pa.getSexo());
            ps.setString(8, pa.getDireccion());
            ps.setString(9, pa.getEstrato());
            ps.setString(10, pa.getTelefono());
            ps.setString(11, pa.getClinica());
            ps.setString(12, pa.getUsuario());
            ps.setString(13, pa.getContraseña());
            ps.setString(14, pa.getIdentificacion());
            ps.setString(15, pa.getIddoctor());
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

    public boolean eliminar(Doctor pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "DELETE FROM doctor WHERE iddoctor=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pa.getIddoctor());

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

    private Doctor load(ResultSet et) throws SQLException {
        Doctor pa = new Doctor();
        pa.setIddoctor(et.getString(1));
        pa.setPrimer_nombre(et.getString(2));
        pa.setSegundo_nombre(et.getString(3));
        pa.setPrimer_apellido(et.getString(4));
        pa.setSegundo_apellido(et.getString(5));
        pa.setEdad(et.getString(6));
        pa.setFecha_nacimiento(et.getString(7));
        pa.setSexo(et.getString(8));
        pa.setDireccion(et.getString(9));
        pa.setEstrato(et.getString(10));
        pa.setTelefono(et.getString(11));
        pa.setClinica(et.getString(12));
        pa.setUsuario(et.getString(13));
        pa.setContraseña(et.getString(14));
        pa.setIdentificacion(et.getString(15));

        return pa;
    }

    public ArrayList<Doctor> listardoctor() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        try {
            ps = this.getCon().prepareStatement("SELECT * FROM doctor");
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

    public ArrayList<Doctor> buscardoctores(int item, String Parametro) throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        String sql = "";

        try {
            if (item == 1) {
                sql = "SELECT * FROM doctor WHERE identificacion=?";
            }
            if (item == 2) {
                sql = "SELECT * FROM doctor WHERE primer_nombre=?";
            }
            if (item == 3) {
                sql = "SELECT * FROM doctor WHERE primer_apellido=?";
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
