package ua.edu.ucu.collections.immutable;

import static org.junit.Assert.*;
import org.junit.Test;


public class ImmutableLinkedListTest {

    @Test
    public void add() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.add(4);
        int[] expectedResult = new int[]{1, 2, 3, 4};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void testAdd() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.add(2, 4);
        int[] expectedResult = new int[]{1, 2, 4, 3};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAll() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 2, 3, 4, 5};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAllEmptyBefore() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        ImmutableList newLinkedList = linkedList.addAll(new Object[] {4, 5});
        int[] expectedResult = new int[]{4, 5};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAllEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(new Object[] {});
        int[] expectedResult = new int[]{1, 2, 3};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void testAddAll() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(1, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllBeforeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(-1, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.addAll(4, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getBeforeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object element = linkedList.get(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object element = linkedList.get(3);
    }
    @Test
    public void get() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object actualResult = linkedList.get(2);
        int expectedResult = 3;
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void set() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object[] actualResult = linkedList.set(2, 4).toArray();
        int[] expectedResult = new int[]{1, 2, 4};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void setBeforeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object[] actualResult = linkedList.set(-1, 4).toArray();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void setError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object[] actualResult = linkedList.set(3, 4).toArray();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeBeforeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.remove(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.remove(3);
    }
    @Test
    public void remove() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object[] actualResult = linkedList.remove(1).toArray();
        int[] expectedResult = new int[]{1, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void indexOf() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        int index = linkedList.indexOf(2);
        assertEquals(index, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void indexOfError() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        int index = linkedList.indexOf(4);
    }
    @Test
    public void size() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.size(), 3);
    }
    @Test
    public void sizeEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.size(), 0);
    }
    @Test
    public void clear() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableList newLinkedList = linkedList.clear();
        Object[] actualResult = newLinkedList.toArray();
        for (int i = 0; i < actualResult.length; i++) {
            assertEquals(actualResult[i], null);
        }
    }
    @Test
    public void isEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.isEmpty(), false);
    }
    @Test
    public void isEmptyEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.isEmpty(), true);
    }
    @Test
    public void toArray() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        int[] expectedResult = new int[]{1, 2, 3};
        Object[] actualResult = linkedList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addFirst() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableLinkedList newLinkedList = linkedList.addFirst(4);
        Object[] actualResult = newLinkedList.toArray();
        Object[] expectedResult = new Object[] {4, 1, 2, 3};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addLast() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableLinkedList newLinkedList = linkedList.addLast(4);
        Object[] actualResult = newLinkedList.toArray();
        Object[] expectedResult = new Object[] {1, 2, 3, 4};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void getHead() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.getHead().getValue(), 1);
    }
    @Test
    public void getHeadEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.getHead(), null);
    }
    @Test
    public void getTail() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.getTail().getValue(), 3);
    }
    @Test
    public void getTailEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.getTail(), null);
    }
    @Test
    public void getFirst() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.getFirst(), 1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirstEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.getFirst(), 1);
    }
    @Test
    public void getLast() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        assertEquals(linkedList.getLast(), 3);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getLastEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {});
        assertEquals(linkedList.getLast(), 1);
    }
    @Test
    public void removeFirst() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableLinkedList newLinkedList = linkedList.removeFirst();
        Object[] actualResult = newLinkedList.toArray();
        Object[] expectedResult = new Object[] {2, 3};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFirstEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[]{});
        ImmutableLinkedList newLinkedList = linkedList.removeFirst();
    }
    @Test
    public void removeLast() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableLinkedList newLinkedList = linkedList.removeLast();
        Object[] actualResult = newLinkedList.toArray();
        Object[] expectedResult = new Object[] {1, 2};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLastEmpty() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[]{});
        ImmutableLinkedList newLinkedList = linkedList.removeLast();
    }
}