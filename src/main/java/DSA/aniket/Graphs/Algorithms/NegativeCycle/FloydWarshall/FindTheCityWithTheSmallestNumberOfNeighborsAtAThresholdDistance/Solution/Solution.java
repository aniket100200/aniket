package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance.Solution;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

public class Solution implements FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    /**
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /**
         * let's calculate the distance from each node other node using
         * Floyd Warshall Algorithm
         */
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        /**
         * let's plot the values on distance array
         */
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        /**
         * let's apply floyd's Algorithm
         */
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int minimumNeighbourCities = n;
        int cityNo = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                ;
                if (dist[i][j] <= distanceThreshold) count++;
            }
            if (count <= minimumNeighbourCities) {
                minimumNeighbourCities = count;
                cityNo = i;
            }
        }

        return cityNo;
    }


}