package Concepts.Recursion;

public class nXmgirdWays {
    public static int gridways(int n , int m){

        //base case
        if(n == 1 || m ==1)return 1;
        return gridways(n , m-1)+ gridways(n-1 , m);
    }
}
