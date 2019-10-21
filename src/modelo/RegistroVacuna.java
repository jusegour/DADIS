/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class RegistroVacuna {

    private String idpadre, idhijo, idvacuna, iddoctor, fecha_aplicacion, fecha_proxima, idregistro;
    
    public RegistroVacuna(int idreg,String fecha,int idhijo,int idpadre,int iddoctor,int idvacuna,String fecha_aplicacion){
    this.idregistro=String.valueOf(idreg);
    this.fecha_aplicacion=fecha;
    this.idhijo=String.valueOf(idhijo);
    this.idpadre=String.valueOf(idpadre);
    this.iddoctor=String.valueOf(iddoctor);
    this.idvacuna=String.valueOf(idvacuna);
    this.fecha_proxima=fecha_aplicacion;
    }
    public RegistroVacuna(){
    
    }
    public RegistroVacuna(int idreg,String fecha,String fecha_ap){
    this.idregistro=String.valueOf(idreg);
    this.fecha_aplicacion=fecha;
    this.fecha_proxima=fecha_ap;
    }

    public String getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(String idregistro) {
        this.idregistro = idregistro;
    }

    public String getIdpadre() {
        return idpadre;
    }

    public void setIdpadre(String idpadre) {
        this.idpadre = idpadre;
    }

    public String getIdhijo() {
        return idhijo;
    }

    public void setIdhijo(String idhijo) {
        this.idhijo = idhijo;
    }

    public String getIdvacuna() {
        return idvacuna;
    }

    public void setIdvacuna(String idvacuna) {
        this.idvacuna = idvacuna;
    }

    public String getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(String iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getFecha_proxima() {
        return fecha_proxima;
    }

    public void setFecha_proxima(String fecha_proxima) {
        this.fecha_proxima = fecha_proxima;
    }

}
