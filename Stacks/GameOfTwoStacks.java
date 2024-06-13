package Concepts.Stacks;

import java.util.ArrayList;
import java.util.List;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>() {
            {
                add(4);
                add(2);
                add(4);
                add(6);
                add(1);
            }
        };
        ArrayList<Integer> arr2 = new ArrayList<>() {
            {
                add(2);
                add(1);
                add(8);
                add(5);
            }
        };

        System.out.println(gameOfStack(arr1 , arr2 , 10 , 0 , 0));

    }

    public static int gameOfStack(List<Integer> arr1 , List<Integer> arr2 , int maxSum , int sum , int count){
        if(sum> maxSum){
            return count;
        }
        if(arr1.isEmpty() || arr2.isEmpty())return count;

        int count1 = gameOfStack(arr1.subList(1, arr1.size()) , arr2 , maxSum , sum + arr1.get(0) , count+1);
        int count2 = gameOfStack(arr1 , arr2.subList(1, arr2.size()) , maxSum , sum + arr2.get(0) , count+1);

        return Math.max(count1 , count2);
    }
}
