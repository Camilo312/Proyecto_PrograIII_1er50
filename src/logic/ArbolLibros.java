package logic;

import java.util.*;

public class ArbolLibros<T> {
    private Comparator<T> comparator;
    private Nodo<T> root;
    private int aux;
    private List<T> outArray;
    private String[] niveles;

    public ArbolLibros(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public ArbolLibros() {

    }

    public boolean isEmpty() {
        return root == null;
    }

    //Agregar nodo
//    public void addNode(T info){
//        if (isEmpty()){
//            root = new Nodo<>(info);
//        }else{
//            Nodo<T> newNodo = new Nodo<>(info);
//            Nodo<T> act = root;
//            Nodo<T> ant = null;
//            while (act != null){
//                ant = act;
//                if (comparator.compare(info,act.getInfo()) >0){
//                    act = act.getRight();
//                }else{
//                    act = act.getLeft();
//                }
//            }
//            //eso indicraia que el anterior(padre) es mayor que el nuevo nodo
//            if (comparator.compare(ant.getInfo(), info)>0){
//                ant.setLeft(newNodo);
//            }else{
//                ant.setRight(newNodo);
//            }
//        }
//    }

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

    public Nodo<T> getRoot(){
        return root;
    }

    public void balanceTree() {
        rebalance(root.getLeft());
    }


    //Encontrar un nodo
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

    //nivel del nodo
    public int gradeNoe(Nodo<T> node) {
        int cont = 0;
        if (node.getRight() != null) cont++;
        if (node.getLeft() != null) cont++;
        return cont;
    }

    // el nodo si es una hoja
    public boolean isLeaf(Nodo<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    //La altura del arbol
    public int heightNode(Nodo<T> node) {
        aux = 0;
        height(node, 0);
        return aux;
    }

    //para mirar cual es la altura del arbol
    private void height(Nodo<T> node, int cont) {
        if (node != null) {
            height(node.getRight(), cont + 1);
            aux = cont > aux ? cont : aux;
            height(node.getLeft(), cont + 1);
        }
    }

    //Enocntrar al padre
    public Nodo<T> finFather(Nodo<T> node) {
        if (node == root) {
            return null;
        } else {
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node) {
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
    }

    public T findGranFather(Nodo<T> node) {
        if (node == root) {
            return null;
        } else {
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node) {
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            if (aux != root) {
                aux = finFather(aux);
                return aux.getInfo();
            }
            return null;
        }
    }

    public T findhermano(Nodo<T> node) {
        if (node == root) {
            return null;
        } else {
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node) {
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            if (aux.getLeft().getInfo() != null) {
                return aux.getLeft().getInfo();
            }
        }
        return null;
    }

    //peso del arbol
    public int weightTree() {
        return weight(root);
    }

    //contar numero de noso del arbol para el peso
    private int weight(Nodo<T> node) {
        if (node != null) {
            return (weight(node.getLeft())) + (weight(node.getRight())) + 1;
        }
        return 0;
    }

    //eliminar un nodo
    public T deleteNode(Nodo<T> node) {
        switch (gradeNoe(node)) {
            case 0:
                return deleteLeaf(node);
            case 1:
                return deeleteNodeWithSon(node);
            default:
                return deleteNodeWithSons(node);
        }
    }

    //eliminar padre de dos hijos y sustituirlo por algun hijo :)
    private T deleteNodeWithSons(Nodo<T> node) {
        T out = node.getInfo();
        Nodo sustitute = node.getRight();
        Nodo FatehrSusutitute = null;
        while (sustitute.getLeft() != null) {
            FatehrSusutitute = sustitute;
            sustitute = sustitute.getLeft();
        }
        if (FatehrSusutitute != null) {
            FatehrSusutitute.setLeft(sustitute.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());

        Nodo father = finFather(node);
        if (father == null) {
            root = sustitute;
        } else {
            if (father.getLeft() == node) {
                father.setLeft(sustitute);
            } else {
                father.setRight(sustitute);
            }
        }
        return out;
    }

    //Eliminra nood con hijo (1)
    private T deeleteNodeWithSon(Nodo<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = node.getLeft() != null ? node.getLeft() : node.getRight();
        } else {
            Nodo<T> father = finFather(node);
            //El nodo a eleminiar esta por izquierda
            if (father.getLeft() == node) {
                if (node.getLeft() != null) {
                    father.setLeft(node.getLeft());
                } else {
                    father.setLeft(node.getRight());
                }
            } else {
                //El nodo a eleminiar esta por derecha
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return out;
    }

    //borrar hoja
    private T deleteLeaf(Nodo<T> node) {
        T out = node.getInfo();
        if (node == root) {
            root = null;
        } else {
            Nodo<T> father = finFather(node);
            if (father.getLeft() == node) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
        }
        return out;
    }

    //el grado del nodo
    public byte gradeNode(Nodo<T> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            return 2;
        } else if (node.getLeft() != null || node.getRight() != null) {
            return 1;
        }
        return 0;
    }

    //el nivel de un nodo


    public T encontrarRaiz() {
        return root.getInfo();
    }

    public int nodosAntes(Nodo<T> node) {
        int cont = 0;
        if (node != null) {
            nodosAntes(node.getLeft());
            if (node != root) {
                cont++;
            }
            nodosAntes(node.getRight());
        }
        return cont;
    }

    public List<T> listPresort(Nodo<T> nodo) {
        outArray = new ArrayList<>();
        presort(nodo);
        return outArray;
    }

    //llena el arreglo por derecha y izquierda
    private void presort(Nodo<T> node) {
        if (node != null) {
            outArray.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    public boolean isBalanced() {
        Nodo<T> left = root.getLeft();
        Nodo<T> right = root.getRight();

        int subtraction = heightNode(right) - heightNode(left);

        return subtraction < 1 && subtraction > -1;
    }

    private Nodo<T> rebalance(Nodo<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (heightNode(node.getRight().getRight()) > heightNode(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (heightNode(node.getLeft().getLeft()) > heightNode(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }

    public int getBalance(Nodo<T> node) {
        return (node == null) ? 0 : heightNode(node.getRight()) - heightNode(node.getLeft());
    }

    private Nodo<T> rotateRight(Nodo<T> y) {
        Nodo<T> x = y.getLeft();
        Nodo<T> z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    private Nodo<T> rotateLeft(Nodo<T> y) {
        Nodo<T> x = y.getRight();
        Nodo<T> z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Nodo<T> node) {
        node.setHeight(1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight())));
    }
}
