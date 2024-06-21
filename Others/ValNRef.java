package Concepts.Others;

final class A{
    public void printArr(int[] arr){
        arr[1] = 0;
        for(int ele : arr )
        {
            System.out.print(ele+" ");
        }
        System.out.println("");
    }

}
public class ValNRef {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        A a = new A();
        a.printArr(arr);
        for (int ele : arr)
        {
            System.out.print(ele + " ");
        }

    }

}
