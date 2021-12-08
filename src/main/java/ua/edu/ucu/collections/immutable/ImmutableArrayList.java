package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;
    private int length;

    public ImmutableArrayList(Object[] elements) {
        if (elements.length == 0){
            this.elements = new Object[]{};
            this.length = 0;
        } else {
            this.elements = Arrays.copyOf(elements, elements.length);
            this.length = elements.length;
        }
    }
    public ImmutableArrayList() {
        this.elements = new Object[]{};
        this.length = 0;
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
        return new ImmutableArrayList(finalArray);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
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
        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList subResult = this.remove(index);
        return subResult.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.length; i++) {
            if (elements[i] == e){
                return i;
            }
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
        return new ImmutableArrayList(result);
    }

    @Override
    public boolean isEmpty() {
        if (this.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return this.elements;
    }
}
