package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.Solution;

import DSA.aniket.Graphs.Pair;
import DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.ShortestPath;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution implements ShortestPath {

    @Override
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<Integer>[] adj = this.getGraph(V, edges, true);
        Queue<Pair> que = new ArrayDeque<>();
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        /**
         * as src - src distance is 0
         */

        que.add(new Pair(src, 0));
        dist[src] = 0;
        while (que.size() > 0) {
            Pair p1 = que.poll();
            int node = p1.getA();
            int wt = p1.getB() + 1;
            for (int neighbour : adj[node]) {
                if (wt < dist[neighbour]) {
                    dist[neighbour] = wt;
                    que.add(new Pair(neighbour, wt));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}