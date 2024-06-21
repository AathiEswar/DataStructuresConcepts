package Concepts.Heaps;


public class MainHeap  {
    public static void main(String[] args) throws  Exception{
//        HeapMin<Integer> heapMin = new HeapMin<>();
//        heapMin.insert(34);
//        heapMin.insert(12);
//        heapMin.insert(67);
//        heapMin.insert(2);
//        heapMin.insert(99);
//        heapMin.insert(5);
//
//        System.out.println(heapMin.heapsort());

        HeapMax<Integer> maxHeap = new HeapMax<>();

        maxHeap.insert(34);
        maxHeap.insert(1);
        maxHeap.insert(45);
        maxHeap.insert(89);
        maxHeap.insert(6);
        maxHeap.insert(111);

        System.out.println(maxHeap.maxHeapSort());
    }
}
