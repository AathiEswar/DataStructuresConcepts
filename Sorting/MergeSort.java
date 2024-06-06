package Concepts.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {4,8,4,563,2,32,7};

        mergeSort(arr , 0 , arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr , int start , int end) {
        if(end-start == 1) return ;

        int mid = start + (end-start)/2 ;
        mergeSort(arr,start , mid );
        mergeSort(arr,mid , end );

        mergeArrays(arr , start , mid , end);
    }

    private static void mergeArrays(int[] arr, int start, int mid, int end) {
        int[] mergeArray = new int[end-start];

        int i=start;
        int j = mid;
        int k=0;

        while(i<mid && j < end){
            if(arr[i] < arr[j]){
                mergeArray[k] = arr[i];
                i++;
            }
            else{
                mergeArray[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<mid){
            mergeArray[k] = arr[i];
            i++;
            k++;
        }
        while(j<end){
            mergeArray[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mergeArray.length; l++) {
            arr[l+start] = mergeArray[l];
            
        }
    }
}
