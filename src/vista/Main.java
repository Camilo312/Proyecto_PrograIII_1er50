package vista;

import logic.ArbolLibros;
import logic.ListaCircular;
import logic.Nodo;
import model.Libro;

import javax.swing.*;

public class Main {
    static ListaCircular<Libro> lista = new ListaCircular<>();
    static ArbolLibros<Libro> arbol = new ArbolLibros<>((((Id1, Id2) -> (Id1.getIdLibro().compareTo(Id2.getIdLibro())))));

    public static void main(String[] args) throws Exception {
        menu();


    }

    public static void menu() {

        int op = 0;
        Libro libro = null;
        String idLibro = null;
        String titulo = null;
        String autor = null;
        String menu = "";

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
                        lista.agregarALista(libro);
                        arbol.addNode(libro);

                        break;
                    case 2:
                        idLibro = JOptionPane.showInputDialog("Ingrese el id del libro a eliminar");
                        lista.delete(libro);

                        break;
                    case 3:
                        idLibro = JOptionPane.showInputDialog("Ingrese el id del libro a buscar");
                        JOptionPane.showMessageDialog(null, arbol.findNode(new Libro(idLibro)));

                        break;
                    case 4:

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

