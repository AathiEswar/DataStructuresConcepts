package Concepts.Graphs;
import java.util.*;
public class IsBipartiteGraphBFS {
    public boolean isBipartite(int[][] graph) {
        int nodeNumber = graph.length ;
        int[] color = new int[nodeNumber];

        // populate
        for(int i=0; i<nodeNumber ; i++){
            color[i] = -1;
        }

        // find the uncolored node and BFS through them
        for(int i = 0 ; i<nodeNumber ; i++){
            if(color[i] == -1 && bfs(color , i , graph) == false ){
                return false;
            }
        }
        return true ;
    }

    public boolean bfs(int[] color , int start , int[][] graph ){

        Queue<Integer> queue =new LinkedList<>();
        color[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int adjNode : graph[node]){
                if(color[adjNode] == -1){
                    queue.offer(adjNode);
                    color[adjNode] = 1 - color[node];
                }
                else if(color[node] == color[adjNode]){
                    return false;
                }
            }
        }
        return true;
    }
}
