package Concepts.Recursion;

import java.util.Arrays;

public class PatternsAndSortingBasic {
    public static void main(String[] args) {
       // reverseRightTriangle(7);
        // reverseRightTriangleFull(4,0);

        //rightTriangleFull(4 , 0);

        int[] arr = {7,2,9,4,7};

        //bubbleSortRecursion(arr , 0 , arr.length-1);
        selectionSort(arr , 0 , arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static  void selectionSort(int[] arr ,int start , int end , int maxIndex){
        if(end == 0) return ;

        if(start < end){
            if(arr[start] > arr[maxIndex]){
                System.out.println(end + " " + arr[start] + "in the start<end");
                selectionSort(arr , start+1 , end , start);
            }
            else{

                System.out.println(end + " " + arr[start] + " end the else ");

                selectionSort(arr , start+1 , end , maxIndex);
            }
        }
        else{
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[end-1];
            arr[end-1] = temp;
               System.out.println(end + " " + start);
            selectionSort(arr , 0 , end-1 , 0);
        }
    }

    public static void bubbleSortRecursion(int[] arr , int start , int end){
        if(start > end)return ;

        if(start < end){
            if(arr[start] > arr[start+1]){
                int temp = arr[start+1];
                arr[start+1] = arr[start];
                arr[start] = temp;

            }
            bubbleSortRecursion(arr , start+1 , end);
        }
        else{
            bubbleSortRecursion(arr ,0 , end-1);
        }
    }

    public static void reverseRightTriangle(int n){
        if(n==0) return ;

        for(int i=0;i<n;i++){
            System.out.print("*");
        }
        System.out.println();
        reverseRightTriangle(n-1);
    }
    public static void reverseRightTriangleFull(int row  , int col){
        if(row == 0)return ;

        if(col < row) {
            System.out.print("*");
            reverseRightTriangleFull(row , col+1);
        }
        else{
            System.out.println();
            reverseRightTriangleFull(row-1 , 0);
        }
    }
    public static void rightTriangleFull(int row , int col) {
        if (row == 0) return;

        if (col < row) {
            rightTriangleFull(row, col + 1);
            System.out.print("*");
        } else {
            rightTriangleFull(row - 1, col);
            System.out.println();
        }
    }
}
