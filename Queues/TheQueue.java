package Concepts.Queues;

import java.util.PriorityQueue;
import java.util.Queue;

final class TestInterfaceQueue{
    TestInterfaceQueue(){
    PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue);

        queue.offer(1);
        queue.offer(7);
        queue.offer(8);
        queue.offer(4);
        System.out.println(queue);

        System.out.println(queue);
    }
}
final class TestCustomQueue{

    TestCustomQueue(){
        TheCustomQueue queue = new TheCustomQueue(5);
        queue.display();

        System.out.println("Trying to remove from the queue:");
        queue.remove();

        System.out.println("Inserting elements to the queue:");
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.display();
        System.out.println("Insert after max capacity:");
        queue.insert(6);

        System.out.println("Removing from queue:");
        queue.remove();
        queue.display();
        System.out.println(queue.getSize());
//
        System.out.println("Inserting again : "+queue.getSize());
        queue.insert(1);
        queue.display();



    }
}

class TheCustomQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    TheCustomQueue(int size) {
        capacity = size;
        queue = new int[size];
        front = 0;
        rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return size;
    }
    public int peek(){
        return queue[rear];
    }

    public int insert(int val){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            rear = (rear+1)%capacity;
            queue[rear] = val;
            size++;
        }

        return val;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        else{
            int val = queue[front];
            front = (front+1)%capacity;
            size--;
            return val;
        }
    }

    public void display(){
        if(front <= rear){
            System.out.print("[");
            for(int i = front;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.print("]\n");

        }
        else{
            System.out.print("[");
            for(int i = front ;i<capacity;i++){
                System.out.print(queue[i]+" ");
            }
            for (int i=0;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.print("]\n");
        }
    }
}

public class TheQueue {
    public static void main(String[] args) {
//        TestCustomQueue tcq = new TestCustomQueue();
        TestInterfaceQueue tiq = new TestInterfaceQueue();
    }
}
