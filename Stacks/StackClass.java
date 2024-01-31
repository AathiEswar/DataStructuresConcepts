package Concepts.Stacks;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String hold = stack.push("Item one");
        System.out.println(stack + " " + hold);


        String holder = stack.pop();
        System.out.println(stack + " "+ holder);

        for (int i = 0; i < 5; i++) {
            stack.push(sc.nextLine());
        }
        System.out.println(stack);


        System.out.println(stack.empty());
//        stack.clear();
//        System.out.println(stack.empty());


        stack.set(0,"this is a setted value");
        System.out.println(stack);

        String top = stack.peek();
        System.out.println(top);

        System.out.println("Remove element is 0 idx");
        stack.remove(0);
        System.out.println(stack);

        System.out.println("Sort with custom comparator");
        stack.sort(Collections.reverseOrder());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
