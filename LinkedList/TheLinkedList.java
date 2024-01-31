package Concepts.LinkedList;


class Node{
    public int data;
    public Node next;

    Node(){}

    Node(int data){
        this.data = data;
        this.next  = null;
    }
}

class LinkedListCustom{
    public Node first;
    private int length;

    LinkedListCustom(){
        first = null;
    }

    public boolean isEmpty(){
        return  first == null;
    }

    public void displayList(){
        Node current = first;
        System.out.print("[");
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print("]\n");
    }

    public void insertFirst(int data){
        Node cur = new Node(data);
        cur.next = first;
        first = cur;
    }

    public void insertAtIndex(int index, int data){
        Node newNode = new Node(data);
        Node cur = first;
        Node prev = first;
        while (index>0){
            if(cur.next == null){
                insertLast(data);
                return;
            }
            prev = cur;
            cur = cur.next;
            index--;
        }
        if(cur==first){
            insertFirst(data);
            return;
        }
        prev.next = newNode;
        newNode.next = cur;

    }

    public void insertLast(int data){
        if(isEmpty()){
            Node newList = new Node(data);
            first = newList;
            return;
        }
        Node temp = new Node(data);
        Node cur = first;

        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = temp;

    }

    public int deleteFirst(){
        if(isEmpty())return -1;
        int data = first.data;
        first = first.next;
        return data;
    }

    public int deleteElement(int data){
        if(isEmpty())return -1;

        Node cur = first;
        Node prev = first;

        while (cur.data != data){
            if(cur.next == null) return -1;

            prev = cur;
            cur = cur.next;
        }
        if(cur == first)first = first.next;

        else  prev.next = cur.next;
        return cur.data;
    }

    public int deleteLast(){
        if(isEmpty())return -1;
        if(first.next == null){
            int data = first.data;
            first = null;
            return data;
        }
        Node cur = first;
        Node prev = first;
        while (cur.next != null){
            prev = cur;
            cur = cur.next;

        }
        prev.next = null;
        return cur.data;

    }

    public boolean find(int data){
        if(isEmpty()){
            return false;
        }
        Node cur = first;

        while (cur != null){
            if(cur.data == data) return true;
            cur= cur.next;
        }
        return false;


    }


}
public class TheLinkedList {
    public static void main(String[] args) {
        TestCustomLinkedList tcll = new TestCustomLinkedList();
    }

}
class TestCustomLinkedList{
    TestCustomLinkedList(){
        LinkedListCustom list = new LinkedListCustom();
//        System.out.println("Displaying Empty LinkedList : ");
//        list.displayList();
//
//        System.out.println("Displaying LinkedList  After Insert FIrst: ");
//        list.insertFirst(1);
//        list.displayList();
//
//        System.out.println("Displaying LinkedList  After Delete FIrst: ");
//        list.deleteFirst();
//        list.displayList();
//
//        System.out.println("Displaying LinkedList  After Empty: ");
//        list.deleteFirst();
//        list.displayList();
//
//        System.out.println("Displaying LinkedList After insert Last :");
//        list.insertLast(5);
//        list.displayList();
//
//        System.out.println("Displaying LInkedList After Delete Last: ");
//        list.deleteLast();
//        list.displayList();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.displayList();

        System.out.println("Finding element :");
        System.out.println(list.find(5));

        System.out.println("Delete Element : ");
        list.deleteElement(1);
        list.displayList();

        System.out.println("Insert in the middle :");
        list.insertAtIndex(1,7);
        list.displayList();

    }
}