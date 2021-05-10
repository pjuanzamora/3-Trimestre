/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

/**
 *
 * @author profesor
 */
public class Alumno {
    private String nombre;
    private int edad;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre  +  "  " + edad; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
