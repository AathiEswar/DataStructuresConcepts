package Concepts.Stacks.ExpressionNotations;

import java.util.Stack;

import static Concepts.Stacks.ExpressionNotations.InfixToPostFix.isOperator;

public class PrefixToPostfix {
    public static void main(String[] args) {
        System.out.println(prefixToPostfix("+*15-87"));
    }

    public static String prefixToPostfix(String expression){
        // create stack
        Stack<String> stack = new Stack<>();

        // if its prefix start from last
        for(int i = expression.length()-1 ;i>=0;i--){
            char chr = expression.charAt(i);

            if(isOperator(chr+"")){
                String num1 = stack.pop();
                String num2 = stack.pop();

                stack.push(num1 + num2 + chr);
            }
            else{
                stack.push(chr+"");
            }
        }

        return stack.pop();
    }
}
