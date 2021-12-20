package vista;

import logic.ArbolLibros;
import logic.ListaCircular;
import logic.Nodo;
import model.Libro;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ListaCircular<Libro> lista = new ListaCircular<>();
        ArbolLibros<Libro> arbol = new ArbolLibros<>((((Id1, Id2) -> (Id1.getIdLibro().compareTo(Id2.getIdLibro())))));

        int op=0;
        Libro libro = null;
        String idLibro = null;
        String titulo = null;
        String autor = null;
        String menu="";
        do{
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Agregar libro \n";
            menu+="2.- Eliminar libro \n";
            menu+="3.- Buscar libro \n";
            menu+="4.- Mostrar lista de libros\n";
            menu+="5.- Salir \n";
            menu+="Elija una opción";
            op=Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch(op){
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
                    JOptionPane.showMessageDialog(null,arbol.findNode(new Libro(idLibro)));

                    break;
                case 4:

                    break;
            }
        }while(op!=5);
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta segurode abandonar la aplicacion?", "Alerta!", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null,"Gracias por usar la aplicacion \n " + "Cerrando aplicacion...");

    }
}
