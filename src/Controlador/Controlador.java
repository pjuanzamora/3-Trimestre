/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import java.util.ArrayList;

/**
 *
 * @author Juanfran
 */
public class Controlador {
    private ArrayList<Equipo> vEquipos;

    public Controlador() {
        this.vEquipos = new ArrayList();
    }

    public void anadirEquipo(Equipo e) {
       vEquipos.add(e);
    }

    @Override
    public String toString() {
        String texto = "";
        for (Equipo v : vEquipos) {
            texto += v.toString() + "\n";
        }
        return texto ;
    } 
}
