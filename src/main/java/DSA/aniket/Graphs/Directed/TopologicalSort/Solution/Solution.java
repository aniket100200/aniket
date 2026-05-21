package DSA.aniket.Graphs.Directed.TopologicalSort.Solution;

import DSA.aniket.Graphs.Directed.TopologicalSort.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class Solution implements TopologicalSort {

    @Override
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) dfs(i, adj, visited, st);
        }
        int[] ans = new int[st.size()];
        int index = 0;
        while (!st.isEmpty()) ans[index++] = st.pop();

        return ans;
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> st) {
        //mark it as visited
        visited[src] = 1;
        for (int neighbour : adj.get(src)) {
            if (visited[neighbour] == 0)
                dfs(neighbour, adj, visited, st);
        }
        st.push(src);
    }
}