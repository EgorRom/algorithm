package org.example.integer;

import org.example.service.IntegerListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerList integerListTest;
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;

    @BeforeEach
    void setUp() {
        integerListTest = new org.example.integer.IntegerListImpl(10);
        integerListTest.add(ZERO);
        integerListTest.add(ONE);
        integerListTest.add(TWO);
        integerListTest.add(THREE);
        integerListTest.add(FOUR);
    }

    @Test
    void add() {
        int size = integerListTest.size();
        Integer expected = integerListTest.add(FIVE);
        Integer actual = integerListTest.get(size);
        assertEquals(expected, actual);
    }

    @Test
    void testAddIndex() {
        Integer actualPrev = integerListTest.get(1);
        Integer expected = integerListTest.add(1, ONE);
        Integer actual = integerListTest.get(1);
        assertEquals(integerListTest.get(2), actualPrev);
    }


    @Test
    void set() {
        Integer actualPrev = integerListTest.get(2);
        Integer expected = integerListTest.set(1, ONE);
        Integer actual = integerListTest.get(1);
        assertEquals(integerListTest.get(2), actualPrev);
    }



    @Test
    void testRemove() {
        int size = integerListTest.size();
        Integer actual = integerListTest.get(size - 1);
        Integer expected = integerListTest.remove(size - 1);
        assertEquals(actual, expected);
        assertEquals(integerListTest.size(),size-1);
    }

    @Test
    void containsTrue() {

        for (int i = 0; i < integerListTest.size(); i++) {
            assertTrue(integerListTest.contains(integerListTest.get(i)));

        }
    }

    @Test
    void containsFalse() {
        for (int i = 0; i < integerListTest.size(); i++) {
            assertNotEquals(integerListTest, integerListTest.get(i));
        }


    }


    @Test
    void indexOf() {
        for (int i = 0; i < integerListTest.size(); i++) {
            assertEquals(i, integerListTest.indexOf(integerListTest.get(i)));

        }
        assertEquals(-1, integerListTest.indexOf(FIVE));
    }

    @Test
    void lastIndexOf() {
        org.example.integer.IntegerListImpl integerList = new org.example.integer.IntegerListImpl(5);
        Integer onlyThis = ZERO;
        integerList.add(ZERO);
        integerList.add(ZERO);
        integerList.add(ZERO);
        integerList.add(ZERO);
        integerList.add(ZERO);
        assertEquals(integerList.size()-1,integerList.lastIndexOf(ZERO));

    }

    @Test
    void get() {
        Integer expected = integerListTest.add(FIVE);
        Integer actual = integerListTest.get(integerListTest.size() - 1);
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        org.example.integer.IntegerListImpl integerList = new org.example.integer.IntegerListImpl(10);
        integerList.add(ZERO);
        integerList.add(ONE);
        integerList.add(TWO);
        integerList.add(THREE);
        integerList.add(FOUR);
        assertTrue(integerListTest.equals(integerList));
        integerList.add(FIVE);
        assertFalse(integerListTest.equals(integerList));

    }

    @Test
    void size() {
        org.example.integer.IntegerListImpl integerList = new org.example.integer.IntegerListImpl();
        assertEquals(0, integerList.size());
        integerList.add(ONE);
        assertEquals(1, integerList.size());
        integerList.add(TWO);
        assertEquals(2, integerList.size());
        integerList.add(THREE);
        assertEquals(3, integerList.size());


    }

    @Test
    void isEmpty() {
        org.example.integer.IntegerListImpl integerList = new org.example.integer.IntegerListImpl(5);
        assertTrue(integerList.isEmpty());
        integerList.add(ONE);
        assertFalse(integerList.isEmpty());
        integerList.remove(ONE);
        assertTrue(integerList.isEmpty());
    }

    @Test
    void clear() {
        assertFalse(integerListTest.isEmpty());
        integerListTest.clear();
        assertTrue(integerListTest.isEmpty());
    }

//    @Test
//    void toArray() {
//        IntegerListImpl list = new IntegerListImpl(3);
//        Integer[] actual = {ONE, TWO, THREE};
//        for (Integer s : actual) {
//            list.add(s);
//        }
//        String[] expected = list.toArray();
//        assertArrayEquals(expected,actual);
//    }

}