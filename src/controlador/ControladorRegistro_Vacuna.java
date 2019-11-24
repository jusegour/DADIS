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
import java.util.Stack;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.Hijo;
import modelo.Padre;
import modelo.RegistroVacuna;
import modelo.Vacuna;
import vista.GUI_BuscarRegistro;
import vista.GUI_Hijo;

public class ControladorRegistro_Vacuna extends Conexion {

    RegistroVacuna r = new RegistroVacuna();
    Hijo h;
    Vacuna v = new Vacuna();
    Padre p;
    Doctor d = new Doctor();
    RegistroVacuna re;
    public static int contador = 0;

    public boolean registrar(RegistroVacuna rg) throws SQLException {

        boolean hecho = false;
        PreparedStatement ps = null;

        try {

            ps = this.getCon().prepareStatement("INSERT INTO registro_vacunas VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, rg.getFecha_aplicacion());
            ps.setString(3, rg.getIdhijo());
            ps.setString(4, rg.getIdpadre());
            ps.setString(5, rg.getIddoctor());
            ps.setString(6, rg.getIdvacuna());
            ps.setString(7, rg.getFecha_proxima());
            ps.setString(8, "No");
            ps.setString(9, rg.getDosis());
            ps.setString(10, rg.getEdad());
            ps.setString(11, rg.getLaboratorio());
            ps.setString(12, rg.getNum_lote());
            ps.setString(13, rg.getIps());

            ps.executeUpdate();
            hecho = true;

        } catch (SQLException e) {
            System.err.println(e);
            hecho = false;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

        return hecho;

    }

    public ArrayList<RegistroVacuna> consultar() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;

        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {

            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas, Fecha,idhijo,idpadre,iddoctor,idvacuna,fecha_proxima,dosis,edad,Laboratorio,numero_lote,IPS FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, GUI_Hijo.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idreg = rs.getInt(1);
                String fecha = rs.getString(2);
                int idhijo = rs.getInt(3);
                int idpadre = rs.getInt(4);
                int iddoctor = rs.getInt(5);
                int idvacuna = rs.getInt(6);
                String fecha_aplicacion = rs.getString(7);
                String dosis = rs.getString(8);
                String edad = rs.getString(9);
                String lab = rs.getString(10);
                int nlote = rs.getInt(11);
                String ips = rs.getString(12);

                re = new RegistroVacuna(idreg, fecha, idhijo, idpadre, iddoctor, idvacuna, fecha_aplicacion, dosis, edad, lab, "" + nlote, ips);

                lista.add(re);

            }

        } catch (SQLException s) {
            System.out.println(s);

        }

        return lista;

    }

    public ArrayList<Hijo> edades() throws SQLException {
        ResultSet rs = null;
        Hijo h;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        String sql = "SELECT edad from registro_vacunas where idhijo=?";
        ps = this.getCon().prepareStatement(sql);
        ps.setInt(1, GUI_Hijo.idhijo);

        rs = ps.executeQuery();
        while (rs.next()) {
            String edad = rs.getString(1);
            h = new Hijo(edad);
            lista.add(h);
        }
        return lista;
    }

