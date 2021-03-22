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
public class Impresora extends Equipo{
    private String tipo;

    public Impresora(String tipo, String cod, String ubicacion, double precio, boolean protegido) {
        super(cod, ubicacion, precio, protegido);
        this.tipo = tipo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "Impresora{" + "tipo=" + tipo + '}';
    }
    
    
    
}
