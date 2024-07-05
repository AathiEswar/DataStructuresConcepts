package Concepts.Stacks;

import java.util.Scanner;


public class ParanthesisChecker {

    public static void Checker(String input){
        char[] stack = new char[input.length()];
        int top = -1;
        for(char ch : input.toCharArray()){
            if(ch=='(' || ch=='{'|| ch=='['){
                stack[++top] = ch;
//                System.out.println(stack[top] +" "+top);
            }
            else{
                if(top>=0 && (stack[top] == '(' && ch == ')' ||stack[top] == '[' && ch == ']' ||stack[top] == '{' && ch == '}'  )) {
//                    System.out.println(stack[top] +" "+top);
                    top--;
                }
                else{
                    break;
                }
            }
        }
        System.out.println((top==-1)?"Balanced":"Not Balanced");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "{([]())}";
        Checker(input);
    }


}
