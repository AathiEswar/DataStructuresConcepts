package Concepts.Graphs;

import java.util.ArrayList;
import java.util.*;
public class dfsGraphClass {
    public static void dfsGraph(boolean[] visited , List<List<Integer>> adjList , int node , ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        System.out.println(node);
        for(Integer adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                dfsGraph(visited , adjList , adjNode , result);

            }
        }

    }
}
