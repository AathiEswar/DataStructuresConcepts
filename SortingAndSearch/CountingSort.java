package Concepts.SortingAndSearch;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,3,2,6,1,3,8,3,5,7,9};

        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void countingSort(int[] arr) {
        // find max
        // create an array with max+1 array
        // find the frequency
        // use the frequency array to build the original sorted array

        int max = arr[0];

        for(int num : arr){
            if(num > max){
                max = num;
            }
        }

        int[] freq = new int[max+1];

        for(int num : arr){
            freq[num]++;
        }

        int index = 0 ;
        for(int i = 0 ; i<max;i++){
            while(freq[i] >0){
                arr[index] = i;
                index++;
                freq[i]--;
            }
        }
    }
}
