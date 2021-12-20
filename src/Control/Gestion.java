package Control;

import logic.ArbolLibros;
import logic.ListaCircular;
import logic.Nodo;
import model.Libro;

import java.util.Comparator;

/**
 * Clase que se encarga del control de los
 * arboles binarios y la lista circular
 * @version  19/12/21
 * @author Deisy Monroy y Karen Hernández
 */
public class Gestion {
    private static ListaCircular<Libro> lista;
    private static ArbolLibros<Libro> arbol;
    private Libro libro;
    /**Constructor de la clase
     */
    public Gestion(){
        lista = new ListaCircular<>();
        arbol = new ArbolLibros<>(((Comparator.comparing(Libro::getIdLibro))));
    }

    /**Metodo que agrega un libro a lista
     * y tambien agrega al arbol
     * @param id de tipo String
     * @param  titulo de tipo String
     * @param autor de tipo String
     */
    public void agregar(String id, String titulo, String autor){
        libro = new Libro(id, titulo, autor);
        lista.agregarALista(libro);
        arbol.addNode(libro);
    }

    /**Metodo que se enecraga de eliminar un nodo
     * de la lista y el arbol
     * @param id de tipo String
     * @return ret de tipo cadena
     */
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

    /**Metodo que se encarga de obtener
     * el contenido de la lista
     * @return ret de tipo cadena
     */
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

    /**Metodo que se encarga de encontrar un libro
     * en el arbol
     * @param id de tipo String
     * @return ret de tipo cadena
     */
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
