package Concepts.Recursion;

import java.util.ArrayList;

public class CombinationOfPhoneNumber {
    public static void main(String[] args) {
    //combinationOfPhone("" , "12");
        //System.out.println(combinationPhoneMemoArg("" , "12" , new ArrayList<>()));
        System.out.println(combinationPhoneMemo("" , "485"));
    }
    public static ArrayList combinationPhoneMemo(String p  , String up ){
        if(up.isEmpty()){
            ArrayList<String> result  = new ArrayList<>();
            result.add(p);
            return result;
        }

        int digit = up.charAt(0) - '0';
        int start = (digit-1) * 3;
        int end = digit * 3;

        ArrayList<String> result  = new ArrayList<>();

        for(int i = start ; i < end ; i++){
            char ch =  (char)(i + 'a' );

            result.addAll(combinationPhoneMemo(ch +p , up.substring(1)));
        }
        return  result;
    }

    public static ArrayList combinationPhoneMemoArg(String p , String up , ArrayList<String> result){
        if(up.isEmpty()){
            result.add(p);
            return result;
        }

        int digit = up.charAt(0) - '0' ;

        int start = (digit -1) *3;
        int end = digit * 3;

        for(int i = start ; i<end;i++){
            char ch = (char) ( 'a' + i);
            result = combinationPhoneMemoArg((String)(p+ch) , up.substring(1) , result);
        }

        return result;
    }

    public static void combinationOfPhone(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i= (digit-1)*3 ; i< (digit*3) ; i++){
            char ch = (char)(i + 'a');
            combinationOfPhone( (String)(p+ch) , up.substring(1));
        }
    }
}
