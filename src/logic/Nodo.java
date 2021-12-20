package logic;
/**
 * Clase que permite crear un nodo para
 * una lista y para el arbol.
 * @version  19/12/21
 * @author Deisy Monroy y Karen Hernández
 */
public class Nodo<T> {

    private T info;
    private Nodo<T> left;
    private Nodo<T> right;
    private int height;
    /**constructor que define el nodo
     * @param info de tipo T*/
    public Nodo(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    /**
     * @param height de tipo int*/
    public void setHeight(int height) {
        this.height = height;
    }
    /** metodo que obtiene informacion del nodo
     * @return info*/
    public T getInfo() {
        return info;
    }
    /**metodo que trae la informacion del nodo
     * @param info de tipo T*/
    public void setInfo(T info) {
        this.info = info;
    }
    /** metodo que obtiene informacion del nodo
     * por izquierda
     * @return left*/
    public Nodo<T> getLeft() {
        return left;
    }
    /**metodo que trae la informacion del nodo
     * por izquierda
     * @param left de tipo T*/
    public void setLeft(Nodo<T> left) {
        this.left = left;
    }
    /** metodo que obtiene informacion del nodo
     * por derecha
     * @return right*/
    public Nodo<T> getRight() {
        return right;
    }
    /**metodo que trae la informacion del nodo
     * por derecha
     * @param right de tipo T*/
    public void setRight(Nodo<T> right) {
        this.right = right;
    }
}
