package Concepts.Recursion;

import java.util.ArrayList;

public class ArrayRecursion {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,5,3,5,3,5,3,3,3,4,5,5,5,5,55,5,9,7};
            int[] arr = {5,6,7,8,9,1,2,3};
        //System.out.println(isSortedArray(arr , 0));

        //System.out.println(linearSearchRecusion(arr , 1, 0));

        //System.out.println(linearSearchAllRecusion(arr , 5 , 0 , new ArrayList<Integer>()));

        System.out.println(binarySearchRotatedArray(arr , 9 , 0 , arr.length-1));
    }

    public static int binarySearchRotatedArray(int[] arr , int target , int start ,int end){
        if(start > end) return -1;

        int mid = start + (end-start)/2;

        if(arr[mid] == target) return mid;

        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && arr[mid] >= target){
                return binarySearchRotatedArray(arr , target , start , mid-1);
            }
            else{
                return binarySearchRotatedArray(arr , target , mid+1 , end);
            }
        }

        if(target<= arr[end] && target>= arr[mid]){
            return binarySearchRotatedArray(arr , target , mid+1 , end);
        }

        return binarySearchRotatedArray( arr , target , start , mid-1);
    }

    public static boolean isSortedArray(int[] arr , int index){
        if(index == arr.length-1) return true;
        return arr[index] < arr[index+1] && isSortedArray(arr , index+1);
    }

    public static int linearSearchRecusion(int[] arr , int target,int index){
        if(index == arr.length) return -1;

        if(arr[index] == target) return index;

        return linearSearchRecusion(arr ,target , index+1);
    }
    public static ArrayList linearSearchAllRecusion(int[] arr , int target, int index , ArrayList<Integer> result){
        if(index == arr.length) return result;

        if(arr[index] == target) result.add(index);

        return linearSearchAllRecusion(arr ,target , index+1 , result);
    }
}
