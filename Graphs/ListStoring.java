package Concepts.Graphs;
import java.util.*;

import static Concepts.Graphs.BFS.bfsGraphs;
import static Concepts.Graphs.dfsGraphClass.dfsGraph;

public class ListStoring {
    public static void main(String[] args) {
        int[][] edges = {
                {0,2},
                {1,3},
                {3,2}
        };
        List<List<Integer>> res = listStoring(4,edges);
        boolean[] visited = new boolean[4];
        System.out.println(res);
         dfsGraph(visited ,res, 0 , new ArrayList<>() );
         bfsGraphs(4 , res);
    }
    public static List<List<Integer>> listStoring(int n , int[][] edges){
        // list of list for storing the neighbour nodes
        List<List<Integer>> adjList = new ArrayList<>();

        // populate the list of list with empty list
        for(int i = 0; i<n;i++){
            adjList.add(new ArrayList<>());
        }

        // add the edges to the list

        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v) ;
            adjList.get(v).add(u) ;
        }

        return adjList;
    }
}
