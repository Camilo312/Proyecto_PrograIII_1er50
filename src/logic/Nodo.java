package logic;
public class Nodo<T> {

    private T info;
    private Nodo<T> left;
    private Nodo<T> right;
    private int height;

    public Nodo(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getLeft() {
        return left;
    }

    public void setLeft(Nodo<T> left) {
        this.left = left;
    }

    public Nodo<T> getRight() {
        return right;
    }

    public void setRight(Nodo<T> right) {
        this.right = right;
    }
}
