package org.example.testSort;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] array = new Integer[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 300) - 150);
        }
            Integer[] array2 = Arrays.copyOf(array, array.length);
            Integer[] array3 = Arrays.copyOf(array, array.length);
        long start = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println("sort insertion " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        sortSelection(array2);
        System.out.println("sort selection " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println("sort bubble " + (System.currentTimeMillis()-start));




        }
        public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void swapElements(Integer[] arr, Integer indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

}

