/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda;
import java.io.IOException;
import java.util.*;
/**
 * 
 * @author Rubén Garzón
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        int op=7;
        Scanner sc = new Scanner(System.in);
        Agenda agendaTelefonica = new Agenda();
        while(op!=0){
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3.Buscar contacto");
            System.out.println("4.Eliminar contacto");
            System.out.println("5.Cargar agenda");
            System.out.println("6.Guardar agenda");
            System.out.println("7. Salir");
            System.out.println("Elige una opcion: ");
            op=sc.nextInt();
            Scanner entrada = new Scanner(System.in);
            switch (op) {
                case 1:
                      System.out.println("Introduce un nombre: ");
                      String nombre = entrada.nextLine();
                      System.out.println("Introduce un telefono: ");
                      int telefono = entrada.nextInt();
                      Contacto c = new Contacto(nombre, telefono);
                      agendaTelefonica.añadirContacto(c);
                    break;
                case 2:
                        agendaTelefonica.mostrarContacto();
                    break;
                case 3:
                    System.out.println("Introduce un nombre: ");
                    String buscadorNombre = entrada.nextLine();
                    agendaTelefonica.buscarContacto(buscadorNombre);
                    break;
                case 4:
                    System.out.println("Introduce un nombre");
                    String eliminarContacto = entrada.nextLine();
                    agendaTelefonica.eliminarContacto(eliminarContacto);
                    break;
                case 5:
                    agendaTelefonica.cargarAgenda();
                    break;
                
                case 6:
                    agendaTelefonica.guardarAgenda();
                    break;
                    
                case 7:
                        System.exit(0);
                    break;
                    
            }
        }
    }
    
}
