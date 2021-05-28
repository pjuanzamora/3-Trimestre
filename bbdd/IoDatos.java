/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author profesor
 */
public class IoDatos {

    private static String URL = "jdbc:mysql://34.229.80.204:3306/programacion";
    private static String USU = "pepe";
    private static String PASS = "pepe";
   
    
    public static void conectarBBDD(){
       
        
    
         
        try (Connection con =  DriverManager.getConnection(URL, USU, PASS);){

           
            Statement s =  con.createStatement();
            ResultSet sol = s.executeQuery("SELECT * FROM alumno;");
            
            while (sol.next()){
                System.out.println(sol.getString(1) + " -- " + 
                        sol.getInt(2));
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace() ;
            
        } 
        
    }
    
    
    public static javax.swing.table.DefaultTableModel cargarModeloTabla(){
        javax.swing.table.DefaultTableModel mTabla = new DefaultTableModel();
        mTabla.addColumn("Nombre");
        mTabla.addColumn("Edad");
        try (Connection con =  DriverManager.getConnection(URL, USU, PASS);){

           
            Statement s =  con.createStatement();
            ResultSet sol = s.executeQuery("SELECT * FROM alumno;");
            
            while (sol.next()){
               String nombre = sol.getString(1);
               int edad = sol.getInt(2);
               Object[] datos = {nombre, edad};
               mTabla.addRow(datos);
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace() ;
            
        } 
        return mTabla;
    }
    
    public static void insertarDatos(){
         try (Connection con =  DriverManager.getConnection(URL, USU, PASS);){
           Alumno a = new Alumno("Vector2", 55, "Probando vectores");
             //Guardando un vector serializado
            PreparedStatement pt = con.prepareStatement("Insert into alumno values(?,?,?,?)");
            pt.setString(1, a.getNombre());
            pt.setInt(2, a.getEdad());
            pt.setString(3, a.getDireccion());
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(a.getTelefonos());
            
             
            pt.setBytes(4, baos.toByteArray());
            pt.executeUpdate();
             //Fin
           
           
           
            
            
        } catch (Exception ex) {
            ex.printStackTrace() ;
            
        } 
    }
    
    
    public static void crearCampo(String campo){
        
        try ( Connection con = DriverManager.getConnection(URL, USU, PASS);){
           
            String sentencia = "ALTER TABLE alumno ADD COLUMN " + campo + " BLOB;";
            Statement st = con.createStatement();
            
            st.executeUpdate(sentencia);
            
        } catch (SQLException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
   

    public static ArrayList<Alumno> cargarDatosBBBDD() {
       ArrayList<Alumno> vAlumnos = new ArrayList<Alumno>();
       
        try ( Connection con = DriverManager.getConnection(URL, USU, PASS);){
           
            String sent = "Select * from alumno;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sent);
            
            while (rs.next()){
                Object o = rs.getObject(4);
                if (o!=null){
                    ByteArrayInputStream baos = new ByteArrayInputStream(rs.getBytes(4));
                    ObjectInputStream read = new ObjectInputStream(baos);
                    
                    ArrayList<String> v = (ArrayList<String>) read.readObject();
                    System.out.println(v);
                }
                    
              /*    if (v!=null)
                    System.out.println(v);
                /*vAlumnos.add(new Alumno(rs.getString(1),
                        rs.getInt(2), rs.getString(3),
                        (ArrayList<String>)rs.getObject(4)));*/
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       return vAlumnos;
    }
    
    public static void guardarAlumno(Alumno alumno){
        
        try (Connection con = DriverManager.getConnection(URL, USU, PASS);){
            
            String sen = "INSERT INTO alumno (nombre, edad) values (?, ?)";
            
            Statement st = con.createStatement();
            PreparedStatement pt = con.prepareStatement(sen);
            pt.setString(1, alumno.getNombre());
            pt.setInt(2, alumno.getEdad());
            //pt.setString(2, alumno.getDireccion()+"SIIII");
            
            pt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public static void modificarAlumno (){
        
          try (Connection con = DriverManager.getConnection(URL, USU, PASS);){
            
           String sen = "Update alumno set edad = ? where nombre = ?";
           PreparedStatement pt = con.prepareStatement(sen);
           
           pt.setInt(1, 60);
           pt.setString(2, "Adelin");
            
           
           if (pt.executeUpdate() > 0 ){
               System.out.println("Adelin ha cumplido años");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   public  static void borrarAlumno(String nombre) {
         try (Connection con = DriverManager.getConnection(URL, USU, PASS);){
            
           String sen = "delete from alumno where nombre = ?;";
           PreparedStatement pt = con.prepareStatement(sen);
           
           pt.setString(1, nombre);
            
           
           if (pt.executeUpdate() > 0 ){
               System.out.println("Borrado correcto");
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(IoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
