package Concepts.Stacks.ExpressionNotations;

import java.util.Stack;

import static Concepts.Stacks.ExpressionNotations.InfixToPostFix.isOperator;

public class InfixEvaluation {
    public static int evaluatePostfixExpression(String expression){
        // create necessary ds
        Stack<Integer> stack = new Stack<>();

        for(String chr : expression.split(" ")){
            // if operator

            if(isOperator(chr)){
                int num1 = stack.pop();
                int num2 = stack.pop();

                switch (chr){
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num2 / num1);
                    case "%" -> stack.push(num2 % num1);
                }
            }
            // if number
            else{
                stack.push(Integer.parseInt(chr));
            }

        }

        return stack.pop();
    }
}
