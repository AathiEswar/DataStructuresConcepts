package Concepts.Stacks;
import java.util.*;
public class InfixToPostFix {
    public static void main(String[] args) {
        String result = infixToPostfix("4 * 5 + 10 / 2");
        System.out.println(result);
        System.out.println(evaluatePostfixExpression(result));
    }

    // infix to postfix conversion

    // functions - InToPost , precedenceChecker , precedenceValue , OperatorChecker
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
            System.out.println(stack.peek());
        }

        return stack.pop();
    }
    public static String infixToPostfix(String expression){
        // create necessary ds
        ArrayList<String> postfixResult = new ArrayList<>();

        // stack to do the operations
        Stack<String> stack = new Stack<>();

        // split and iterate through the text
        for(String chr : expression.split(" ")){
            // if operator need to perform some operations
            if(isOperator(chr)){
                // is the stack is not empty and the peek of stack has higher precedence then pop the peek
                while(!stack.isEmpty() && hasLowerPrecedence(chr , stack.peek())){
                    postfixResult.add(stack.pop());
                }
                // add the cur op to stack for further processing
                stack.push(chr);
            }
            // if number then just add to the result list
            else{
                postfixResult.add(chr);
            }
        }
        // the stack might not be empty yet so add everything to the result list
        while(!stack.isEmpty()){
            postfixResult.add(stack.pop());
        }

        // return the resultant list as a string
        return String.join(" " , postfixResult);
    }

    public static boolean isOperator(String character){
        // create a list of op and return if they contain the operator
        return List.of("+" , "-" , "/" ,"*" , "%").contains(character);
    }

    public static boolean hasLowerPrecedence(String op1 , String op2){
        // check if the precedence in the top is greater than the cur operator
        return precedenceValue(op1) < precedenceValue(op2);
    }

    public static int precedenceValue(String op){
        // switch can return the value

        // return the value of precedence for the precedence checker
        return switch (op){
            case "+" , "-" -> 1;
            case "*" , "/" -> 2;
            case "%" -> 3;
            default -> 4;
        };
    }
}
