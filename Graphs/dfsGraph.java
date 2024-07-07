package Concepts.Graphs;

import java.util.ArrayList;

public class dfsGraph {
    public void dfsGraph(boolean[] visited , ArrayList<ArrayList<Integer>> adjList , int node , ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        for(Integer adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                dfsGraph(visited , adjList , adjNode , result);
            }
        }

    }
}
