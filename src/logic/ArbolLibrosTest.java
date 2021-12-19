package logic;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArbolLibrosTest {
    ArbolLibros<Integer> test = new ArbolLibros<>(Integer::compare);

    void setup(){
        test.addNode(5);
        test.addNode(3);
        test.addNode(4);
        test.addNode(6);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(test.isEmpty());
        setup();
        assertFalse(test.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void aaddNode() {
    }

    @org.junit.jupiter.api.Test
    void findNode() {
    }

    @org.junit.jupiter.api.Test
    void listPresort() {
    }

    @org.junit.jupiter.api.Test
    void listInsort() {
    }

    @org.junit.jupiter.api.Test
    void listPosort() {
    }

    @org.junit.jupiter.api.Test
    void suma() {
    }

    @org.junit.jupiter.api.Test
    void listAmplitudeDown() {
    }

    @org.junit.jupiter.api.Test
    void listAmplitudeTop() {
    }

    @org.junit.jupiter.api.Test
    void gradeNoe() {
    }

    @org.junit.jupiter.api.Test
    void isLeaf() {
    }

    @org.junit.jupiter.api.Test
    void heigtTree() {
    }

    @org.junit.jupiter.api.Test
    void heigthNode() {
    }

    @org.junit.jupiter.api.Test
    void finFather() {
    }

    @org.junit.jupiter.api.Test
    void findGranFather() {
    }

    @org.junit.jupiter.api.Test
    void findhermano() {
    }

    @org.junit.jupiter.api.Test
    void weightTree() {
    }

    @org.junit.jupiter.api.Test
    void deleteNode() {
    }

    @org.junit.jupiter.api.Test
    void gradeNode() {
    }

    @org.junit.jupiter.api.Test
    void encontrarRaiz() {
    }

    @org.junit.jupiter.api.Test
    void nodosAntes() {
    }

    @org.junit.jupiter.api.Test
    void isBalanced() {
    }
}