package logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class ArbolLibros<T> {
    private Comparator<T> comparator;
    private Nodo<T> root;
    private int aux;
    private ArrayList<T> outArray;
    private String[] niveles;

    public ArbolLibros(Comparator<T> comparator) {

        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return root == null;
    }

    //Agregar nodo
    public void addNode(T info){
        if (isEmpty()){
            root = new Nodo<>(info);
        }else{
            Nodo<T> newNodo = new Nodo<>(info);
            Nodo<T> act = root;
            Nodo<T> ant = null;// se neceista referncia padre del nuevo hijo
            while (act != null){
                ant = act;
                //eso indicria que el nuevo nodo es mayor que el actual
                if (comparator.compare(info,act.getInfo()) >0){
                    act = act.getRight();
                }else{
                    act = act.getLeft();
                }
                //en ant quedo el padre del nuevo nodo ya que act esta en null
            }
            //eso indicraia que el anterior(padre) es mayor que el nuevo nodo
            if (comparator.compare(ant.getInfo(), info)>0){
                ant.setLeft(newNodo);
            }else{
                ant.setRight(newNodo);
            }
        }
    }

    //Encontrar un nodo
    public Nodo<T> findNode(T node){
        Nodo <T> aux = root;
        while (aux !=null){
            if (comparator.compare(node,aux.getInfo())==0){
                return aux;
            }
            aux = comparator.compare(aux.getInfo(), node) >0 ? aux.getLeft(): aux.getRight();
        }
        return null;
    }

    //retorna el arreglo llenado en presort
    public ArrayList<T> listPresort(){
        outArray = new ArrayList<>();
        presort(root);
        return outArray;
    }

    //llena el arreglo por derecha y izquierda
    private void presort(Nodo<T> node) {
        if (node != null){
            outArray.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    //Insertar lista
    public ArrayList<T> listInsort(){
        outArray = new ArrayList<>();
        insort(root);
        return outArray;
    }
    //insertar elementos a la lista
    private void insort(Nodo<T> node) {
        if (node != null){
            insort(node.getLeft());
            outArray.add(node.getInfo());
            insort(node.getRight());
        }
    }

    public ArrayList<T> listPosort(){
        outArray = new ArrayList<>();
        posort(root);
        return outArray;
    }

    private void posort(Nodo<T> node) {
        if (node != null){
            posort(node.getLeft());
            posort(node.getRight());
            outArray.add(node.getInfo());
        }
    }

    public int suma(){
        int a = (int) listPresort().get(1);
        int b = (int) listPresort().get(2);
        int suma = a+b;
        return suma;
    }


    //se recorre el arbol por niveles con colas
    public ArrayList<T> listAmplitudeDown(){
        outArray = new ArrayList<>();
        ArrayDeque<Nodo> tail = new ArrayDeque<>();//se creo la cola
        tail.add(root);// se agrega ´rimer lemento a la cola
        Nodo<T> aux = null;
        while (!tail.isEmpty()){//se mira que nuestra cola no este vacia
            aux = tail.pop();//agregar
            //se le agrega a la cola lo que se tengoa por iziquierda
            if (aux.getLeft() !=null){
                tail.add(aux.getLeft());
            }
            // se le agrega a la cola lo que se tenga por izquierda
            if (aux.getRight() != null){
                tail.add(aux.getRight());
            }
            outArray.add(aux.getInfo());
        }
        return outArray;
    }

    //sew recorre el arbol de abajo hacia arreiba con pilas
    public ArrayList<T> listAmplitudeTop() {
        outArray = new ArrayList<>();
        Stack<T> stack = new Stack<>();//pila
        ArrayDeque<Nodo> tail = new ArrayDeque<>();//cola
        tail.add(root);
        Nodo<T> aux;
        while (!tail.isEmpty()){
            aux = tail.pop();
            if (aux.getLeft() != null){
                tail.add(aux.getLeft());
            }
            if (aux.getRight() !=null){
                tail.add(aux.getRight());
            }

            stack.push(aux.getInfo());//empuyjar a la pila
        }
        while (!stack.isEmpty()){
            outArray.add(stack.pop());
        }
        return outArray;
    }

    //nivel del nodo
    public int gradeNoe(Nodo<T> node) {
        int cont =0;
        if (node.getRight() != null) cont++;
        if (node.getLeft() != null) cont++;
        return cont;
    }

    // el nodo si es una hoja
    public boolean isLeaf(Nodo<T> node){
        if(node.getLeft()==null && node.getRight()==null){
            return true;
        }
        return false;
    }

    //La altura del arbol
    public int heigtTree(){
        return heigthNode(root);
    }

    //Si el nivel de la hoja es cero pues su latura es cero
    public int heigthNode(Nodo<T> node){
        aux=0;
        height(node,0);
        return aux;
    }

    //para mirar cual es la altura del arbol
    private void height(Nodo<T> node, int cont) {
        if (node != null){
            height(node.getRight(),cont+1);
            aux = cont > aux ? cont : aux;
            height(node.getLeft(),cont+1);
        }
    }

    //Enocntrar al padre
    public Nodo<T>finFather(Nodo<T> node){
        if (node == root){
            return null;
        }else{
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node){
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
    }

    public T findGranFather(Nodo<T> node){
        if (node == root){
            return null;
        }else{
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node){
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            if (aux != root){
                aux = finFather(aux);
                return aux.getInfo();
            }
            return null;
        }
    }

    public T findhermano(Nodo<T> node){
        if (node == root){
            return null;
        }else{
            Nodo<T> aux = root;
            while (aux.getRight() != node && aux.getLeft() != node){
                aux = comparator.compare(aux.getInfo(), node.getInfo()) > 0 ? aux.getLeft(): aux.getRight();
            }
            if(aux.getLeft().getInfo() != null){
                return aux.getLeft().getInfo();
            }
        }
        return null;
    }

    //peso del arbol
    public int weightTree(){
        return weight(root);
    }

    //contar numero de noso del arbol para el peso
    private int weight(Nodo<T> node) {
        if (node != null){
            return (weight(node.getLeft()))+(weight(node.getRight()))+1;
        }
        return 0;
    }

    //eliminar un nodo
    public T deleteNode(Nodo<T>node){
        switch (gradeNoe(node)){
            case 0: return deleteLeaf(node);
            case 1 : return deeleteNodeWithSon(node);
            default: return  deleteNodeWithSons(node);
        }
    }

    //eliminar padre de dos hijos y sustituirlo por algun hijo :)
    private T deleteNodeWithSons(Nodo<T> node) {
        T out = node.getInfo();
        Nodo sustitute =  node.getRight();
        Nodo FatehrSusutitute =null;
        while (sustitute.getLeft() != null){
            FatehrSusutitute = sustitute;
            sustitute = sustitute.getLeft();
        }
        if (FatehrSusutitute != null){
            FatehrSusutitute.setLeft(sustitute.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());

        Nodo father = finFather(node);
        if (father == null){
            root = sustitute;
        }else{
            if (father.getLeft() == node){
                father.setLeft(sustitute);
            }else{
                father.setRight(sustitute);
            }
        }
        return out;
    }

    //Eliminra nood con hijo (1)
    private T deeleteNodeWithSon(Nodo<T> node) {
        T out = node.getInfo();
        if (node == root){
            root = node.getLeft() != null ? node.getLeft() : node.getRight();
        }else{
            Nodo<T> father = finFather(node);
            //El nodo a eleminiar esta por izquierda
            if (father.getLeft() == node){
                if (node.getLeft() != null){
                    father.setLeft(node.getLeft());
                }else{
                    father.setLeft(node.getRight());
                }
            }else{
                //El nodo a eleminiar esta por derecha
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return out;
    }

    //borrar hoja
    private T deleteLeaf(Nodo<T> node) {
        T out = node.getInfo();
        if (node == root){
            root = null;
        }else{
            Nodo<T> father = finFather(node);
            if(father.getLeft() == node){
                father.setLeft(null);
            }else{
                father.setRight(null);
            }
        }
        return out;
    }

    //el grado del nodo
    public byte gradeNode(Nodo<T> node){
        if (node.getLeft() !=null && node.getRight() !=null){
            return 2;
        }else if(node.getLeft() !=null || node.getRight() !=null){
            return  1;
        }
        return 0;
    }

    //el nivel de un nodo


    public T encontrarRaiz(){
        return root.getInfo();
    }

    public int nodosAntes(Nodo<T> node){
        int cont=0;
        if (node != null){
            nodosAntes(node.getLeft());
            if (node != root){
                cont ++;
            }
            nodosAntes(node.getRight());
        }
        return  cont;
    }

    public boolean isBalanced(){
        int cont =0;
        int contador =0;
        int a=0;
        Nodo<T> nodo = root;
        if (nodo != null){
            height(nodo.getRight(),cont+1);
            height(nodo.getLeft(), contador+1);
        }
        if (contador == cont){
            return  true;
        }
        return false;
    }
}
