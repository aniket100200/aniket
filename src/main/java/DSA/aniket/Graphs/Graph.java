package DSA.aniket.Graphs;

import java.util.ArrayList;
import java.util.List;

public interface Graph {

    default List<Integer>[] getGraph(int V, int[][] edges, boolean isUndirected) {
        List<Integer>[] adj = new List[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            if (isUndirected) {
                adj[edge[1]].add(edge[0]);
            }
        }
        return adj;
    }


    default List<List<List<Integer>>> getWeightedGraph(int V, int[][] edges) {
        return getWeightedGraph(V, edges, true);
    }


    default List<List<List<Integer>>> getWeightedGraph(int V, int[][] edges, boolean isUndirected) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(List.of(v, wt));
            if (isUndirected) adj.get(v).add(List.of(u, wt));

        }

        return adj;
    }
}
