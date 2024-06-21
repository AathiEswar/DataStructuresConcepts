package Concepts.Sorting;

public class BinarySearch {

    public static void binarySearchArr(int[] a, int search) {
        int first = 0;
        int last = a.length - 1;
        while (first<=last) {
            int mid = first+(last-first)/2;
            if (a[mid] == search) {
                System.out.println("Element found at "+mid);
                return ;
            } else if (a[mid] > search) {
                last = mid - 1;
            } else first = mid + 1;
        }
        return ;
    }

    public static int agnosticBinarySearch(int[] a, int search){
        int start = 0;
        int end = a.length-1;

        boolean isAsc = a[start]<a[end];

        while(start<=end){
            //not exceeding java int range
            int mid = start+(end-start)/2;

            if(a[mid] == search){
                return mid;
            }
            if(isAsc){
                if(a[mid]>search){
                    end= mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else {
                if(a[mid]>search){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }


        }
        return -1;
    }

    public static int searchCount(int n){
        int pow = 0;
        int powValue = 1;

        while(powValue < n){
            pow = pow +1;
            powValue = (int)Math.pow(2,pow);
        }
        return pow;
    }
    public static void main(String[] args) {
//        int[] arr = {10,11,12,13,14,15,16,17};
        int[] arr = new int[100];
        int len = arr.length;
//        binarySearchArr(arr, 14);
//        System.out.println(agnosticBinarySearch(arr,6));
        System.out.println("Max comparisions needed :"+searchCount(1000));
    }
}
