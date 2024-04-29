package org.example.service;

import org.example.excrption.ElementNotFoundException;
import org.example.excrption.IncorrectDataException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] data;
    private int size;
    private int currentLength;
    private static final int DEFAULT_SIZE = 5;

    public StringListImpl() {
        data = new String[DEFAULT_SIZE];
        size = 0;
        this.currentLength = DEFAULT_SIZE;
    }

    public StringListImpl(int startLength) {
        data = new String[startLength];
        size = 0;
        this.currentLength = startLength;
    }

    @Override
    public String add(String item) {
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        size++;
        data[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                String s = data[i];
                for (int j = i; j < size; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                return s;
            }
        }
        throw new ElementNotFoundException("Item" + item + "not found");
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String s = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return s;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i>=0; i--) {
            if (item.equals(data[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return data[index];


    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IncorrectDataException("Incorrect input data");
        }
        if (this==otherList) {
            return true;}
        return size==otherList.size()&& Arrays.equals(toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new String[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(data,0,result,0,size);
        return result;
    }

    private void checkIndex(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index" + index + "out of bounds ");
        }
    }

    public String toString() {
        return Arrays.toString(data);
    }

}
