package Concepts.Recursion;
import java.util.*;
public class CombiPhoneGoogleLeetCode {


    static HashMap<Integer , String> map = new HashMap<>(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    public static void main(String[] args) {
        System.out.println(letterCombinations("25"));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<String>();
        }
        return combinationPhoneMemo("" , digits);
    }

    public static ArrayList combinationPhoneMemo(String p  , String up ){
        if(up.isEmpty()){
            ArrayList<String> result  = new ArrayList<>();
            result.add(p);
            return result;
        }

        int digit = up.charAt(0) - '0';


        String rangeStr = map.get(digit);
        //System.out.println(rangeStr);

        int start = rangeStr.charAt(0) - 'a';
       // System.out.println(start);
        int end = rangeStr.charAt(rangeStr.length()-1) - 'a';

     //   System.out.println(end);


        ArrayList<String> result  = new ArrayList<>();

        for(int i = start ; i <= end ; i++){
            char ch =  (char)(i + 'a' );

            result.addAll(combinationPhoneMemo(p + ch , up.substring(1)));
        }
        return  result;
    }
}
