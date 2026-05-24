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
}
