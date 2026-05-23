package DSA.aniket.Graphs.Directed.EventualSafeStates.UsingKahansAlgo;

import DSA.aniket.Graphs.Directed.EventualSafeStates.EventualSafeStates;

import java.util.*;

public class UsingKahansAlgo implements EventualSafeStates {

    @Override
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        /**
         *  reverse the graph
         *  you have to apply kahan's algorithm in reverse order of graph
         *  means on the outgoing edges
         *  if(outgoing_nodes==0)"Terminal Node"
         */
        List<List<Integer>> adjRev = reverse(adj);
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int ele : adjRev.get(i)) {
                indegree[ele]++;
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (que.size() > 0) {
            int node = que.remove();
            ans.add(node);
            for (int neighbour : adjRev.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) que.add(neighbour);
            }
        }


        Collections.sort(ans);

        return ans;
    }

    public List<List<Integer>> reverse(List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.size(); i++) {
            for (int neighbour : adj.get(i)) {
                adjRev.get(neighbour).add(i);
            }
        }

        return adjRev;
    }
}