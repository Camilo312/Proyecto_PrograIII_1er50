package logic;


public class ListaCircular<T>{
    private Nodo<T> root;

    public ListaCircular() {
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void agregarALista(T info){
        Nodo<T> data = new Nodo<>(info);
        if(isEmpty()){
            root = data;
            data.setRight(root);
            root = data;

        }else{
            Nodo<T> aux = root;
            while (aux.getRight() != root){
                aux = aux.getRight();
            }
            data.setRight(root);
            aux.setRight(data);
        }
    }


    public Nodo<T> findNodo(T info) {
        Nodo<T> aux = null;
        if (!isEmpty()){
            if(root.getInfo() == info){
                return root;
            }else{
                aux = root.getRight();
                while (aux != root){
                    if(aux.getInfo() == info){
                        return  aux;
                    }
                    aux = aux.getRight();
                }
                aux = null;
            }
        }
        return aux;
    }

    public int getSize(){
        int cont = 0;
        if(!isEmpty()){
            Nodo<T> aux = root;
            while (aux.getRight() != root){
                cont++;
            }
        }
        return cont;
    }

}
