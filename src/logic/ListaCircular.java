package logic;


import model.Libro;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite crear una lista circular
 * con los nodos inresados por consola
 * @version  19/12/21
 * @author Deisy Monroy y Karen Hernández
 */
public class ListaCircular<T> {
    private Nodo<T> root;

    /**Constructor de la clase
     */
    public ListaCircular() {
        this.root = null;
    }
    /**Metodo que permite saber si la lista esta vacia o no
     * @return la raiz si esta vacia
     */
    public boolean isEmpty() {
        return root == null;
    }
    /**Metodo que permite agregar nodos a la lista
     * @param info que es de tipo T
     */
    public void agregarALista(T info) {
        Nodo<T> data = new Nodo<>(info);
        if (isEmpty()) {
            root = data;
            data.setRight(root);
            root = data;
        } else {
            Nodo<T> aux = root;
            while (aux.getRight() != root) {
                aux = aux.getRight();
            }
            data.setRight(root);
            aux.setRight(data);
        }
    }

    /**Metodo que permite buscar un  nodo en la lista
     * @param info de tipo T
     * @return aux con el nodo
     */
    public Nodo<T> findNodo(T info) {
        Nodo<T> aux = null;
        if (!isEmpty()) {
            if (root.getInfo() == info) {
                return root;
            } else {
                aux = root.getRight();
                while (aux != root) {
                    if (aux.getInfo() == info) {
                        return aux;
                    }
                    aux = aux.getRight();
                }
                aux = null;
            }
        }
        return aux;
    }
    /**Metodo que permite conseguir el tamaño de la lista
     * @return cont
     */
    public int getSize() {
        int cont = 0;
        if (!isEmpty()) {
            cont++;
            Nodo<T> aux = root;
            while (aux.getRight() != root) {
                cont++;
                aux = aux.getRight();
            }
        }
        return cont;
    }
    /**Metodo que permite eliminar un nodo de la lista
     * @param info de tipo T
     */
    public void delete(T info) {
        if (!isEmpty()) {
            Nodo<T> aux = root;
            if((root == root.getRight())){
                root.setRight(null);
                root = null;
            } else if (((Nodo<Libro>) root).getInfo().getIdLibro().equalsIgnoreCase(((Libro) info).getIdLibro())) {
                while (!((Nodo<Libro>) aux.getRight()).getInfo().getIdLibro().equalsIgnoreCase(((Nodo<Libro>) root).getInfo().getIdLibro())) {
                    aux = aux.getRight();
                }
                root = root.getRight();
                aux.setRight(aux.getRight().getRight());
            } else {
                while (!(((Nodo<Libro>) aux).getRight().getInfo().getIdLibro()).equalsIgnoreCase(((Nodo<Libro>) root).getInfo().getIdLibro())) {
                    if (((Nodo<Libro>) aux.getRight()).getInfo().getIdLibro().equalsIgnoreCase(((Libro) info).getIdLibro())) {
                        aux.setRight(aux.getRight().getRight());
                        break;
                    }
                    aux = aux.getRight();
                }
            }
        }
    }
    /**metodo que obtiene la raiz
     * @return root
     */
    public Nodo<T> getRoot() {
        return root;
    }
    /**metodo que recorre la raiz
     * @return recorre desde el nodo
     */
    public List<Nodo<T>> recorrerRoot() {
        return recorrerDesdeNodo(root);
    }
    /**metodo que recorre desde un nodo especifico
     * @param node Nodo
     * @return lista
     */
    public List<Nodo<T>> recorrerDesdeNodo(Nodo<T> node) {
        List<Nodo<T>> nodos = null;
        if (!isEmpty()) {
            nodos = new ArrayList<>();
            nodos.add(node);
            Nodo<T> aux = node.getRight();
            while (!((Nodo<Libro>) aux).getInfo().getIdLibro().equalsIgnoreCase(((Nodo<Libro>) node).getInfo().getIdLibro())) {
                nodos.add(aux);
                aux = aux.getRight();
            }
        }
        return nodos;
    }

}
