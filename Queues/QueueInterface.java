package Concepts.Queues;

import java.util.Comparator;
import java.util.PriorityQueue;

class CustomComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}

class CustomComparable implements Comparable<Integer>{

    @Override
    public int compareTo(Integer o) {
        if(o%2==0){
            return 1;
        }
        return -1;
    }
}
public class QueueInterface {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(9);
        queue.add(2);
        queue.add(7);
        queue.add(4);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
