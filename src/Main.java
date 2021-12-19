import logic.ListaCircular;
import logic.Nodo;

public class Main {

    public static void main(String[] args) throws Exception {
        ListaCircular<Integer> listaTest = new ListaCircular<>();
        listaTest.agregarALista(24);
        listaTest.agregarALista(14);
        listaTest.agregarALista(4);
        listaTest.agregarALista(13);
        listaTest.agregarALista(415);
        listaTest.agregarALista(16);

        //Encontrar nodo
        System.out.println(listaTest.getSize());

        listaTest.delete(24);
        Nodo<Integer> e = listaTest.findNodo(24);


//        System.out.println("<<-- Ejemplo -->>");
//
//        listaLibros.agregarFinal(24);
//        listaLibros.agregarFinal(14);
//        listaLibros.agregarFinal(04);
//
//        listaLibros.agregarInicio(07);
//        listaLibros.agregarInicio(17);
//        listaLibros.agregarInicio(27);
//
//        System.out.println("<<-- Lista-->>");
//        listaLibros.Listar();
//
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- valor nodo -->>");
//        System.out.println(listaLibros.getId(4));
//
//        System.out.println("<<-- insertar un nodo 18 despues del 17 -->>");
//        listaLibros.insertarPorReferencia(17,18);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- insertar un nodo 45 en la posicion 5 -->>");
//        listaLibros.insertarXPosicion(5,45);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- actualizar el valor 14 por 25 -->>");
//        listaLibros.insertarPorReferencia(14,25);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- actualizar el valor nodo en la posicion 0 x 17 -->>");
//        listaLibros.insertarXPosicion(0,17);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- eliminar nodo con id 17 -->>");
//        listaLibros.removerPorReferencia(17);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("<<-- eliminar nodo en la posicion 4 -->>");
//        listaLibros.removerPorPosicion(4);
//        listaLibros.Listar();
//        System.out.println("<<-- tamaño -->>");
//        System.out.println(listaLibros.getTamaño());
//
//        System.out.println("consultar si existe id 30");
//        System.out.println(listaLibros.buscar(30));
//
//        System.out.println("consultar posicion del valor 07");
//        System.out.println(listaLibros.getPosicion(07));
//
//        System.out.println("eliminar lista");
//        listaLibros.eliminar();
//
//        System.out.println("consultar si la lista esta vacia");
//        System.out.println(listaLibros.esVacia());
    }
}
