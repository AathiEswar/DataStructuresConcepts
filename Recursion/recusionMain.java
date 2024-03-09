package Concepts.Recursion;

public class recusionMain {
    public static int sumOfN(int n){
        //base case
        if(n==0){
            return 0;
        }


        return n + sumOfN(n-1);
    }


    public static void main(String[] args){
//        System.out.println(sumOfN(6));

        System.out.println("Grid ways : "+nXmgirdWays.gridways(3,3));
    }
}
