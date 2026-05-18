package DSA.aniket.Graphs.traversal.DFs;

import DSA.aniket.Graphs.traversal.Traversal;

import java.util.ArrayList;
import java.util.List;

public class DFS implements Traversal {

    @Override
    public List<Integer> traversal(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        dfs(adj, visited, ans, 0);
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, List<Integer> ans, int node) {
        if (visited[node] == 1) return;
        ans.add(node);
        visited[node]++;
        ArrayList<Integer> neighbours = graph.get(node);
        for (int neighbour : neighbours) {
            dfs(graph, visited, ans, neighbour);
        }
    }

    @Override
    public List<Integer> traversal(int V, int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs2(0, adj, ans, visited);
        return ans;
    }

    public void dfs2(int node, int[][] adj, List<Integer> ans, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        ans.add(node);
        for (int i = 0; i < adj[node].length; i++) {
            if (adj[node][i] == 1) {
                dfs2(i, adj, ans, visited);
            }
        }
    }


}