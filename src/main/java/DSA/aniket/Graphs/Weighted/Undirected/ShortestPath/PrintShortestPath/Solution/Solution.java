package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.PrintShortestPath.Solution;

import DSA.aniket.Graphs.Pair;
import DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.PrintShortestPath.PrintShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution implements PrintShortestPath {

    /**
     * @param n
     * @param m
     * @param edges
     * @return
     */
    @Override
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        /*
         * As it is 1 based indexing
         */
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(List.of(v, wt));
            graph.get(v).add(List.of(u, wt));
        }
        /**
         * I've created the graph
         */

        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }

        /**
         * this is the Dijsktra's Algorithm
         */

        PriorityQueue<Pair> que = new PriorityQueue<>((x, y) -> {
            if (x.getA() == y.getB()) return x.getB() - y.getB();
            return x.getA() - y.getA();
        });
        int src = 1;
        dist[src] = 0;
        que.add(new Pair(0, src));
        while (que.size() > 0) {
            Pair rPair = que.poll();
            int node = rPair.getB();
            int currDist = rPair.getA();
            for (List<Integer> neighbourData : graph.get(node)) {
                int neighbour = neighbourData.get(0);
                int edgeWt = neighbourData.get(1);
                if (currDist + edgeWt < dist[neighbour]) {
                    dist[neighbour] = currDist + edgeWt;
                    que.add(new Pair(currDist + edgeWt, neighbour));
                    parent[neighbour] = node;
                }
            }
        }

        int dest = n;
        List<Integer> ans = new ArrayList<>();
        if (parent[dest] == dest && n != 1) {
            ans.add(-1);
            return ans;
        }

        Stack<Integer> st = new Stack<>();
        while (dest != parent[dest]) {
            st.push(dest);
            dest = parent[dest];
        }
        st.push(dest);
        while (st.size() > 0) ans.add(st.pop());

        return ans;
    }

    /**
     * @param V
     * @param edges
     * @param src
     * @return
     */
    @Override
    public int[] shortestPath(int V, int[][] edges, int src) {
        return new int[0];
    }
}