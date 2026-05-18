package DSA.aniket.Graphs.NumberOfProvinces.Solution;

import DSA.aniket.Graphs.NumberOfProvinces.NumberOfProvinces;

public class Solution implements NumberOfProvinces {

    @Override
    public int findCircleNum(int[][] graph) {
        int count = 0;
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    void dfs(int node, int[][] graph, int[] visited) {
        if (visited[node] == 1) return;
        visited[node] = 1;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) dfs(i, graph, visited);
        }
    }
}