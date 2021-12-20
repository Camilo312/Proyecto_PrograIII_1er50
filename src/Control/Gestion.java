package Control;

import logic.ArbolLibros;
import logic.ListaCircular;
import logic.Nodo;
import model.Libro;

import java.util.Comparator;

public class Gestion {
    private static ListaCircular<Libro> lista;
    private static ArbolLibros<Libro> arbol;
    private Libro libro;

    public Gestion(){
        lista = new ListaCircular<>();
        arbol = new ArbolLibros<>(((Comparator.comparing(Libro::getIdLibro))));
    }

    public void agregar(String id, String titulo, String autor){
        libro = new Libro(id, titulo, autor);
        lista.agregarALista(libro);
        arbol.addNode(libro);
    }

    public String eliminar(String id){
        libro = new Libro(id);
        String ret = "";
        try {
            String des = arbol.findNode(new Libro(id)).getInfo().toString();
            ret = "Se ha eliminado el libro: \n"+des;
            lista.delete(libro);
            arbol = new ArbolLibros<>(Comparator.comparing(Libro::getIdLibro));
            if(lista.getRoot() != null){
                lista.recorrerRoot().forEach(e->arbol.addNode(e.getInfo()));
            }
        }catch (Exception e){
            ret = "No se ha encontrado un libro con este registro";
        }

        return ret;
    }

    public String getListContent(){
        String ret = "";
        try {
            for (Nodo<Libro> libro :lista.recorrerRoot()) {
                ret += libro.getInfo();
            }
        }catch (Exception e){
            ret = "No hay registros";
        }

        return ret;
    }

    public String findNodeTree(String id){
        String ret;
        try{
            ret = arbol.findNode(new Libro(id)).getInfo().toString();
        }catch (Exception e){
            ret = "No se ha encontrado el libro";
        }
        return ret;
    }
}
