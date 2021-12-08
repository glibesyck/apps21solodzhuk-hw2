package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        this.length = elements.length;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        } else {
            Node prev = null;
            for (int i = 0; i < elements.length; i++) {
                Node node = new Node(elements[i]);
                node.setPrevious(prev);
                if (prev != null) {
                    prev.setNext(node);
                }
                prev = node;
                if (i == 0) {
                    this.head = node;
                }
                if (i == elements.length - 1) {
                    node.setNext(null);
                    this.tail = node;
                }
            }
        }
    }
    public ImmutableLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] firstPart = Arrays.copyOf(this.toArray(), index);
        Object[] thirdPart = Arrays.copyOfRange(this.toArray(), index, this.length);
        Object[] finalArray = new Object[this.length + c.length];
        for (int i = 0; i < finalArray.length; i++) {
            if (i < index) {
                finalArray[i] = firstPart[i];
            } else if (index <= i && i < c.length + index) {
                finalArray[i] = c[i-index];
            } else {
                finalArray[i] = thirdPart[i - c.length - index];
            }
        }
        return new ImmutableLinkedList(finalArray);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node currNode = this.head;
        for (int i = 0; i < this.length; i ++){
            if (i == index) {
                return currNode.getValue();
            }
            currNode = currNode.getNext();
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] firstPart = Arrays.copyOf(this.toArray(), index);
        Object[] secondPart = Arrays.copyOfRange(this.toArray(), index + 1, this.length);
        Object[] result = new Object[firstPart.length + secondPart.length];
        for (int i = 0; i < result.length; i++) {
            if (i < firstPart.length) {
                result[i] = firstPart[i];
            } else {
                result[i] = secondPart[i - firstPart.length];
            }
        }
        return new ImmutableLinkedList(result);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList linkedList = this.remove(index);
        return linkedList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = this.head;
        for (int i = 0; i < this.length; i ++){
            if (currNode.getValue() == e) {
                return i;
            }
            currNode = currNode.getNext();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] result = new Object[this.length];
        return new ImmutableLinkedList(result);
    }

    @Override
    public boolean isEmpty() {
        return (this.length == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.length];
        Node currNode = this.head;
        for (int i = 0; i < this.length; i++) {
            array[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] subResult = Arrays.copyOf(this.toArray(), this.length);
        Object[] result = new Object[this.length + 1];
        result[0] = e;
        for (int i = 1; i < this.length + 1; i++) {
            result[i] = subResult[i-1];
        }
        return new ImmutableLinkedList(result);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] subResult = Arrays.copyOf(this.toArray(), this.length);
        Object[] result = new Object[this.length + 1];
        result[this.length] = e;
        for (int i = 0; i < this.length; i++) {
            result[i] = subResult[i];
        }
        return new ImmutableLinkedList(result);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.head.getValue();
    }

    public Object getLast() {
        if (this.tail == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] result = Arrays.copyOfRange(this.toArray(), 1, this.length);
        return new ImmutableLinkedList(result);
    }

    public ImmutableLinkedList removeLast() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] result = Arrays.copyOf(this.toArray(), this.length - 1);
        return new ImmutableLinkedList(result);
    }
}
