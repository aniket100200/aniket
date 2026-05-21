package DSA.aniket.Graphs.Directed.TopologicalSort.KahansAlgorithm;

import DSA.aniket.Graphs.Directed.TopologicalSort.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class KahansAlgorithm implements TopologicalSort {

    @Override
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        /**
         * calculate the Indegree of Each Element
         */
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) {
                indegree[ele]++;
            }
        }

        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) que.add(i);
        }
        int[] ans = new int[V];
        //as this is DAG so there will be no Cycle
        int index = 0;
        while (que.size() > 0) {
            int node = que.remove();
            ans[index++] = node;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) que.add(neighbour);
            }
        }

        return ans;
    }
}