package DSA.aniket.Graphs.DetectCycle.UndirectedGraph.UsingBFS;

import DSA.aniket.Graphs.DetectCycle.DetectCycle;
import DSA.aniket.Graphs.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UsingBFS implements DetectCycle {

    public boolean detect(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src] = 1;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(src, -1));

        while (que.size() > 0) {
            int node = que.peek().getA();
            int parent = que.peek().getB();

            que.poll();

            /**
             * let's go for it's neighbours
             */
            for (int neighbour : adj.get(node)) {
                if (neighbour == parent) continue;
                if (visited[neighbour] == 1) return true;
                visited[neighbour] = 1;
                que.add(new Pair(neighbour, node));
            }

        }

        return false;
    }

    @Override
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {

            if (visited[i] == 0) {
                if (detect(i, adj, visited)) return true;
            }
        }
        return false;
    }
}