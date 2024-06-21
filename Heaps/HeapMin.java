package Concepts.Heaps;

import java.util.ArrayList;

    public class HeapMin<T extends Comparable<T>> {
        public ArrayList<T> list ;

    // initialize the arraylist
    public HeapMin(){
        list = new ArrayList<>();
    }

    // swap for insert and delete the node
    private void swap(int first , int second){
        T temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }

    // find parent i/2 of that child
    private int findParent(int index){
        return (index-1)/2;
    }


    // find left child
    private int findLeftChild(int index){
        return index*2 + 1;
    }


    // find right child
    private int findRightChild(int index){
        return index*2 + 2;
    }

    // insert :
    // add the node in the arraylist
    // upheap - get parent index , check if child is small then swap to the parent index
    // base condition would be no element so return ;

    public void insert(T val){
        // add the value to end of list
        list.add(val);

        // upheap for formating of the heap tree
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        // if the element is the root then return
        if(index == 0)return;

        // find parent index
        int parentIndex = findParent(index);

        // if parent is greater than the added node then swap
        if(list.get(index).compareTo(list.get(parentIndex)) < 0){
            swap(index , parentIndex);
            upheap(parentIndex);
        }
    }

    // delete from heap
    // remove the root and add the last element as root
    // base if the array is already empty
    // downheap - take left and right , compare which is the min and swap to that
    // base for down heap would be if no min on left and right to the root

    public T remove() throws Exception{
        // is no element we cant remove anything so throw exception
        if(list.isEmpty()){
            throw new Exception("List is empty");
        }

        // get the first element ( if removed then the order will mess up )
        T temp = list.get(0);

        // remove the last element ( we already know at least one element exits
        T lastNode = list.remove(list.size()-1);

        // there could be only the node element
        if(!list.isEmpty()){
            // set the last node as the first element
            list.set(0 , lastNode);

            // continue to down heap to fix the structure
            downheap(0);
        }

        // return the min root
        return temp;

    }

    private void downheap(int val) {
        // get min , left and right indexes
        int min = val ;
        int left = findLeftChild(min);
        int right = findRightChild(min);

        // if left is withing array list and if its smaller than the min then min = left
        if(left < list.size() && list.get(min).compareTo(list.get(left)) >0){
            min = left;
        }

        // if right thing array list and if its smaller than the min then min =right
        if(right < list.size() && list.get(min).compareTo(list.get(right)) >0){
            min = right;
        }

        // if the min is dif than the root , ( the left or right must be smaller)
        if(min != val){
            // swap and continue the downheap
            swap(min , val);
            downheap(min);
        }
    }

    public ArrayList<T> heapsort() throws  Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is empty");
        }

        ArrayList<T> data = new ArrayList<>();

        while(!list.isEmpty()){
            data.add(this.remove());
        }

        return data;
    }
}
