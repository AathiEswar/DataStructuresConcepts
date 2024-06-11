package Concepts.Recursion;

public class StringsRecursion {
    public static void main(String[] args) {
        String s = "aathi";

        //System.out.println(removeChar(s , 'a'));
        //System.out.println(skipString("Aathi Eswar S" , "Aathi"));

        permutationOfStringWithExtraString("abc" , " ");
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
