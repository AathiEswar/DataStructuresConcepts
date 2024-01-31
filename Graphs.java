package Concepts;

import java.util.ArrayList;

class Node{
    char data;
    Node(char data){
        this.data = data;
    }
}

class Graph{
    ArrayList<Node> nodes ;
    int[][] mat ;
    Graph(int size){
        nodes = new ArrayList<>();
        mat = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }
    public void addEdge(int scr , int dest){
        mat[scr][dest] =1;
    }

    public boolean checkEdge(int src,int dest){
        if(mat[src][dest] == 1){
            return true;
        }
        return false;
    }
    
    public void printNode(){
        System.out.print("  ");
        for(Node nod : nodes){
            System.out.print(nod.data);
        }
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            System.out.print(nodes.get(i).data+" ");
            for (int j = 0; j < mat.length ; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

}
public class Graphs {
    public static void main(String[] args){
        Graph g = new Graph(3);

        g.addNode(new Node('A'));
        g.addNode(new Node('B'));
        g.addNode(new Node('C'));

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);

        g.printNode();

        System.out.println(g.checkEdge(0,1));


    }
}
