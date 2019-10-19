/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.Hijo;
import modelo.Padre;
import modelo.RegistroVacuna;
import modelo.Vacuna;
import vista.GUI_Doctor;
import vista.GUI_Hijo;
import vista.GUI_RegistroVacunas;

public class ControladorRegistro_Vacuna extends Conexion {

    RegistroVacuna r = new RegistroVacuna();
    Hijo h = new Hijo();
    Vacuna v = new Vacuna();
    Padre p = new Padre();
    Doctor d = new Doctor();

   

    public boolean registrar(RegistroVacuna rg) throws SQLException {

        PreparedStatement ps = null;

        try {

            ps = this.getCon().prepareStatement("INSERT INTO registro_vacunas VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, rg.getFecha_aplicacion());
            ps.setString(3, rg.getIdhijo());
            ps.setString(4, rg.getIdpadre());
            ps.setString(5, rg.getIddoctor());
            ps.setString(6, rg.getIdvacuna());
            ps.setString(7, rg.getFecha_proxima());
            ps.setString(8, "No");

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

    public RegistroVacuna loadregistro(ResultSet et) throws SQLException {
        r.setIdregistro(String.valueOf(et.getInt(1)));
        r.setFecha_aplicacion(et.getString(2));
        r.setIdhijo(String.valueOf(et.getString(3)));
        r.setIdpadre(String.valueOf(et.getInt(4)));
        r.setIddoctor(String.valueOf(et.getInt(5)));
        r.setIdvacuna(String.valueOf(et.getInt(6)));
        r.setFecha_proxima(et.getString(7));

        return r;

    }

    public ArrayList<RegistroVacuna> consultar() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;

        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {

            ps = this.getCon().prepareStatement("SELECT * FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, GUI_Hijo.idhijo);
            rs = ps.executeQuery();
            if (rs.next()) {
                lista.add(loadregistro(rs));
            }
            

        } catch (SQLException s) {
            System.out.println(s);

        }

        return lista;

    }
    public ArrayList<RegistroVacuna> consultard() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;

        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {

            ps = this.getCon().prepareStatement("SELECT * FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, GUI_RegistroVacunas.idhijo);
            rs = ps.executeQuery();
            if (rs.next()) {
                lista.add(loadregistro(rs));
                GUI_RegistroVacunas.lblreg.setText("");
            }else{
            GUI_RegistroVacunas.lblreg.setText("No hay registros");
            }
            

        } catch (SQLException s) {
            System.out.println(s);

        }

        return lista;

    }
   

    public Hijo loadhijo(ResultSet et) throws SQLException {
        h.setIdhijo(et.getInt(1));
        h.setPrimer_nombre(et.getString(2));
        h.setPrimer_apellido(et.getString(3));
        h.setIdentificacion(et.getString(4));

        return h;

    }

    public ArrayList<Hijo> listarhijo() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        try {
            ps = this.getCon().prepareStatement("SELECT idhijo,primer_nombre,primer_apellido,registro_civil FROM hijo WHERE idhijo=? ");

            ps.setInt(1,GUI_Hijo.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadhijo(rs));

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
//        System.out.println(h.getPrimer_nombre());
//        System.out.println(h.getPrimer_apellido());
//        System.out.println(h.getIdentificacion());

        return lista;

    }
    public ArrayList<Hijo> listarhijod() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        try {
            ps = this.getCon().prepareStatement("SELECT idhijo,primer_nombre,primer_apellido,registro_civil FROM hijo WHERE idhijo=? ");

            ps.setInt(1,GUI_RegistroVacunas.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadhijo(rs));

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
//        System.out.println(h.getPrimer_nombre());
//        System.out.println(h.getPrimer_apellido());
//        System.out.println(h.getIdentificacion());

        return lista;

    }

    public Padre loadpadre(ResultSet et) throws SQLException {
        p.setIdpadre(et.getInt(1));
        p.setPrimer_nombre(et.getString(2));
        p.setPrimer_apellido(et.getString(3));
        p.setIdentificacion(et.getString(4));

        return p;

    }

    public ArrayList<Padre> listarpadre() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Padre> lista = new ArrayList<Padre>();
        try {
            ps = this.getCon().prepareStatement("SELECT idpadre,primer_nombre,primer_apellido,identificacion FROM padre WHERE idpadre=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIdpadre()));
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
//        System.out.println(p.getPrimer_nombre());
//        System.out.println(p.getPrimer_apellido());
//        System.out.println(p.getIdentificacion());
        return lista;

    }

    public ArrayList<Padre> listarpadred() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Padre> lista = new ArrayList<Padre>();
        try {
            ps = this.getCon().prepareStatement("SELECT idpadre,primer_nombre,primer_apellido,identificacion FROM padre WHERE idpadre=? ");
            consultar();
            ps.setInt(1, GUI_RegistroVacunas.idpadre);
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
//        System.out.println(p.getPrimer_nombre());
//        System.out.println(p.getPrimer_apellido());
//        System.out.println(p.getIdentificacion());
        return lista;

    }
    public Doctor loaddoctor(ResultSet et) throws SQLException {
        d.setIddoctor(String.valueOf(et.getInt(1)));
        d.setPrimer_nombre(et.getString(2));
        d.setPrimer_apellido(et.getString(3));
        d.setIdentificacion(et.getString(4));
        d.setClinica(et.getString(5));

        return d;

    }

    public ArrayList<Doctor> listardoctor() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        try {
            ps = this.getCon().prepareStatement("SELECT iddoctor,primer_nombre,primer_apellido,identificacion,clinica FROM doctor WHERE iddoctor=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIddoctor()));
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
//        System.out.println(d.getPrimer_nombre());
//        System.out.println(d.getPrimer_apellido());
//        System.out.println(d.getIdentificacion());
        return lista;

    }
    
    public ArrayList<Doctor> listardoctord() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        try {
            ps = this.getCon().prepareStatement("SELECT iddoctor,primer_nombre,primer_apellido,identificacion,clinica FROM doctor WHERE iddoctor=? ");
            consultar();
            ps.setInt(1, ControladorLogin.iddoctor);
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
//        System.out.println(d.getPrimer_nombre());
//        System.out.println(d.getPrimer_apellido());
//        System.out.println(d.getIdentificacion());
        return lista;

    }

    public Vacuna loadvacuna(ResultSet et) throws SQLException {
        v.setIdvacuna(et.getInt(1));
        v.setNombre(et.getString(2));

        return v;

    }

    public ArrayList<Vacuna> listarvacuna() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        try {
            ps = this.getCon().prepareStatement("SELECT idvacuna,nombre FROM vacuna WHERE idvacuna=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIdvacuna()));
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
//        System.out.println(v.getNombre());
        return lista;

    }
    public ArrayList<Vacuna> listarvacunad() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        try {
            ps = this.getCon().prepareStatement("SELECT idvacuna,nombre FROM vacuna WHERE idvacuna=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIdvacuna()));
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
//        System.out.println(v.getNombre());
        return lista;

    }

    public RegistroVacuna loadfechas(ResultSet et) throws SQLException {
        r.setIdregistro(String.valueOf(et.getInt(1)));
        r.setFecha_aplicacion(et.getString(2));
        r.setFecha_proxima(et.getString(3));

        return r;

    }

    public ArrayList<RegistroVacuna> listarfechas() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {
            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas,Fecha,fecha_proxima FROM registro_vacunas WHERE idregistro_vacunas=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIdregistro()));
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadfechas(rs));

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
//        System.out.println(r.getFecha_aplicacion());
//        System.out.println(r.getFecha_proxima());

        return lista;

    }
    public ArrayList<RegistroVacuna> listarfechasd() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {
            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas,Fecha,fecha_proxima FROM registro_vacunas WHERE idregistro_vacunas=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(r.getIdregistro()));
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadfechas(rs));

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
//        System.out.println(r.getFecha_aplicacion());
//        System.out.println(r.getFecha_proxima());

        return lista;

    }

}
