package Concepts.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StringsRecursion {
    public static void main(String[] args) {
        String s = "aathi";

        //System.out.println(removeChar(s , 'a'));
        //System.out.println(skipString("Aathi Eswar S" , "Aathi"));

        //permutationOfStringWithExtraString("abc" , " ");
        //System.out.println(permutationOfStringInList("abc" , "" , new ArrayList<String>()));

        //System.out.println(permutationOfStringReturnList("abc" , ""));

        //StringSubsetIteration(new int[]{1,2,3 ,3});

        StringSubsetIterationDuplicats(new int[]{1,2,3,3});
    }
    public static void StringSubsetIterationDuplicats(int[] arr){
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for(int i = 0 ;i < arr.length;i++){
            int innerSize = result.size();
            start = 0;
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = result.size()-1;
            for(int j = start;j<innerSize;j++){
                List<Integer> inner  = new ArrayList<>(result.get(j));
                inner.add(arr[i]);
                result.add(inner);
            }
        }

        System.out.println(result);
    }

        public static void StringSubsetIteration(int[] arr){
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int num : arr){
            int innerSize = result.size();

            for(int i = 0;i<innerSize;i++){
                List<Integer> inner  = new ArrayList<>(result.get(i));
                inner.add(num);
                result.add(inner);
            }
        }

        System.out.println(result);
    }



    public static ArrayList permutationOfStringReturnList(String s , String p){
        if(s.isEmpty()){
            ArrayList<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        ArrayList<String> left = permutationOfStringReturnList(s.substring(1) , p);
        ArrayList<String> right = permutationOfStringReturnList(s.substring(1) , s.charAt(0) + p);

        left.addAll(right);

        return left;
    }

    public static ArrayList permutationOfStringInList(String s , String p, ArrayList<String> result) {
        if(s.isEmpty()){
            result.add(p);
            return result;
        }

        permutationOfStringInList(s.substring(1) , p , result);
        return permutationOfStringInList(s.substring(1) , s.charAt(0) + p , result);


    }

    public static void permutationOfStringWithExtraString(String s , String p) {
        if(s.isEmpty()){
            System.out.println(p);
            return ;
        }
        // leave the cur Charater
        permutationOfStringWithExtraString(s.substring(1) , p);
        
        //take the cur character 
        permutationOfStringWithExtraString(s.substring(1) ,  s.charAt(0) + p);
    }

    public static String removeChar(String s , char ch ){
        if(s.isEmpty())return "";

        char chr = s.charAt(0);
        if(chr == ch){
            return removeChar(s.substring(1) ,  ch);
        }

        return chr + removeChar(s.substring(1) , ch);
    }
    public static String skipString(String s , String toSkip){
        if(s.isEmpty())return "";

        if(s.startsWith(toSkip)){
            return skipString( s.substring(toSkip.length()) , toSkip);
        }
        return s.charAt(0) +  skipString(s.substring(1) , toSkip);
    }
}
