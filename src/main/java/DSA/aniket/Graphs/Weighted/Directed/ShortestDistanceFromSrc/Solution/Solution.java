package DSA.aniket.Graphs.Weighted.Directed.ShortestDistanceFromSrc.Solution;


import DSA.aniket.Graphs.Weighted.Directed.ShortestDistanceFromSrc.ShortestDistanceFromSrc;
import DSA.aniket.Graphs.Weighted.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution implements ShortestDistanceFromSrc {

    public void topoSort(int node, List<Pair>[] adj, int[] visited, Stack<Integer> st) {
        visited[node] = 1;
        for (Pair neighbour : adj[node]) {
            int v = neighbour.node;
            if (visited[v] == 0) topoSort(v, adj, visited, st);
        }
        st.push(node);
    }

    @Override
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<Pair>[] adj = new List[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj[u].add(new Pair(v, wt));
        }
        /**
         * find the topo Sort
         */
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        /**
         * it is guaranteed that there will be no cycle
         */
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, st);
            }
        }

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int) (1e9);
        /**
         * as source is not given
         */
        int src = 0;
        dist[src] = 0;

        while (st.size() > 0) {
            int node = st.pop();
            for (Pair neighbour : adj[node]) {
                int v = neighbour.node;
                int wt = neighbour.weight;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        return dist;
    }


}