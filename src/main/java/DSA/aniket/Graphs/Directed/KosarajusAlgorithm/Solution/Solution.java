package DSA.aniket.Graphs.Directed.KosarajusAlgorithm.Solution;

import DSA.aniket.Graphs.Directed.KosarajusAlgorithm.KosarajusAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class Solution implements KosarajusAlgorithm {

    /**
     * @param V
     * @param adj
     * @return
     */
    @Override
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        /**
         * Step 1: Sort all the Edges According to the Finishing Time
         */
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, st);
            }
        }


        /**
         * step 2: Transpose the Graph
         */

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) adjT.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            visited[i] = 0;
            for (int neighbour : adj.get(i)) {
                adjT.get(neighbour).add(i);
            }
        }

        /**
         * step 3: Perform DFS
         */
        int scc = 0;
        while (st.size() > 0) {
            int node = st.pop();
            if (visited[node] == 0) {
                scc++;
                dfs(node, visited, adjT, new Stack<>());
            }
        }

        return scc;
    }

    private void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node] = 1;
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, visited, adj, st);
            }
        }
        st.push(node);
    }
}