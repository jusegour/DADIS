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
import modelo.Vacuna;
public class ControladorVacuna extends Conexion{
    
    Conexion cone = new Conexion();

    public boolean registrar(Vacuna pa) throws SQLException {

        PreparedStatement ps = null;

        
        try {

            ps = this.getCon().prepareStatement("INSERT INTO vacuna VALUES(?,?)");
            ps.setString(1, null);
            ps.setString(2, pa.getNombre());
            
            
            
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

    public boolean modificar(Vacuna pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "UPDATE vacuna SET nombre=? WHERE idvacuna=?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pa.getNombre());
            
            ps.setInt(2, pa.getIdvacuna());
            
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

    public boolean eliminar(Vacuna pa) {

        PreparedStatement ps = null;
        Connection con = getCon();

        String query = "DELETE FROM vacuna WHERE idvacuna=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pa.getIdvacuna());

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

    private Vacuna load(ResultSet et) throws SQLException {
        Vacuna pa = new Vacuna();
        pa.setIdvacuna(et.getInt(1));
        pa.setNombre(et.getString(2));
        
        

        return pa;
    }

    public ArrayList<Vacuna> listarvacuna() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        try {
            ps = this.getCon().prepareStatement("SELECT * FROM vacuna");
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

    public ArrayList<Vacuna> buscarvacunas(int item, String Parametro) throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        String sql = "";

        try {
            if (item == 1) {
                sql = "SELECT * FROM vacuna WHERE nombre=?";
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
