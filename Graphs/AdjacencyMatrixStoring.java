package Concepts.Graphs;

public class AdjacencyMatrixStoring {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {2,3},
                {3,4}
        };
        adjacencyMatrix(4 , 3 , edges);
    }
    public static void adjacencyMatrix(int n , int m , int[][] edges){
        // n  = no of nodes
        // m = no of edges

        int[][] adjMatrix = new int[n][n];

        for(int i = 0;i<edges.length;i++){
                adjMatrix[edges[i][0]-1][edges[i][1]-1] = 1;
                adjMatrix[edges[i][1]-1][edges[i][0]-1] = 1;
        }

        displayAdjMatrix(adjMatrix);
    }

    private static void displayAdjMatrix(int[][] adjMatrix) {
        System.out.print("  ");
        for (int k = 0; k < adjMatrix.length; k++) {
            System.out.print((char)('A' + k));
        }
        System.out.println();

        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print((char)('A'+i)+" ");
            for (int j = 0; j < adjMatrix[0].length; j++) {
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();

        }
    }
}
