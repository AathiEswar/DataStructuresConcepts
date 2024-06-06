package Concepts.Recursion;

public class KunalTest {
    public static void main(String[] args) {
//       meeting(5);

        //System.out.println(fibonacci(2));

        //System.out.println(gcd(180 , 17));
        int arr[] = {1,2,5,87,99,101};

        System.out.println(binarySearchRecursion(arr , 0 , arr.length-1,101));
    }

    public static int binarySearchRecursion(int[] arr , int start , int end , int val){
        if(start > end) return -1;

        int mid = start + (end-start)/2;

        if(arr[mid] == val) return  mid;

        if(arr[mid] > val){
           return binarySearchRecursion(arr , start , mid-1 ,val);
        }

           return binarySearchRecursion(arr , mid+1 , end , val);
    }
    public static void meeting(int n){
        if(n==0)return;
       // System.out.println("Hello World " + n);
        meeting(n-1);
        System.out.println("Hello World " + n);
    }

    public static int fibonacci(int n){
        if(n<2)return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }
    public  static int gcd(int a , int b){
        if(b== 0)return a;

        return gcd(b , a%b);
    }
}
