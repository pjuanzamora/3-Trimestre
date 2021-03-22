/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juanfran
 */
public class Equipo {

    protected String cod;
    protected String ubicacion;
    protected double precio;
    protected boolean protegido; //True protegido, False No protegido

    public Equipo(String cod, String ubicacion, double precio, boolean protegido) {
        this.cod = cod;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.protegido = protegido;
    }

    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the protegido
     */
    public boolean isProtegido() {
        return protegido;
    }

    /**
     * @param protegido the protegido to set
     */
    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }

    @Override
    public String toString() {
        return "Equipo{" + "cod=" + cod + ", ubicacion=" + ubicacion + ", precio=" + precio + ", protegido=" + protegido + '}';
    }

}
