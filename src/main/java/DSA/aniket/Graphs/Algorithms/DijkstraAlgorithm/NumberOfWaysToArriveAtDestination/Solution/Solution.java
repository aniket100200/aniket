package DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.NumberOfWaysToArriveAtDestination.Solution;

import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.NumberOfWaysToArriveAtDestination.NumberOfWaysToArriveAtDestination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution implements NumberOfWaysToArriveAtDestination {

    /**
     * @param n
     * @param roads
     * @return
     */
    @Override
    public int countPaths(int n, int[][] roads) {
        /**
         * let's create graph first
         */
        List<List<List<Integer>>> adj = createGraph(n, roads);
        int src = 0, dest = n - 1;
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        ways[src] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        pq.add(new int[]{0, src});

        while (pq.size() > 0) {
            int[] rPair = pq.poll();
            int currDist = rPair[0];
            int node = rPair[1];

            for (List<Integer> neighbourData : adj.get(node)) {
                int neighbour = neighbourData.get(0);
                int edgeWt = neighbourData.get(1);
                if (currDist + edgeWt < dist[neighbour]) {
                    dist[neighbour] = currDist + edgeWt;
                    ways[neighbour] = ways[node];
                    pq.add(new int[]{currDist + edgeWt, neighbour});
                } else if (currDist + edgeWt == dist[neighbour]) {
                    ways[neighbour] += ways[node];
                }
            }

        }


        return ways[dest];
    }

    List<List<List<Integer>>> createGraph(int V, int[][] roads) {
        /**
         * this is undirected Graph
         */
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.get(u).add(List.of(v, wt));
            adj.get(v).add(List.of(u, wt));
        }

        return adj;
    }


}