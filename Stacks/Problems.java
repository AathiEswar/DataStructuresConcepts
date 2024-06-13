package Concepts.Stacks;
import java.util.*;
public class Problems {
    public static void main(String[] args) {

    }
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
    class MyQueue {
        Stack<Integer> stack1 ;
        Stack<Integer> stack2 ;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());

            }

            stack1.push(x);

            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            System.out.println(stack2.peek());
        }

        public int pop() {
            int popVal = stack2.pop();

            return popVal;
        }

        public int peek() {
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty();
        }
    }
}
