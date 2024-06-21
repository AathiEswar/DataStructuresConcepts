package Concepts.Heaps;

import java.util.Comparator;
import java.util.*;

public class HeapMax <T extends Comparable<T>> {
    private ArrayList<T> list;

    public HeapMax(){
        list = new ArrayList<>();
    }

    public void swap(int first , int second ){
        T temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }

    private int findParent(int index){
        return (index - 1)/2;
    }

    private int findLeftChild(int index){
       return (index*2) + 1;
    }

    private int findRightChild(int index){
        return (index*2) + 2;
    }

    public void insert(T val){
        list.add(val);

        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if(index == 0) return;

        int parentIndex = findParent(index);

        if(list.get(index).compareTo(list.get(parentIndex)) > 0){
            swap(index , parentIndex);
            upheap(parentIndex);
        }
    }


   public T remove() throws  Exception{
        if(list.isEmpty()){
            throw new Exception("No elements in the heap");
        }
        T root = list.get(0);


        T lastElement = list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0 , lastElement);

            downheap(0);
        }
        return root;

   }

    private void downheap(int index) {
        int max = index;
        int left = findLeftChild(max);
        int right = findRightChild(max);

        if(left < list.size() && list.get(left).compareTo(list.get(max)) > 0 ){
            max = left;
        }

        if(right < list.size() && list.get(right).compareTo(list.get(max)) > 0 ){
            max = right ;
        }

        if(max != index){
            swap(max , index);
            downheap(max);
        }
    }


    public ArrayList<T> maxHeapSort() throws  Exception{
        if(list.isEmpty()){
            throw new Exception("No elements in the list");
        }

        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty())  {
            data.add(this.remove());
        }
        return data;
    }
}
