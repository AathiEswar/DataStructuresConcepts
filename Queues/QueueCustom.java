package Concepts.Queues;

class QueueCus{

    static int[] queue;
    static int front;
    static int rear;
    static int count;

    static int capacity;

    QueueCus(){
        capacity = 5;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public  int size(){
        return count;
    }
    public  boolean isFull(){
        return (size() == capacity);
    }
    public  boolean isEmpty(){
        return (size()==0);
    }

    public  void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear = (rear+1) % capacity;
        queue[rear] = data;
        count++;

    }

    public  int dequeue(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int deq = queue[front];
        front = (front+1)%capacity;
        count--;

        return deq;
    }

    public int peek(){
        if(isEmpty()) return -1;
        return queue[front];
    }

    public void displayQueue(){
        if(front<rear){
            for(int i = front ;i<=rear;i++){
                System.out.print(queue[i] + " ");
            }
        }
        else {
            for (int i = 0; i <=rear; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = front; i <capacity; i++) {
                System.out.print(queue[i] + " ");
            }
        }
    }

}
public class QueueCustom {
    public static void main(String[] args) {
        QueueCus q = new QueueCus();
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());

        q.enqueue(1);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());

//        q.dequeue();
//        System.out.println("Empty: " + q.isEmpty());
//        System.out.println("Full: " + q.isFull());
//        System.out.println("Peek: "+ q.peek());

        q.enqueue(2);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());

        q.enqueue(3);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());

        q.enqueue(4);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());

        q.enqueue(5);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());
        System.out.println(q.size());
        q.displayQueue();

        q.enqueue(6);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());
        System.out.println("Size: " + q.size());

        q.enqueue(6);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());
        System.out.println("Size: " + q.size());

        q.dequeue();
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());
        System.out.println("Size: " + q.size());

        q.enqueue(6);
        System.out.println("Empty: " + q.isEmpty());
        System.out.println("Full: " + q.isFull());
        System.out.println("Peek: "+ q.peek());
        System.out.println("Size: " + q.size());

        q.displayQueue();







    }

}


