package DSA.aniket.Graphs.BipartiteGraph.UsingDFS;

import DSA.aniket.Graphs.BipartiteGraph.BipartiteGraph;

import java.util.ArrayList;

public class UsingDFS implements BipartiteGraph {

    @Override
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        /**
         * will be coloring two adjacent node by 1/2
         */
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (!dfs(i, adj, color, 1)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] color, int currColor) {
        if (color[src] != 0) {
            if (color[src] != currColor) return false;
            return true;
        }

        color[src] = currColor;
        for (int neighbour : adj.get(src)) {
            int newColor = currColor == 1 ? 2 : 1;
            boolean isBipartite = dfs(neighbour, adj, color, newColor);
            if (!isBipartite) return false;
        }

        return true;
    }
}