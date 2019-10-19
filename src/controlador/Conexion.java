/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;

public class Conexion {
 private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/dadis?serverTimezone=UTC";
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void conectarme() throws SQLException {

        try {
            setCon(DriverManager.getConnection(url, "root", ""));
            Class.forName(driver);
        } catch (ClassNotFoundException cl) {
            System.out.println(cl.getMessage());
        }
        
    }
}
