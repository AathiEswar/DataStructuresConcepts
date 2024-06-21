package Concepts.Heaps;


public class MainHeap  {
    public static void main(String[] args) throws  Exception{
        HeapMin<Integer> heapMin = new HeapMin<>();
        heapMin.insert(34);
        heapMin.insert(12);
        heapMin.insert(67);
        heapMin.insert(2);
        heapMin.insert(99);
        heapMin.insert(5);

        System.out.println(heapMin.heapsort());
    }
}
