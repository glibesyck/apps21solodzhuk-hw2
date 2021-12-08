package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableArrayListTest {
    @Test
    public void add() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.add(4);
        int[] expectedResult = new int[]{1, 2, 3, 4};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void testAdd() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.add(2, 4);
        int[] expectedResult = new int[]{1, 2, 4, 3};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAll() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.addAll(new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 2, 3, 4, 5};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAllEmptyBefore() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableList newArrayList = arrayList.addAll(new Object[] {4, 5});
        int[] expectedResult = new int[]{4, 5};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void addAllEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.addAll(new Object[] {});
        int[] expectedResult = new int[]{1, 2, 3};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void testAddAll() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.addAll(1, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllBeforeError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.addAll(-1, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.addAll(4, new Object[] {4, 5});
        int[] expectedResult = new int[]{1, 4, 5, 2, 3};
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getBeforeError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object element = arrayList.get(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void getError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object element = arrayList.get(3);
    }
    @Test
    public void get() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object actualResult = arrayList.get(2);
        int expectedResult = 3;
        assertEquals(actualResult, expectedResult);
    }
    @Test
    public void set() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object[] actualResult = arrayList.set(2, 4).toArray();
        int[] expectedResult = new int[]{1, 2, 4};
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void setBeforeError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object[] actualResult = arrayList.set(-1, 4).toArray();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void setError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object[] actualResult = arrayList.set(3, 4).toArray();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeBeforeError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.remove(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.remove(3);
    }
    @Test
    public void remove() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        Object[] actualResult = arrayList.remove(1).toArray();
        int[] expectedResult = new int[]{1, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
    @Test
    public void indexOf() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        int index = arrayList.indexOf(2);
        assertEquals(index, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void indexOfError() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        int index = arrayList.indexOf(4);
    }
    @Test
    public void size() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        assertEquals(arrayList.size(), 3);
    }
    @Test
    public void sizeEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {});
        assertEquals(arrayList.size(), 0);
    }
    @Test
    public void clear() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArrayList = arrayList.clear();
        Object[] actualResult = newArrayList.toArray();
        for (int i = 0; i < actualResult.length; i++) {
            assertEquals(actualResult[i], null);
        }
    }
    @Test
    public void isEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        assertEquals(arrayList.isEmpty(), false);
    }
    @Test
    public void isEmptyEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {});
        assertEquals(arrayList.isEmpty(), true);
    }
    @Test
    public void toArray() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
        int[] expectedResult = new int[]{1, 2, 3};
        Object[] actualResult = arrayList.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }
}
