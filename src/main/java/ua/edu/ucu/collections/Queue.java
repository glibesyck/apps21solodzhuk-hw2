package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elements;
    public Queue() {
        this.elements = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.elements.getFirst();
    }

    public Object dequeue() {
        Object element = this.peek();
        this.elements = this.elements.removeFirst();
        return element;
    }

    public void enqueue(Object e) {
        this.elements = this.elements.addLast(e);
    }
}
