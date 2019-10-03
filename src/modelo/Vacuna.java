/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Vacuna {

    private int idvacuna;
    private String nombre, dosis;

    public int getIdvacuna() {
        return idvacuna;
    }

    public void setIdvacuna(int idvacuna) {
        this.idvacuna = idvacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

}
