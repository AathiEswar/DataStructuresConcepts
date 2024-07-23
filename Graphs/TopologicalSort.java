package Concepts.Graphs;
import java.util.*;
public class TopologicalSort {
    public static void dfs(Stack<Integer> stack , ArrayList<ArrayList<Integer>> adj ,
                           int[] visited , int node){

            visited[node] = 1;

            for(Integer adjNode : adj.get(node)){
                if(visited[adjNode] != 1){
                    dfs(stack , adj , visited , adjNode);
                }
            }
            stack.push(node);
    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i< V ; i++){
            if(visited[i] != 1){
                dfs(stack , adj , visited , i);
            }
        }


        int[] res = new int[V];
        int index = 0;
        while(!stack.isEmpty()){
            res[index++] = stack.pop();
        }

        return res;
    }
}
