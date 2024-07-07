package Concepts.Stacks.ExpressionNotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "( 4 + 5 ) * ( 1 - 5 )";

        String[] expArr = reverseArray(exp.split(" "));

        for (int i = 0; i < expArr.length; i++) {

            if (expArr[i].equals("(") ) {
                expArr[i] = ")";
                i++;
            } else if (expArr[i].equals(")") ) {
                expArr[i] = "(";
                i++;
            }
        }

        String result = infixToPrefix(String.join(" " , expArr));
        String[] resultArr = reverseArray(result.split(" "));

        System.out.println(String.join(" " , resultArr));

    }
    public static String[] reverseArray(String[] expression){
        for(int i = 0 ; i < expression.length/2 ; i++){
            String temp = expression[i];
            expression[i] = expression[expression.length - 1 - i ];
            expression[expression.length - 1 - i] = temp;
        }
        return expression;
    }
    public static String infixToPrefix(String expression){
        // create necessary ds
        ArrayList<String> postfixResult = new ArrayList<>();

        // stack to do the operations
        Stack<String> stack = new Stack<>();

        // split and iterate through the text
        for(String chr : expression.split(" ")){
            if(chr.equals("(")){
                stack.push("(");
            }
            else if(chr.equals(")")){
                while(!stack.isEmpty() && stack.peek()!= "("){
                    postfixResult.add(stack.pop());

                }
                stack.pop();
            }
            // if operator need to perform some operations
            else if(isOperator(chr)){
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
            default -> -1 ;
        };
    }
}
