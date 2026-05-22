package DSA.aniket.Graphs.DetectCycle.DirectedGraph.UsingBFS;

import DSA.aniket.Graphs.DetectCycle.DetectCycle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class UsingBFS implements DetectCycle {

    @Override
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        /**
         * let's try to implement
         * topological sorting on this Adjacency element
         */

        int count = 0;
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) indegree[ele]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) que.add(i);
        }

        while (que.size() > 0) {
            int node = que.remove();
            count++;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) que.add(neighbour);
            }
        }
        return count != V;
    }
}