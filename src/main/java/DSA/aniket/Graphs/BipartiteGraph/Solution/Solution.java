package DSA.aniket.Graphs.BipartiteGraph.Solution;

import DSA.aniket.Graphs.BipartiteGraph.BipartiteGraph;
import DSA.aniket.Graphs.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution implements BipartiteGraph {

    public boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src, 1));/* try to color with 1*/
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair p1 = que.poll();
                int node = p1.getA();
                int currColor = p1.getB();
                if (color[node] == 0) {
                    color[node] = currColor;
                } else {
                    /**
                     * check if it is colored with the same color as we expecting
                     */
                    if (color[node] != currColor) return false;
                    continue;
                }

                for (int neighbour : adj.get(node)) {
                    int newColor = currColor == 1 ? 2 : 1;
                    que.add(new Pair(neighbour, newColor));
                }
            }
        }
        return true;
    }

    @Override
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        /**
         * will be using two colors 1&2
         */
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                boolean isBipartie = bfs(i, adj, color);
                if (!isBipartie) return false;
            }
        }
        return true;
    }


    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                boolean isBipartite = bfs(i, graph, color);
                if (!isBipartite) return false;
            }
        }
        return true;
    }


    public boolean bfs(int src, int[][] adj, int[] color) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src, 1));/* try to color with 1*/
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair p1 = que.poll();
                int node = p1.getA();
                int currColor = p1.getB();
                if (color[node] == 0) {
                    color[node] = currColor;
                } else {
                    /**
                     * check if it is colored with the same color as we expecting
                     */
                    if (color[node] != currColor) return false;
                    continue;
                }

                for (int neighbour : adj[node]) {
                    int newColor = currColor == 1 ? 2 : 1;
                    que.add(new Pair(neighbour, newColor));
                }
            }
        }
        return true;
    }
}