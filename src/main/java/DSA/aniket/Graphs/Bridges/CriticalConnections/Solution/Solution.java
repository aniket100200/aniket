package DSA.aniket.Graphs.Bridges.CriticalConnections.Solution;

import DSA.aniket.Graphs.Bridges.CriticalConnections.CriticalConnections;

import java.util.ArrayList;
import java.util.List;

public class Solution implements CriticalConnections {

    int timer = 1;

    /**
     * @param n
     * @param connections
     * @return
     */
    @Override
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] timeOfInsertion = new int[n + 1];
        int[] lowestTime = new int[n + 1];
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[n + 1];
        dfs(0, -1, visited, adj, timeOfInsertion, lowestTime, ans);
        return ans;
    }

    public void dfs(int node, int parent, int[] visited, List<List<Integer>> adj, int[] timeOfInsertion, int[] lowestTime, List<List<Integer>> ans) {
        visited[node] = 1;
        timeOfInsertion[node] = lowestTime[node] = timer;
        timer++;
        for (int neighbour : adj.get(node)) {
            if (neighbour == parent) continue;
            if (visited[neighbour] == 0) {
                dfs(neighbour, node, visited, adj, timeOfInsertion, lowestTime, ans);
                lowestTime[node] = Math.min(lowestTime[neighbour], lowestTime[node]);
                if (timeOfInsertion[node] < lowestTime[neighbour]) {
                    ans.add(List.of(neighbour, node));
                }

            } else {
                lowestTime[node] = Math.min(lowestTime[neighbour], lowestTime[node]);
            }
        }
    }
}