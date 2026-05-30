package DSA.aniket.Graphs.Algorithms.BellmanFord.Solution;

import DSA.aniket.Graphs.Algorithms.BellmanFord.BellmanFord;

import java.util.Arrays;

public class Solution implements BellmanFord {

    /**
     * @param V
     * @param edges
     * @param src
     * @return
     */
    @Override
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        /**
         * you'll be getting your answer in V-1 iterations/ Relaxations
         */

        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        /*Nth Relaxation*/
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = 100000000;
        }
        return dist;
    }
}