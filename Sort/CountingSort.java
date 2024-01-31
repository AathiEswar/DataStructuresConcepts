package Concepts.Sort;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] a){
        int max = Arrays.stream(a).max().orElse(Integer.MAX_VALUE);
        int min = Arrays.stream(a).min().orElse(0);

        int[] newArr = new int[max-min+1];

        for(int e : a){
            newArr[e-min]++;
        }
        int j = 0;
        for(int i=0;i<max-min+1;i++){
            while (newArr[i] > 0){
                a[j] = i+min;
                newArr[i]--;
                j++;

            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int[] arr = {-2,-1,4,6,7,8,3,4};

        countingSort(arr);
    }
}
