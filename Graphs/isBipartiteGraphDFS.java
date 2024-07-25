package Concepts.Graphs;

public class isBipartiteGraphDFS {
    public boolean isBipartite(int[][] graph) {
        int nodeNumber = graph.length ;
        int[] color = new int[nodeNumber];

        // populate
        for(int i=0; i<nodeNumber ; i++){
            color[i] = -1;
        }

        // find the uncolored node and BFS through them
        for(int i = 0 ; i<nodeNumber ; i++){
            if(color[i] == -1 && dfs(color , i , graph , 0) == false ){
                return false;
            }
        }
        return true ;
    }

    public boolean dfs(int[] color , int start , int[][] graph , int curColor ){

        // color the cur node
        color[start] = curColor;

        // iterate through their adjnodes
        for(int adjNode : graph[start]){
            // when its no color , color it and send to DFS and check true or false
            if(color[adjNode] == -1){
                if(!dfs(color , adjNode , graph , 1-curColor)){
                    return false;
                }
            }

            // if its same as parent color return false
            else if(color[adjNode] == color[start]){
                return false;
            }
        }

        return true ;
    }
}
