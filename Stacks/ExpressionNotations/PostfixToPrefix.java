package Concepts.Stacks.ExpressionNotations;

import java.util.Stack;

import static Concepts.Stacks.ExpressionNotations.InfixToPostFix.isOperator;

public class PostfixToPrefix {
    public static void main(String[] args) {
        System.out.println(postfixToPrefix("12+59-*"));
    }

    public static String postfixToPrefix(String expression){
        // create stack
        Stack<String> stack = new Stack<>();

        // if its prefix start from last
        for(int i = 0 ; i<expression.length();i++){
            char chr = expression.charAt(i);

            if(isOperator(chr+"")){
                String num1 = stack.pop();
                String num2 = stack.pop();

                stack.push(chr + num2 + num1);
            }
            else{
                stack.push(chr+"");
            }
        }

        return stack.pop();
    }
}
