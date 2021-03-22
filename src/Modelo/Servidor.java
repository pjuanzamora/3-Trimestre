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
public class Servidor extends Equipo{
    private String ssoo;
    private int anoCompra;

    public Servidor(String ssoo, int anoCompra, String cod, String ubicacion, double precio, boolean protegido) {
        super(cod, ubicacion, precio, protegido);
        this.ssoo = ssoo;
        this.anoCompra = anoCompra;
    }

    @Override
    public String toString() {
        return super.toString() + " Servidor{" + "ssoo=" + ssoo + ", anoCompra=" + anoCompra + '}';
    }
    
    
}
