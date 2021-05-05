/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author profesor
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class IoDatos {
    
    public static void guardarDatos(DefaultListModel<Alumno> mAlumno){
        
        JFileChooser ventana = new JFileChooser("./");
        int opc = ventana.showDialog(null, "Aceptar yuju");
        
        if (opc == JFileChooser.APPROVE_OPTION){
            File f = ventana.getSelectedFile();
            
            if (!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try ( FileOutputStream fo = new FileOutputStream(f);
                  ObjectOutputStream escribir = new ObjectOutputStream(fo)){
               
                escribir.writeObject(mAlumno);
                JOptionPane.showMessageDialog(null, "Datos guardados");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        
        
        
    }
    
    public static DefaultListModel<Alumno> cargarDatos(){
        DefaultListModel<Alumno> mAlumno = new DefaultListModel();
        
        JFileChooser ventana = new JFileChooser("./");
        int opc = ventana.showOpenDialog(null);
        
        if (opc == JFileChooser.APPROVE_OPTION){
            File f = ventana.getSelectedFile();
            
            if (!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try (FileInputStream fi = new FileInputStream(f);
                 ObjectInputStream leer = new ObjectInputStream(fi) ){
                
                mAlumno = (DefaultListModel<Alumno>) leer.readObject();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        return mAlumno;
    }
    
}
