/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rubén
 */
public class Agenda {

    private static final int TAMANO = 10;
    private final ArrayList<Contacto> listaContactos;
    

    public Agenda() {
        this.listaContactos = new ArrayList<>(TAMANO);
    }

    public void añadirContacto(Contacto c) { // añade contactos
            listaContactos.add(c);
    }
    
    public void mostrarContacto() { // para recorrer el arraylist listaContactos y mostrarlo
           for (Contacto c: listaContactos) {
                System.out.println(c.toString());
           }
    }

    public boolean existirContacto(String nombre){ // para que no deje crear un contacto existente
        for (Contacto c: listaContactos) {
                if(nombre.equals(c.getNombre())){
                  return true;  
                }
           }
        return false;
    }
    
    public void buscarContacto(String nombre){
        for (Contacto c: listaContactos){
                if(nombre.equals(c.getNombre())){
                    System.out.println(c.getTelefono()); 
                }
           }
    }
    
    public void eliminarContacto(String nombre){
        for (Contacto c: listaContactos){
                if(nombre.equals(c.getNombre())){
                    listaContactos.remove(c);
                    break;
                }
           }
    }
    
    public void cargarAgenda(){
        String cadena;
        File archivo = new File ("C:/agenda.txt");
        try {
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
             while ((cadena = b.readLine())!= null) {
                System.out.println(cadena);
             }
        } catch (FileNotFoundException ex){
            System.out.println("Fichero no existe");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void guardarAgenda() throws IOException{
        File archivo = new File ("C:/agenda.txt");
        try{
            FileWriter f = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(f);
            for (Contacto c: listaContactos){
                bw.write(c.getNombre() + "\n" + c.getTelefono() + "\r\n");
            }
            bw.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}