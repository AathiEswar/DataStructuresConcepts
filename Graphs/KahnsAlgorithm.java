package Concepts.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class KahnsAlgorithm {
    public int[] kahnsAlgorithm(ArrayList<ArrayList<Integer>> adjList , int V){

        int[] indegree = new int[V];

        for(int i = 0 ; i < V ; i++){
            for(int adjNode : adjList.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue =  new LinkedList<>();
        for(int i = 0 ; i<V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int i = 0 ;
        int[] topo = new int[V];

        while(!queue.isEmpty()){
            int node = queue.poll();

            topo[i] = node;
            i++;

            for(int adjNode : adjList.get(node)){
                indegree[adjNode]--;

                if(indegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }

        return topo;
    }
}
