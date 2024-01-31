package Concepts.Stacks;

import java.util.Arrays;

class StackCus{
    static int capacity;
    static int capacityIncrement;
    static int[] arr ;
    static int top;

    StackCus(){
        capacity = 2;
        capacityIncrement = 5;
        top = -1;
        arr = new int[capacity];
    }

    public int getCapacity()
    {
        return capacity;
    }
    public int getTop(){
        if(top == -1) return -1;
        return arr[top];
    }
    public int getCapacityIncrement(){
        return capacityIncrement;
    }
    public boolean isFull(){
        if(capacity == top+1) return true;
        return false;
    }

    public boolean isEmpty(){
        if(top == -1) return true;
        return false;
    }
    public void push(int val){
        if(isFull()) {
            capacity += capacityIncrement;
            int[] temp = new int[capacity];
            for (int i = 0; i <= top; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[++top] = val;
    }
    public int pop(){
        if(isEmpty()) return -1;
        int val = arr[top--];
        return val;
    }

    public int peek(){
        if(isEmpty()) return -1;
        return arr[top];
    }
    public void empty(){
        Arrays.fill(arr,-1);
        top = -1;
    }
}
public class StackCustom {
    public static void main(String[] args) {
        StackCus st = new StackCus();
        System.out.println( st.isEmpty());
        System.out.println( st.isFull());

        st.push(1);
        st.push(2);
        System.out.println(st.peek());
//        st.pop();
//        System.out.println(st.peek());
        System.out.println( st.isEmpty());
        System.out.println( st.isFull());

        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.isFull());
        System.out.println(st.peek());
        System.out.println(st.getCapacity());
        System.out.println(st.getTop());
        System.out.println(st.getCapacityIncrement());

        st.empty();
        System.out.println(st.isFull());
        System.out.println(st.peek());
        System.out.println(st.getCapacity());
        System.out.println(st.getTop());
        System.out.println(st.getCapacityIncrement());


    }
}
