/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 *
 * @author profesor
 */
public class Alumno {
    private String nombre;
    private int edad;
    private String direccion;
    private ArrayList<String> telefonos;

    public Alumno(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        telefonos = new ArrayList<>();
        
        telefonos.add("111");
        telefonos.add("222");
        telefonos.add("333");
    }

    public Alumno(String nombre, int edad, String direccion, ArrayList<String> telefonos) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }
    
    

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    
    
    @Override
    public String toString() {
        return getNombre() + " - " + getEdad() + " - " +getDireccion(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
