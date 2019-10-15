/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Doctor;
import modelo.Hijo;
import modelo.Padre;
import modelo.Vacuna;
import vista.GUI_Padre;
import vista.Login;

public class ControladorAdministrador extends Conexion {

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
            ps.setInt(12, 0);

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
            ps = this.getCon().prepareStatement("SELECT * FROM hijo");
            ps.setInt(1, GUI_Padre.idpadre);
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

    private Padre loadpadre(ResultSet et) throws SQLException {
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
            ps = this.getCon().prepareStatement("SELECT * FROM padre");

            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadpadre(rs));

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
                lista.add(loadpadre(rs));

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

    private Doctor loaddoctor(ResultSet et) throws SQLException {
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
                lista.add(loaddoctor(rs));

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
                lista.add(loaddoctor(rs));

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

    private Vacuna loadvacuna(ResultSet et) throws SQLException {
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
                lista.add(loadvacuna(rs));

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
                lista.add(loadvacuna(rs));

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
