package Concepts.Graphs;

import java.util.Arrays;

public class FloydsWarshellAlgo {
    // to find the shortest path between every pair of node

    // find the weighted graph for adjnodes A->A is 0
    // loop mid , source , dest
    // if g[s][m] < inf && g[m][d] < inf
    // g[s][d] must be min of ( g[s][d] , g[s][m]+g[m][d] )

    public int findTheCity(int n, int[][] edges, int k) {

        int[][] graph  = new int[n][n];

        for(int i = 0 ; i<n ;i++){
            Arrays.fill( graph[i] , Integer.MAX_VALUE) ;
            graph[i][i] = 0;
        }

        for(int[] edge : edges){
            int source = edge[0];
            int dest   = edge[1];
            int cost   = edge[2];

            graph[source][dest] = cost;
            graph[dest][source] = cost;
        }

        for(int mid = 0 ; mid < n ; mid++){
            for(int source = 0 ; source < n ; source++){
                for(int dest = 0 ; dest < n  ; dest++ ){
                    if(graph[source][mid] < Integer.MAX_VALUE && graph[mid][dest] < Integer.MAX_VALUE){
                        graph[source][dest] =
                                Math.min(graph[source][dest] , graph[source][mid] + graph[mid][dest] );
                    }
                }
            }
        }

        int city = 0 ;
        int min = n;

        for(int source = 0 ; source < n ; source++){
            int count = 0;

            for(int dest = 0 ; dest < n ; dest++){
                if(graph[source][dest] <= k){
                    count++;
                }
            }

            if(count<=min){
                city = source;
                min = count;
            }
        }

        return city ;
    }
}
