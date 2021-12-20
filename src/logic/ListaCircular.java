package logic;


import model.Libro;

import java.util.ArrayList;
import java.util.List;

public class ListaCircular<T> {
    private Nodo<T> root;

    public ListaCircular() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

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

    public Nodo<T> getRoot() {
        return root;
    }

    public List<Nodo<T>> recorrerRoot() {
        return recorrerDesdeNodo(root);
    }

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
