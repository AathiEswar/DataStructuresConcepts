package Concepts.Recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
       // permutationString("abd" , "");

       // System.out.println(permutationStringArrayExtra("abc" , "" , new ArrayList<>()));

        System.out.println(permutationStringArrayOn("abc" ,""));
       // System.out.println(permutationCountNoExtra("" , "abc"));
    }
    public static int permutationCountNoExtra(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count=0;
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0 , i);
            String last = p.substring(i , p.length());

            count += permutationCount(first + ch + last , up.substring(1) , count);
        }

        return count;
    }
    public static int permutationCount(String p , String up , int count){
        if(up.isEmpty()){
            return ++count;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0 , i);
            String last = p.substring(i , p.length());

         count = permutationCount(first + ch + last , up.substring(1) , count);
        }

        return count;
    }

    public static ArrayList permutationStringArrayOn(String up ,String p){
        if(up.isEmpty()){
            ArrayList<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        ArrayList<String> result = new ArrayList<>();

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String last = p.substring(i , p.length());

            result.addAll(permutationStringArrayOn(up.substring(1) , first  + ch + last));
        }
        return result;
    }


    public static ArrayList permutationStringArrayExtra(String up , String p , ArrayList<String> result){
        if(up.isEmpty()){
            result.add(p);
            return result;
        }

        char ch = up.charAt(0);

        for(int i=0;i<=p.length();i++){
            String first = p.substring(0 , i);
            String last = p.substring(i , p.length());
         //   System.out.println(first + " " + ch + " " + last + " !!");

             result =  permutationStringArrayExtra(up.substring(1) , first + ch + last , result);
        }

        return result ;
    }
    public static void permutationString(String up , String p){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }

        char ch = up.charAt(0);

        for(int i=0;i<=p.length();i++){
            String first = p.substring(0 , i);
            String last = p.substring(i , p.length());
            System.out.println(first + " " + ch + " " + last + " !!");

            permutationString(up.substring(1) , first + ch + last);
        }
    }
}
