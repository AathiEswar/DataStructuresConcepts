package Concepts.LinkedList;

//LinkList class to manipulate the CUstom LinkedLIst
class LinkList{

    //private lenght
    private int length;
    //points the firstNode
    public LinkedNode firstNode;

    public void setLength(int length){
        this.length = length;
    }
    public void updateLenght(){
        this.length++;
    }
    public int getLenth(){
        return this.length;
    }


    //Sets the secondNode just by getting name and updates the lenght
    public void setSecondNode(String name){
        LinkedNode N = new LinkedNode();
        N.name = name;
        firstNode.link = N;
        N.link = null;
        updateLenght();
    }

    public boolean searchdata(String name){
        LinkedNode finder = new LinkedNode();
        finder = firstNode;
        while(finder!=null){
            if(finder.name == name){
                return true;
            }
            else{
                finder = finder.link;
            }
        }
        return false;
    }

    public void deleteLastNode(){

        if(getLenth()==0){
          if(getLenth() == 1){
              firstNode = null;
              setLength(0);
          }
          else{
              LinkedNode preNode = new LinkedNode();
              LinkedNode nextNode = new LinkedNode();
              nextNode = firstNode;
              while(nextNode.link!=null){
                  preNode = nextNode;
                  nextNode = nextNode.link;
              }
              preNode.link = null;
          }
        }
    }

    public void displayNodes(){
        LinkedNode pointer = new LinkedNode();
        pointer = firstNode;
        System.out.print("(");
        while(pointer!=null){
            System.out.print(pointer.name);
            pointer = pointer.link;
            if(pointer!=null){
                System.out.print(",");
            }
        }
        System.out.println(")");
    }
}

class LinkedNode{
    public String name;
    public LinkedNode link;
}


public class LinkedListClass {
    public static void main(String[] args) {
        //declare a new LinkedNode:
        LinkedNode M = new LinkedNode();
        M.name = "Aathi";
        M.link = null;


        //Initializing LinkList First Node:
        LinkList firstPointer = new LinkList();
        firstPointer.updateLenght();
        firstPointer.firstNode = M;
        System.out.println(firstPointer.getLenth());

        firstPointer.setSecondNode("Eswar");

        System.out.println(firstPointer.getLenth());

        System.out.println(firstPointer.searchdata("Eswar"));
        firstPointer.displayNodes();
        firstPointer.deleteLastNode();
        firstPointer.displayNodes();

        //Link a new node:
//        LinkedNode NewNode = new LinkedNode();
//        NewNode.name = "Eswar";
//        NewNode.link = null;
//        M.link = NewNode;
//        firstPointer.setLength(firstPointer.length+1);
//        System.out.println(firstPointer.getLenth());


//        LinkedList<Integer> ll = new LinkedList<>();
//        ll.push(1);
//        ll.push(2);
//        ll.push(3);
//        ll.push(4);
//        ll.push(5);
//        System.out.println(ll);
//        ll.pop();
//        System.out.println(ll);
//        ll.poll();

//        ll.offer(1);
//        ll.offer(2);
//        ll.offer(3);
//        ll.offer(4);
//        ll.offer(5);
//        System.out.println(ll);
//
//        System.out.println(ll.peekFirst());
//        System.out.println(ll.peekLast());
//        System.out.println(ll.pollLast());
//        System.out.println(ll);
//        System.out.println(ll.pollFirst());
//        System.out.println(ll);

    }
}
