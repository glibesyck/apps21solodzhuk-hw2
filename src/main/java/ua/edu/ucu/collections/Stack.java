package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elements;
    public Stack() {
        this.elements = new ImmutableLinkedList();
    }
    public void push(Object e) {
        this.elements = this.elements.addFirst(e);
    }

    public Object pop() {
        Object element = this.peek();
        this.elements = this.elements.removeFirst();
        return element;
    }

    public Object peek() {
        return this.elements.getFirst();
    }
}
