package DSA.aniket.Graphs.Bridges.ArticulationPoint.Solution;

import DSA.aniket.Graphs.Bridges.ArticulationPoint.ArticulationPoint;

import java.util.ArrayList;

public class Solution implements ArticulationPoint {

    int timer = 1;

    private void dfs(int node, int parent, int[] visited, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (visited[it] == 0) {
                dfs(it, node, visited, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }

                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    /**
     * @param V
     * @param adj
     * @return
     */
    @Override
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, visited, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] != 0) ans.add(i);
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
}