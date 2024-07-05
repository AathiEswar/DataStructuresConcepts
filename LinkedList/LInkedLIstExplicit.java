package Concepts.LinkedList;

class NodeList{
    String data;
    NodeList link;
}

class LinkedListNodes{
    NodeList firstNode ;
    int lenght;

    public void incrementLenght(){
        this.lenght++;
    }
    public void decrementLenght(){
        this.lenght--;
    }
    public int  getlength(){
        return lenght;
    }
    public void displayElements(){
        NodeList pointer =firstNode;
        System.out.print("( ");
        while(pointer!=null){
            System.out.print(pointer.data);
            pointer = pointer.link;
            if(pointer!=null){
                System.out.print(",");
            }

        }
        System.out.println(" )");
    }
    public void  setSecondNode(String Newdata){
        if(getlength()!=0){
        NodeList N = new NodeList();
        N.data = Newdata;
        N.link = null;
        firstNode.link = N;
            incrementLenght();
    }
}
    public boolean searchelement(String data){
        if(getlength()==0)return false;
        if(firstNode.data==data) return true;
        NodeList point = firstNode;
        while(point!= null){
            if(point.data == data){

                return true;
            }
            else {
                point = point.link;
            }
        }
            return false;
    }
    public void deleteLastNode(){

        if(getlength()!=0){
            if(getlength() ==1){
                decrementLenght();
                firstNode = null;
            }
            else {
                NodeList curPoint = firstNode;
                NodeList prePoint = new NodeList();
                while(curPoint.link!=null){
                    prePoint = curPoint;
                    curPoint = curPoint.link;
                }
                prePoint.link = null;
                decrementLenght();
            }
        }
    }

    public void insertNewNodeAtEnd(String data){
        NodeList NewNode = new NodeList();
        NewNode.data = data;
        NewNode.link = null;
        if(getlength()==0){
            firstNode = NewNode;
        }
        else{

            NodeList point = firstNode;
            while (point.link!=null){
                point = point.link;
            }
            point.link = NewNode;

        }
        incrementLenght();
    }
}

public class LInkedLIstExplicit {
    public static void main(String[] args) {
        //create a new linkedlist
        NodeList list = new NodeList();

        //create a pointer to manipulate the linkedlist
        LinkedListNodes pointer = new LinkedListNodes();

        //initialise the linked list head
        list.data = "Aathi";
        list.link = null;

        //instance the first node to the pointer
        pointer.firstNode = list;
        pointer.incrementLenght();

        //listlenght method
        System.out.println();
        System.out.println(pointer.getlength());
        pointer.displayElements();
        System.out.println();

        //insert Second node:
        System.out.print("Second node:");
        pointer.setSecondNode("Eswar");
        pointer.displayElements();
        System.out.println("lenght:" + pointer.getlength());
        System.out.println();


        //searching element:;
        System.out.println("Finding Element:"+pointer.searchelement("Eswar"));

        //deleting last Node:
        System.out.print("Deleting LastNode:");
        pointer.deleteLastNode();
        pointer.displayElements();
        System.out.println("Lenght:"+pointer.getlength());
        System.out.println();

        //Insert at the end:
        System.out.println("Insert Element at the end");
        pointer.insertNewNodeAtEnd("Hello");
        pointer.displayElements();
        System.out.println("Lenght:"+pointer.getlength());
        System.out.println();

    }
}
