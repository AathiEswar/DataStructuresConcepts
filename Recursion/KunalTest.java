package Concepts.Recursion;

public class KunalTest {
    public static void main(String[] args) {
//       meeting(5);

        //System.out.println(fibonacci(2));

        //System.out.println(gcd(180 , 17));

        //int arr[] = {1,2,5,87,99,101};
        //System.out.println(binarySearchRecursion(arr , 0 , arr.length-1,101));

        //printTillOne(5);

//        System.out.println(factorial(5));

        //System.out.println(sumTillN(100));

        //System.out.println(sumOfDigits(3525));

        //System.out.println(productOfDigits(101));

        //reverseNumber(102023);
        //System.out.println(sumForReverse);

        //System.out.println(reverseNumberWithHelper(123456));

        System.out.println(numberOfZeros(120001, 0));

    }
    public int numberOfSteps(int num) {
        return numberOfStepsHelper(num , 0);
    }

    public int numberOfStepsHelper(int num , int count){
        if(num == 0) return count;

        if(num %2 == 0) return numberOfStepsHelper( num / 2 , ++count);

        return numberOfStepsHelper(num-1 , ++count);
    }

    public static int numberOfZeros(int n , int count){
        if(n==0) return count;

        int rem = n%10;

        if(rem == 0) return numberOfZeros(n/10 , count+1);

        return numberOfZeros(n/10 , count);
  }

    // reverse using helper function

    public  static int reverseNumberWithHelper(int n){
        int digits = (int) Math.log10(n) + 1;

        return reverseNumberHelper(n , digits);
    }

    private static int reverseNumberHelper(int n , int digits) {
        if(n%10 == n) return n;

        int unitDigit = n%10;

        return unitDigit * (int)Math.pow(10 , digits-1) + reverseNumberHelper(n/10 , digits-1);
    }

    // reverse using static variable
    static  int sumForReverse = 0;
    public  static void reverseNumber(int n){
       if(n == 0) return ;

       int digit = n%10;
       sumForReverse = sumForReverse*10 + digit;

       reverseNumber(n/10);
    }

    public static int productOfDigits(int n){
        if(n%10 == n) return n;

        return (n%10) * productOfDigits(n/10);
    }

    public static int sumOfDigits(int n){
        if(n == 0)return 0;

        int digit = n%10;

        return digit + sumOfDigits(n/10);
    }

    public static int sumTillN(int n){
        if(n<2) return n;

        return n + sumTillN(n-1);
    }
    public  static int factorial(int n){
        if(n==0 )return 1;

        return n * factorial(n-1);
    }
    public static void printTillOne(int n){
        if(n<1){
            return ;
        }
        printTillOne(n-1);
        System.out.println(n);
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