    public ArrayList<Vacuna> vacunas() throws SQLException {
        ResultSet rs = null;
        Vacuna v;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        String sql = "SELECT nombre from vacuna where idvacuna=?";
        ps = this.getCon().prepareStatement(sql);
        for (int i = 0; i < consultar().size(); i++) {
            ps.setString(1, consultar().get(i).getIdvacuna());

            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                v = new Vacuna(nombre);
                lista.add(v);
            }
        }
        return lista;
    }

    public ArrayList<RegistroVacuna> dosis() throws SQLException {
        ResultSet rs = null;
        RegistroVacuna r;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        String sql = "SELECT dosis from registro_vacunas where idhijo=?";
        ps = this.getCon().prepareStatement(sql);
        ps.setInt(1, GUI_Hijo.idhijo);

        rs = ps.executeQuery();
        while (rs.next()) {
            String dosis = rs.getString(1);
            r = new RegistroVacuna(dosis);
            lista.add(r);
        }
        return lista;
    }

    public int buscarHijo() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT idhijo from hijo where registro_civil=?";
        int id = 0;

        ps = this.getCon().prepareStatement(sql);
        ps.setString(1, GUI_BuscarRegistro.identificacion);
        rs = ps.executeQuery();

        if (rs.next()) {
            id = rs.getInt(1);
        }

        return id;

    }

    public ArrayList<RegistroVacuna> consultarNuevo() {

        ResultSet rs = null;
        PreparedStatement ps = null;

        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        try {

            ps = this.getCon().prepareStatement("SELECT * FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, buscarHijo());
            rs = ps.executeQuery();

            while (rs.next()) {
                int idreg = rs.getInt(1);
                String fecha = rs.getString(2);
                int idhijo = rs.getInt(3);
                int idpadre = rs.getInt(4);
                int iddoctor = rs.getInt(5);
                int idvacuna = rs.getInt(6);
                String fecha_aplicacion = rs.getString(7);
                String dosis = rs.getString(9);
                String edad = rs.getString(10);
                String lab = rs.getString(11);
                String nlote = rs.getString(12);
                String ips = rs.getString(13);
                re = new RegistroVacuna(idreg, fecha, idhijo, idpadre, iddoctor, idvacuna, fecha_aplicacion, dosis, edad, lab, "" + nlote, ips);

                lista.add(re);

            }

        } catch (SQLException s) {
            System.out.println(s);

        }

        return lista;

    }

    public ArrayList<Hijo> edadesNuevo() throws SQLException {
        ResultSet rs = null;
        Hijo h;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        String sql = "SELECT edad from registro_vacunas where idhijo=?";
        ps = this.getCon().prepareStatement(sql);
        ps.setInt(1, buscarHijo());

        rs = ps.executeQuery();
        while (rs.next()) {
            String edad = rs.getString(1);
            h = new Hijo(edad);
            lista.add(h);
        }
        return lista;
    }

    public ArrayList<Vacuna> vacunasNuevo() throws SQLException {
        ResultSet rs = null;
        Vacuna v;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        String sql = "SELECT nombre from vacuna where idvacuna=?";
        ps = this.getCon().prepareStatement(sql);
        for (int i = 0; i < consultarNuevo().size(); i++) {
            ps.setString(1, consultarNuevo().get(i).getIdvacuna());

            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString(1);
                v = new Vacuna(nombre);
                lista.add(v);
            }
        }
        return lista;
    }

    public ArrayList<RegistroVacuna> dosisNuevo() throws SQLException {
        ResultSet rs = null;
        RegistroVacuna r;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        String sql = "SELECT dosis from registro_vacunas where idhijo=?";
        ps = this.getCon().prepareStatement(sql);
        ps.setInt(1, buscarHijo());

        rs = ps.executeQuery();
        while (rs.next()) {
            String dosis = rs.getString(1);
            r = new RegistroVacuna(dosis);
            lista.add(r);
        }
        return lista;
    }

    public ArrayList<RegistroVacuna> fechas() {
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        RegistroVacuna r;
        String sql = "select Fecha,fecha_proxima from registro_vacunas where idhijo=?";
        try {
            ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, GUI_Hijo.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fecha, fecha_proxima;
                fecha = rs.getString(1);
                fecha_proxima = rs.getString(2);
                r = new RegistroVacuna(fecha, fecha_proxima);
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public ArrayList<RegistroVacuna> fechas_nuevo() {
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        RegistroVacuna r;
        String sql = "select Fecha,fecha_proxima from registro_vacunas where idhijo=?";
        try {
            ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, buscarHijo());
            rs = ps.executeQuery();
            while (rs.next()) {
                String fecha, fecha_proxima;
                fecha = rs.getString(1);
                fecha_proxima = rs.getString(2);
                r = new RegistroVacuna(fecha, fecha_proxima);
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
       public ArrayList<RegistroVacuna> lab_lote_ips() throws SQLException {
        ResultSet rs = null;
        RegistroVacuna r;
        PreparedStatement ps = null;
        String sql = "select Laboratorio,numero_lote,IPS from registro_vacunas where idhijo=?";
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();

        ps = this.getCon().prepareStatement(sql);

        ps.setInt(1, GUI_Hijo.idhijo);
        rs = ps.executeQuery();
        while (rs.next()) {
            String lab, numlote, ips;
            lab = rs.getString(1);
            numlote = rs.getString(2);
            ips = rs.getString(3);
            r = new RegistroVacuna(lab, numlote, ips);
            lista.add(r);
        }
        return lista;
    }

    public ArrayList<RegistroVacuna> lab_lote_ips_nuevo() throws SQLException {
        ResultSet rs = null;
        RegistroVacuna r;
        PreparedStatement ps = null;
        String sql = "select Laboratorio,numero_lote,IPS from registro_vacunas where idhijo=?";
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();

        ps = this.getCon().prepareStatement(sql);

        ps.setInt(1, buscarHijo());
        rs = ps.executeQuery();
        while (rs.next()) {
            String lab, numlote, ips;
            lab = rs.getString(1);
            numlote = rs.getString(2);
            ips = rs.getString(3);
            r = new RegistroVacuna(lab, numlote, ips);
            lista.add(r);
        }
        return lista;
    }

    public ArrayList<Doctor> vacunador() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "SELECT primer_nombre,primer_apellido from doctor where iddoctor=?";
        Doctor d;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();

        ps = this.getCon().prepareStatement(sql);
        for (int i = 0; i < consultar().size(); i++) {
            ps.setInt(1, Integer.parseInt(consultar().get(i).getIddoctor()));
            rs = ps.executeQuery();
            while (rs.next()) {

                String nombre, apellido;
                nombre = rs.getString(1);
                apellido = rs.getString(2);
                d = new Doctor(nombre, apellido);
                lista.add(d);
            }

        }
        return lista;

    }
    public ArrayList<Doctor> vacunador_nuevo() throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "SELECT primer_nombre,primer_apellido from doctor where iddoctor=?";
        Doctor d;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();

        ps = this.getCon().prepareStatement(sql);
        for (int i = 0; i < consultarNuevo().size(); i++) {
            ps.setInt(1, Integer.parseInt(consultarNuevo().get(i).getIddoctor()));
            rs = ps.executeQuery();
            while (rs.next()) {

                String nombre, apellido;
                nombre = rs.getString(1);
                apellido = rs.getString(2);
                d = new Doctor(nombre, apellido);
                lista.add(d);
            }

        }
        return lista;

    }
    
    

//    public int validarVacunasReciennacido(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas2meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas4meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas6meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas7meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas12meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas18meses(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
//
//    public int validarVacunas5anos(int id, String edad) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String sql = "SELECT edad from registro_vacunas where idhijo=? and edad=?";
//        Stack edades = new Stack();
//
//        try {
//            ps = this.getCon().prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.setString(2, edad);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                edades.push(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//
//        return edades.size();
//    }
}
