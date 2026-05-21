package DSA.aniket.Graphs.DetectCycle.DirectedGraph.UsingDFS;

import DSA.aniket.Graphs.DetectCycle.DetectCycle;

import java.util.ArrayList;

public class UsingDFS implements DetectCycle {

    @Override
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                boolean isCycle = dfs(i, adj, visited);
                visited[i] = 0;
                if (isCycle) return true;
            }
        }
        return false;
    }

    public boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        for (int neighbours : adj.get(src)) {
            if (visited[neighbours] == 1) return true;
            visited[neighbours] = 1;
            boolean isCycle = dfs(neighbours, adj, visited);
            if (isCycle) return true;
            visited[neighbours] = 0;
        }
        return false;
    }
}