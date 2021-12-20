package logic;

import java.util.*;

/**
 * Clase en la que se crea un arbol binario para almacenar
 * datos agregados por la lista
 *
 * @author Deisy Monroy y Karen Hernández
 * @version 19/12/21
 */
public class ArbolLibros<T> {
    private Comparator<T> comparator;
    private Nodo<T> root;
    private int aux;
    private List<T> outArray;

    /**
     * Metodo comparator
     *
     * @param comparator de tipo Comparator T
     */
    public ArbolLibros(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Metodo isEmpty que permite saber si esta
     * vacio el arbol.
     *
     * @return si esta vacio o no
     */

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Metodo addNode permite agregar un nodo a el
     * arbol.
     *
     * @param info de tipo T
     */
    public void addNode(T info) {
        if (isEmpty()) {
            root = new Nodo<>(info);
        } else {
            Nodo<T> newNodo = new Nodo<>(info);
            Nodo<T> act = root;
            Nodo<T> ant = null;
            while (act != null) {
                ant = act;
                act = comparator.compare(info, act.getInfo()) > 0 ? act.getRight() : act.getLeft();
            }
            if (comparator.compare(ant.getInfo(), info) > 0) {
                ant.setLeft(newNodo);
            } else {
                ant.setRight(newNodo);
            }
        }
    }

    /**
     * Metodo findNode permite realizar la busqueda
     * de un nodo en el arbol
     *
     * @param node de topo T
     * @return si encontro el nodo o no
     */
    public Nodo<T> findNode(T node) {
        Nodo<T> aux = root;
        while (aux != null) {
            if (comparator.compare(node, aux.getInfo()) == 0) {
                return aux;
            }
            aux = comparator.compare(aux.getInfo(), node) > 0 ? aux.getLeft() : aux.getRight();
        }
        return null;
    }


    /**
     * Metodo que permite carcular el la altura de
     * un nodo del arbol.
     *
     * @param node de tipo Nodo T
     * @return aux
     */
    public int heightNode(Nodo<T> node) {
        aux = 0;
        height(node, 0);
        return aux;
    }

    /**
     * Metodo que permite mirar la altura del arbol.
     *
     * @param node de tipo Nodo T
     * @param cont que es de tipo int
     */
    private void height(Nodo<T> node, int cont) {
        if (node != null) {
            height(node.getRight(), cont + 1);
            aux = cont > aux ? cont : aux;
            height(node.getLeft(), cont + 1);
        }
    }


    public List<T> listPresort(Nodo<T> nodo) {
        outArray = new ArrayList<>();
        presort(nodo);
        return outArray;
    }

    /**
     * Metodo que permite llenar el arreglo por
     * derecha y por izquierda.
     *
     * @param node de tipo Nodo T
     */
    private void presort(Nodo<T> node) {
        if (node != null) {
            outArray.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    /**
     * Metodo que permite verificar si el
     * arbol esta balanceado
     *
     * @return subtraction
     */
    public boolean isBalanced() {
        Nodo<T> left = root.getLeft();
        Nodo<T> right = root.getRight();

        int subtraction = heightNode(right) - heightNode(left);

        return subtraction < 1 && subtraction > -1;
    }
}
