package Concepts.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfsGraphs(int V , List<List<Integer>> adjList){

        // create the necessary ds for iterations and result
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // add the root manually
        queue.add(0);
        visited[0] = true;

        // iterate till the queue is empty
        while(!queue.isEmpty()){

            // get the element from the queue
            Integer node = queue.poll();
            System.out.println(node);
            // add the node in the resutl
            result.add(node);

            // iterate throught the adj nodes of that vertex
            for(Integer adjNode : adjList.get(node)){
                // only add to the queue if not visited or else cycles can cause trouble
                if(!visited[adjNode]){
                    // add the node to the queue and change unvisited to visited
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
       // return the result
        return result;

    }
}
