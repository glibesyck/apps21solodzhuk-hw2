package ua.edu.ucu.collections.immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getPrevious() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        firstNode.setPrevious(secondNode);
        assertEquals(firstNode.getPrevious(), secondNode);
    }

    @Test
    void getValue() {
        Node firstNode = new Node(1);
        assertEquals(firstNode.getValue(), 1);
    }

    @Test
    void setValue() {
        Node firstNode = new Node(1);
        firstNode.setValue(2);
        assertEquals(firstNode.getValue(), 2);
    }

    @Test
    void getNext() {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        firstNode.setNext(secondNode);
        assertEquals(firstNode.getNext(), secondNode);
    }

}