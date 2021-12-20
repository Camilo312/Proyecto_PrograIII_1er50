package test;

import logic.ListaCircular;
import model.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaCircularTest {
    private ListaCircular<Integer> lista = new ListaCircular<>();
    void setup (){
        lista.agregarALista(5);
        lista.agregarALista(11);
        lista.agregarALista(45);
        lista.agregarALista(13);
        lista.agregarALista(17);
        lista.agregarALista(23);
        lista.agregarALista(44);
        lista.agregarALista(8);
        lista.agregarALista(32);
        lista.agregarALista(26);
        lista.agregarALista(35);
    }


    @Test
    void isEmpty() {
        assertTrue(lista.isEmpty());
        setup();
        assertFalse(lista.isEmpty());
    }

    @Test
    void findNodo() {
        assertEquals(5, lista.findNodo(5).getInfo());
        assertEquals(45, lista.findNodo(45).getInfo());
        assertEquals(23, lista.findNodo(23).getInfo());
        assertEquals(8, lista.findNodo(8).getInfo());
        assertEquals(32, lista.findNodo(32).getInfo());
        assertEquals(55, lista.findNodo(55).getInfo());
    }

    @Test
    void getSize() {
    }

    @Test
    void delete() {
    }

    @Test
    void getRoot() {
    }

    @Test
    void recorrerRoot() {
    }

    @Test
    void recorrerDesdeNodo() {
    }
}