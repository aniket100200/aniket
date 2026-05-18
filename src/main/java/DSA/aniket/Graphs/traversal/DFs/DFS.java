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
        return List.of();
    }
}