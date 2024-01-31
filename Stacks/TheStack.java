package Concepts.Stacks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;


final class TestCustomStack {
    TestCustomStack() {
        CustomStack stack = new CustomStack(5);

        stack.display();

        System.out.println("Popping stack:" + stack.pop());
        System.out.println("Pushing to stack :");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();

        System.out.println("Popping stack:" + stack.pop());
        stack.display();

        System.out.println("Pushing to stack : 5");
        stack.push(5);
        stack.display();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();

    }
}

final class TestClassStack  {
    TestClassStack(){
        Stack <Integer> stack = new Stack<>();
        System.out.println("Stack created :"+stack);

        System.out.println("Pushing to stack");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.print("The Stack : ");
        System.out.println(stack);

        System.out.println("The Top element:"+stack.peek());
        stack.pop();
        System.out.println("Stack after popping : "+stack);

    }
}
final class TestStackOperations{

    TestStackOperations(){
        int[] a = {1,2,3,4,5,6,7};
        reverseArray(a);
        reverseString("aathi eswar");
        delimiter("5*(5+7)/(8-7*9)");
    }


    private void reverseArray(int[] a){
        CustomStack stack = new CustomStack(a.length);
        for(int i: a){
            stack.push(i);
        }
        for(int i=0;i<a.length;i++){
            a[i] = stack.pop();
        }
        System.out.println(Arrays.toString(a));
    }

    private void reverseString(String s){
        CustomStack stack = new CustomStack(s.length());
        String res = "";

        for(char ch : s.toCharArray()){
            stack.push(ch);
        }

        for(int i=0;i<s.length();i++){
            res += (char)stack.pop();
        }
        System.out.println(res);
    }

    private void delimiter(String s){
        CustomStack stack = new CustomStack(s.length());

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('||ch == '{'||ch == '['){
                stack.push(ch);
            }
            else if(Character.isLetterOrDigit(ch)== true || ch == '+' || ch == '-' || ch == '/' || ch == '*'){
                continue;
            }
            else{
                char chx = (char)stack.getPeek();
                if(  stack.getTop()>=0 && (   ch==')' && chx=='(' ||
                        ch==']' && chx=='[' ||
                        ch=='}' && chx=='{')){
                    System.out.println(stack.getPeek());
                    stack.pop();
                }
                else{
                    break;
                }
            }
        }
        System.out.println(stack.getTop()==-1?"Balanced":"Not Balanced");
    }
}

class CustomStack {
    private int[] stack;
    private int capacity;
    private int top;

    CustomStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public boolean isFull() {
        if (top + 1 == capacity) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public void push(int ele) {
        if (!isFull()) {
            stack[++top] = ele;
        }

    }

    public int pop() {
        if (!isEmpty()) {
            int val = stack[top--];
            return val;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTop() {
        return top;
    }
    public int getPeek(){
        return stack[top];
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }


}

public class TheStack {
    public static void main(String[] args) {
//        TestCustomStack tsc = new TestCustomStack();
//        TestClassStack tcs = new TestClassStack();
//        TestStackOperations tso = new TestStackOperations();

    }
}
