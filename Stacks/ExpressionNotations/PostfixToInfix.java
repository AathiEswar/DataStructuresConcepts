package Concepts.Stacks.ExpressionNotations;

import java.util.Stack;

import static Concepts.Stacks.ExpressionNotations.InfixToPostFix.isOperator;

public class PostfixToInfix {
    public static void main(String[] args) {
        System.out.println(postfixToInfix("456*+"));
    }
    public static String postfixToInfix(String expression){
        // create necessary ds
        Stack<String> stack = new Stack<>();

        // iterate through the expression
        for(int i = 0 ; i<expression.length();i++){
            // get the character
            char chr = expression.charAt(i);

            // if a operator
            if(isOperator(chr+"")){

                // pop two num perform operations
                String num1 = stack.pop();
                String num2 = stack.pop();

                // add back the expression to the stack
                stack.push("(" + num2 + chr + num1 + ")" );
            }
            // if a number or var
            else{
                stack.push(chr + "");
            }
        }

        // return the result
        return stack.pop();
    }
}
