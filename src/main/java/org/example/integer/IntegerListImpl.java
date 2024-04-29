package org.example.integer;

import org.example.excrption.ElementNotFoundException;
import org.example.excrption.IncorrectDataException;

import java.util.Arrays;

import static java.util.Collections.sort;
import static org.example.testSort.TestSort.swapElements;

public class IntegerListImpl implements IntegerList {
    private Integer[] data;
    private int size;
    private int currentLength;
    private static final int DEFAULT_SIZE = 5;

    public IntegerListImpl() {
        data = new Integer[DEFAULT_SIZE];
        size = 0;
        this.currentLength = DEFAULT_SIZE;
    }

    public IntegerListImpl(int startLength) {
        data = new Integer[startLength];
        size = 0;
        this.currentLength = startLength;
    }

    @Override
    public Integer add(Integer item) {
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        size++;
        data[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                Integer s = data[i];
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
    public Integer remove(int index) {
        checkIndex(index);
        Integer s = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return s;
    }


    public boolean contains(Integer element) {
        Integer[] dataSort = sortSelection();
        int min = 0;
        int max = dataSort.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == dataSort[mid]) {
                return true;
            }

            if (element < dataSort[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i>=0; i--) {
            if (item.equals(data[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return data[index];


    }

    @Override
    public boolean equals(IntegerListImpl otherList) {
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
        data = new Integer[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(data,0,result,0,size);
        return result;
    }

    private void checkIndex(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index" + index + "out of bounds ");
        }
    }



    private void grow() {
        if (size == currentLength) {
            currentLength = currentLength + currentLength / 2;
            data = Arrays.copyOf(data, currentLength);
        }
    }


    private Integer[] sortSelection() {
        Integer[] arr = toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }

        return arr;
    }


}
