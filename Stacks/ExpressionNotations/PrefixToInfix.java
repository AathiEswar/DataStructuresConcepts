package Concepts.Stacks.ExpressionNotations;

import java.util.Stack;

import static Concepts.Stacks.ExpressionNotations.InfixToPostFix.isOperator;

public class PrefixToInfix {
    public static void main(String[] args) {
        System.out.println(prefixToPostfix("*+12-55"));
    }

    public static String prefixToPostfix(String expression ){

        Stack<String> stack = new Stack<>();

        for(int i = expression.length()-1 ; i>=0 ; i--){
            char chr = expression.charAt(i);

            if(isOperator(chr + "")){
                String num1 = stack.pop();
                String num2 = stack.pop();

                stack.push("(" + num1 + chr  + num2 + ")");
            }
            else{
                stack.push(chr+"");
            }
        }
        return stack.pop();
    }
}
