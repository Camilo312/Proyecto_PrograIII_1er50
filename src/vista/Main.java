package vista;

import Control.Gestion;
import logic.ArbolLibros;
import logic.ListaCircular;
import logic.Nodo;
import model.Libro;

import javax.swing.*;
/**
 * Clase que permite correr la aplicacion
 * @version  19/12/21
 * @author Deisy Monroy y Karen Hernández
 */
public class Main {

    /**
     *Metodo que corre el menu
     * @param args de tipo String
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     *Metodo que muestra el menu
     */
    public static void menu() {
        Gestion gestion = new Gestion();
        int op;
        String idLibro;
        String titulo;
        String autor;
        String menu;

        try {
            do {

                menu = "";
                menu += "****** Menú ******\n";
                menu += "1.- Agregar libro \n";
                menu += "2.- Eliminar libro \n";
                menu += "3.- Buscar libro \n";
                menu += "4.- Mostrar lista de libros\n";
                menu += "5.- Salir \n";
                menu += "Elija una opción";
                op = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (op) {
                    case 1:
                        idLibro = JOptionPane.showInputDialog("Escriba el id del libro");
                        titulo = JOptionPane.showInputDialog("Escriba el titulo del libro");
                        autor = JOptionPane.showInputDialog("Escriba el autor del libro");
                        gestion.agregar(idLibro, titulo, autor);

                        break;
                    case 2:
                        idLibro = JOptionPane.showInputDialog("Ingrese el id del libro a eliminar");
                        JOptionPane.showMessageDialog(null, gestion.eliminar(idLibro));
                        break;
                    case 3:
                        idLibro = JOptionPane.showInputDialog("Ingrese el id del libro a buscar");
                        JOptionPane.showMessageDialog(null, gestion.findNodeTree(idLibro));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,gestion.getListContent());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no valida, intentelo de nuevo");
                }
            } while (op != 5);
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta segurode abandonar la aplicacion?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Gracias por usar la aplicacion \n " + "Cerrando aplicacion...");
                System.exit(0);
            } else {
                menu();
            }

        } catch (NumberFormatException e) {
            if (!e.toString().equals("java.lang.NumberFormatException: null")) {
                JOptionPane.showMessageDialog(null, "usted no ha digitado un numero, intente de nuevo");

                menu();
            } else {
                JOptionPane.showMessageDialog(null, "hasta luego!");
                op = 5;
            }

        }


    }

}

