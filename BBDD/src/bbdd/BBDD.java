/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.util.ArrayList;

/**
 *
 * @author profesor
 */
public class BBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //IoDatos.conectarBBDD();
       //IoDatos.crearCampo("telefonos");
       //IoDatos.insertarDatos();
       
       // IoDatos.modificarAlumno();
        ArrayList<Alumno> vAlumnos = IoDatos.cargarDatosBBBDD();
       // System.out.println(vAlumnos);
        
        //Alumno alum = new Alumno(nombre, 0, direccion)
      // Alumno alum = new Alumno("Adelin", 22, "Avenida Aragon");
      // IoDatos.guardarAlumno(alum);
    }
    
}
