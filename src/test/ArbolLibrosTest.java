package test;

import logic.ArbolLibros;

import static org.junit.jupiter.api.Assertions.*;

class ArbolLibrosTest {
    ArbolLibros<Integer> test = new ArbolLibros<>(Integer::compare);

    void setup() {
        test.addNode(10);
        test.addNode(5);
        test.addNode(15);
        test.addNode(7);
        test.addNode(6);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(test.isEmpty());
        setup();
        assertFalse(test.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        setup();
    }


    @org.junit.jupiter.api.Test
    void heigtTree() {
        setup();
        assertEquals(0, test.heightNode(test.findNode(6)));
        assertEquals(2, test.heightNode(test.findNode(5)));
        assertEquals(1, test.heightNode(test.findNode(3)));
        assertEquals(0, test.heightNode(test.findNode(4)));
    }

    @org.junit.jupiter.api.Test
    void isBalanced() {
        setup();
        assertFalse(test.isBalanced());
        //assertTrue(test.isBalanced());
    }

    @org.junit.jupiter.api.Test
    void listPresort() {
        setup();
        test.listPresort(test.findNode(5)).forEach(i -> System.out.println(i + "\n"));
    }
}