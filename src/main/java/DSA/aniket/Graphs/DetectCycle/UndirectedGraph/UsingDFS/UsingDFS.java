package DSA.aniket.Graphs.DetectCycle.UndirectedGraph.UsingDFS;

import DSA.aniket.Graphs.DetectCycle.DetectCycle;

import java.util.ArrayList;

public class UsingDFS implements DetectCycle {


    public boolean detect(int src, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        if (visited[src] == 1) return true;
        visited[src] = 1;
        for (int neighbour : adj.get(src)) {
            if (neighbour == parent) continue;
            if (detect(neighbour, src, adj, visited)) return true;
        }

        return false;
    }

    @Override
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (detect(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}