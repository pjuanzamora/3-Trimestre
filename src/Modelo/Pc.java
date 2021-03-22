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
public class Pc extends Equipo{
    private String ssoo;
    private String tipo; //Sobremesa o portatil

    public Pc(String ssoo, String tipo, String cod, String ubicacion, double precio, boolean protegido) {
        super(cod, ubicacion, precio, protegido);
        this.ssoo = ssoo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " Pc{" + "ssoo=" + ssoo + ", tipo=" + tipo + '}';
    }
    
    
    
}
