package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.Solution;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FloydWarshall;

public class Solution implements FloydWarshall {

    /**
     * @param matrix
     */
    @Override
    public void shortestDistance(int[][] matrix) {

        int V = matrix.length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }

                if (i == j) {
                    /**
                     * which is Digonal
                     */
                    matrix[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    /**
                     * if not reachable
                     */
                    matrix[i][j] = -1;
                }
            }
        }

    }
}