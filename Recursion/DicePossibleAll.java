package Concepts.Recursion;

import java.util.ArrayList;

public class DicePossibleAll {
    public static void main(String[] args) {
        //dicepossible("",4);

     //   System.out.println(dicePossibleMemoArg("" , 6 , new ArrayList<>()));
        System.out.println(dicePossibleMemo("" , 7));
    }

    public static ArrayList dicePossibleMemo(String p  , int target){
        if(target == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }
        ArrayList<String> result = new ArrayList<>();

        for(int i = 1;i<=6 && i<=target;i++){
        result.addAll(dicePossibleMemo(p+i , target-i) );
        }

        return result;
    }

    public static ArrayList dicePossibleMemoArg(String p , int target , ArrayList<String> result){
        if(target == 0){
            result.add(p);
            return result;
        }

        for(int i=1;i<=6 && i<= target;i++){
            result = dicePossibleMemoArg(p+i , target-i , result);
        }

        return result;
    }

    public static void dicepossible(String p , int target){
        if(target == 0){
            System.out.println(p);
            return ;
        }

        for(int i = 1;i<=6 && i<=target;i++){
            dicepossible(p+i ,target-i);
        }
    }
}
