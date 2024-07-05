package Concepts.SortingAndSearch;

import java.util.Arrays;


public class Sorting {

    public static void display(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        //swap bigger element to the right by iterating
        //repeat for all the elements
        // TC = O(N^2)
        //the simplest and the worst sort
        int len = a.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len -1- i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        display(a);
    }

    public static void selectionSort(int[] a) {
        //selects the largest element and swap with the last element || selects the min element and swap with the front element
        // repeat the process for all the elements
        //TC = O(N^2) slightly better than bubble sort

        int len = a.length;

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }

        display(a);
    }

    public static void insertionSort(int[] a) {
        //it is the fastest sort among the 3 simple sorting methods
        // Tc = O(N^2) but fewer comparisons and swaps
        //Take the cur element and store it in a tempVar
        //check if the left element is smaller,if not then move places till the left element is smaller and then occupy that position

        int len = a.length;

        for (int i = 0; i < len; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0 && a[j - 1] >= temp) {
                a[j] = a[j - 1];
                --j;
            }
            a[j] = temp;
        }

        display(a);
    }


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, -1};
        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);

    }

}
