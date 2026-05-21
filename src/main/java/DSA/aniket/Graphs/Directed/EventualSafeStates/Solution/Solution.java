package DSA.aniket.Graphs.Directed.EventualSafeStates.Solution;

import DSA.aniket.Graphs.Directed.EventualSafeStates.EventualSafeStates;

import java.util.ArrayList;
import java.util.List;

public class Solution implements EventualSafeStates {

    boolean isCyclic(int src, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[src] = 1;
        pathVisited[src] = 1;
        for (int neighbour : adj.get(src)) {
            if (pathVisited[neighbour] != 0) {
                visited[src] = 2;
                return true;
            }
            if (visited[neighbour] != 0) continue;

            boolean isCycle = isCyclic(neighbour, adj, visited, pathVisited);

            if (isCycle) {
                visited[src] = 2;
                return true;
            }

        }

        pathVisited[src] = 0;
        visited[src] = 3;
        return false;
    }

    @Override
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                boolean isCycle = isCyclic(i, adj, visited, pathVisited);
            }
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == 3) ans.add(i);
        }

        return ans;
    }


    List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                boolean isCycle = isCyclic(i, graph, visited, pathVisited);
            }
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == 3) ans.add(i);
        }

        return ans;
    }

    boolean isCyclic(int src, int[][] adj, int[] visited, int[] pathVisited) {
        visited[src] = 1;
        pathVisited[src] = 1;
        for (int neighbour : adj[src]) {
            if (pathVisited[neighbour] != 0) {
                visited[src] = 2;
                return true;
            }
            if (visited[neighbour] != 0) continue;

            boolean isCycle = isCyclic(neighbour, adj, visited, pathVisited);

            if (isCycle) {
                visited[src] = 2;
                return true;
            }

        }

        pathVisited[src] = 0;
        visited[src] = 3;
        return false;
    }
}