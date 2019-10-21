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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Hijo h ;
    Vacuna v = new Vacuna();
    Padre p ;
    Doctor d = new Doctor();
    RegistroVacuna re;
    public static int contador = 0;

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
        r.setIdhijo(String.valueOf(et.getInt(3)));
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

            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas, Fecha,idhijo,idpadre,iddoctor,idvacuna,fecha_proxima FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, GUI_Hijo.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
               int idreg=rs.getInt(1);
               String fecha=rs.getString(2);
               int idhijo=rs.getInt(3);
               int idpadre=rs.getInt(4);
               int iddoctor=rs.getInt(5);
               int idvacuna=rs.getInt(6);
               String fecha_aplicacion=rs.getString(7);
               
               re=new RegistroVacuna(idreg,fecha,idhijo,idpadre,iddoctor,idvacuna,fecha_aplicacion);
               
               lista.add(re);
               

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

            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas, Fecha,idhijo,idpadre,iddoctor,idvacuna,fecha_proxima FRoM registro_vacunas WHERE idhijo in (SELECT idhijo FROM registro_vacunas where idhijo=? GROUP BY idhijo HAVING count(*)>0)");
            ps.setInt(1, GUI_RegistroVacunas.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(loadregistro(rs));
                GUI_RegistroVacunas.lblreg.setText("");
            }

        } catch (SQLException s) {
            System.out.println(s);

        }

        return lista;

    }

    

    public ArrayList<Hijo> listarhijo() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Hijo> lista = new ArrayList<Hijo>();
        for (int i = 0; i < consultar().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idhijo,primer_nombre,primer_apellido,registro_civil FROM hijo WHERE idhijo=? ");

            ps.setInt(1, Integer.parseInt(consultar().get(i).getIdhijo()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idhijo=rs.getInt(1);
                String pnombre=rs.getString(2);
                String papellido=rs.getString(3);
                String rc=rs.getString(4);
                h= new Hijo(idhijo,pnombre,papellido,rc);
                lista.add(h);

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
        for (int i = 0; i < consultard().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idhijo,primer_nombre,primer_apellido,registro_civil FROM hijo WHERE idhijo=? ");

            ps.setInt(1, GUI_RegistroVacunas.idhijo);
            rs = ps.executeQuery();
            while (rs.next()) {
               int idhijo=rs.getInt(1);
               String pnombre=rs.getString(2);
               String papellido=rs.getString(3);
               String rc=rs.getString(4);
               h=new Hijo(idhijo,pnombre,papellido,rc);
               lista.add(h);

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
        }
//        System.out.println(h.getPrimer_nombre());
//        System.out.println(h.getPrimer_apellido());
//        System.out.println(h.getIdentificacion());

        return lista;

    }

    

    public ArrayList<Padre> listarpadre() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Padre> lista = new ArrayList<Padre>();
        for (int i = 0; i < consultar().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idpadre,primer_nombre,primer_apellido,identificacion FROM padre WHERE idpadre=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultar().get(i).getIdpadre()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idpadre=rs.getInt(1);
                String pnombre=rs.getString(2),papellido=rs.getString(3),identificacion=rs.getString(4);
                p=new Padre(idpadre,pnombre,papellido,identificacion);
                lista.add(p);

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
        for (int i = 0; i < consultard().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idpadre,primer_nombre,primer_apellido,identificacion FROM padre WHERE idpadre=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultard().get(i).getIdpadre()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idpadre=rs.getInt(1);
                String pnombre=rs.getString(2),papellido=rs.getString(3),identificacion=rs.getString(4);
                p=new Padre(idpadre,pnombre,papellido,identificacion);
                lista.add(p);
                

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
        }
//        System.out.println(p.getPrimer_nombre());
//        System.out.println(p.getPrimer_apellido());
//        System.out.println(p.getIdentificacion());
        return lista;

    }



    public ArrayList<Doctor> listardoctor() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Doctor> lista = new ArrayList<Doctor>();
        for (int i = 0; i < consultar().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT iddoctor,primer_nombre,primer_apellido,identificacion,clinica FROM doctor WHERE iddoctor=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultar().get(i).getIddoctor()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int iddoctor=rs.getInt(1);
                String pnombre=rs.getString(2),papellido=rs.getString(3),identificacion=rs.getString(4);
                d=new Doctor(iddoctor,pnombre,papellido,identificacion);
                lista.add(d);
                

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
        for (int i = 0; i < consultard().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT iddoctor,primer_nombre,primer_apellido,identificacion,clinica FROM doctor WHERE iddoctor=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultard().get(i).getIddoctor()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int iddoctor=rs.getInt(1);
                String pnombre=rs.getString(2),papellido=rs.getString(3),identificacion=rs.getString(4);
                d=new Doctor(iddoctor,pnombre,papellido,identificacion);
                lista.add(d);

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
        }
//        System.out.println(d.getPrimer_nombre());
//        System.out.println(d.getPrimer_apellido());
//        System.out.println(d.getIdentificacion());
        return lista;

    }

    

    public ArrayList<Vacuna> listarvacuna() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        for (int i = 0; i < consultar().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idvacuna,nombre FROM vacuna WHERE idvacuna=? ");
            
            ps.setInt(1, Integer.parseInt(consultar().get(i).getIdvacuna()));
            rs = ps.executeQuery();
            while (rs.next()) {
               int idvacuna=rs.getInt(1);
               String nombre=rs.getString(2);
               v=new Vacuna(idvacuna,nombre);
               lista.add(v);

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
        }
//        System.out.println(v.getNombre());
        return lista;

    }

    public ArrayList<Vacuna> listarvacunad() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<Vacuna> lista = new ArrayList<Vacuna>();
        for (int i = 0; i < consultard().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idvacuna,nombre FROM vacuna WHERE idvacuna=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultard().get(i).getIdvacuna()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idvacuna=rs.getInt(1);
                String nombre=rs.getString(2);
                v=new Vacuna(idvacuna,nombre);
                lista.add(v);

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
        }
//        System.out.println(v.getNombre());
        return lista;

    }

    

    public ArrayList<RegistroVacuna> listarfechas() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        for (int i = 0; i < consultar().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas,Fecha,fecha_proxima FROM registro_vacunas WHERE idregistro_vacunas=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultar().get(i).getIdregistro()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idregistro=rs.getInt(1);
                String fecha=rs.getString(2);
                String fecha_proxima=rs.getString(3);
                r=new RegistroVacuna(idregistro,fecha,fecha_proxima);
                lista.add(r);

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
        }
//        System.out.println(r.getFecha_aplicacion());
//        System.out.println(r.getFecha_proxima());

        return lista;

    }

    public ArrayList<RegistroVacuna> listarfechasd() throws SQLException {

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
        for (int i = 0; i < consultard().size(); i++) {
            try {
            ps = this.getCon().prepareStatement("SELECT idregistro_vacunas,Fecha,fecha_proxima FROM registro_vacunas WHERE idregistro_vacunas=? ");
            consultar();
            ps.setInt(1, Integer.parseInt(consultard().get(i).getIdregistro()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int idreg=rs.getInt(1);
                String fecha_ap=rs.getString(2),fecha_pro=rs.getString(3);
                r=new RegistroVacuna(idreg,fecha_ap,fecha_pro);
                lista.add(r);

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
        }
//        System.out.println(r.getFecha_aplicacion());
//        System.out.println(r.getFecha_proxima());

        return lista;

    }

}
