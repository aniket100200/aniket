package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance.UsingDijkstrasAlgorithm;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UsingDijkstrasAlgorithm implements FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    /**
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    @Override
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /**
         * let's create Graph
         */
        List<List<List<Integer>>> adj = createGraph(n, edges);
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int src = 0; src < n; src++) {
            applyDijkstras(n, adj, dist, src);
        }

        int leastNumberOfNeighbourCitiesWithThreasoldX = n;
        int cityNo = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) count++;
            }
            if (count <= leastNumberOfNeighbourCitiesWithThreasoldX) {
                leastNumberOfNeighbourCitiesWithThreasoldX = count;
                cityNo = i;
            }
        }
        return cityNo;
    }

    public void applyDijkstras(int V, List<List<List<Integer>>> adj, int[][] dist, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        /**
         * will be using readymade distance Array
         */
//        dist[src][0->n]
        pq.add(new int[]{0, src});
        while (pq.size() > 0) {
            int[] rPair = pq.poll();
            int currDist = rPair[0];
            int node = rPair[1];
            for (List<Integer> neighbour : adj.get(node)) {
                int neighbourNode = neighbour.get(0);
                int edgeWt = neighbour.get(1);
                if (currDist + edgeWt < dist[src][neighbourNode]) {
                    dist[src][neighbourNode] = currDist + edgeWt;
                    pq.add(new int[]{currDist + edgeWt, neighbourNode});
                }
            }
        }
    }


    public List<List<List<Integer>>> createGraph(int V, int[][] edges) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(List.of(v, wt));
            adj.get(v).add(List.of(u, wt));
        }

        return adj;
    }
}