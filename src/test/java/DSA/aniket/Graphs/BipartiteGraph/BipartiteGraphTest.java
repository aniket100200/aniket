package DSA.aniket.Graphs.BipartiteGraph;

import DSA.aniket.Graphs.BipartiteGraph.UsingDFS.UsingDFS;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BipartiteGraphTest {

    private final BipartiteGraph solution = new UsingDFS();

    // Helper method to build an adjacency list cleanly for testing
    private ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }
        return adj;
    }

    // --- Tests ---

    @Test
    public void testExample1_EvenCycle_IsBipartite() {
        int V = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 0}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (It's a square/even cycle)
        assertTrue(solution.isBipartite(V, adj), "Failed on Example 1: Even length cycle should be bipartite.");
    }

    @Test
    public void testExample2_OddCycle_NotBipartite() {
        int V = 3;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false (It's a triangle/odd cycle)
        assertFalse(solution.isBipartite(V, adj), "Failed on Example 2: Odd length cycle cannot be bipartite.");
    }

    @Test
    public void testLinearGraph_IsBipartite() {
        int V = 5;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (All linear graphs / trees are bipartite)
        assertTrue(solution.isBipartite(V, adj), "Failed on linear graph: Trees are always bipartite.");
    }

    @Test
    public void testDisconnectedGraph_BothComponentsBipartite() {
        int V = 6;
        // Component 1 (0-1-2), Component 2 (3-4-5) - No odd cycles
        int[][] edges = {
                {0, 1}, {1, 2},
                {3, 4}, {4, 5}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true
        assertTrue(solution.isBipartite(V, adj), "Failed on a disconnected graph with only bipartite components.");
    }

    @Test
    public void testDisconnectedGraph_OneComponentNotBipartite() {
        int V = 6;
        // Component 1 (0-1-2) is bipartite. Component 2 (3-4, 4-5, 5-3) has an odd cycle.
        int[][] edges = {
                {0, 1}, {1, 2},
                {3, 4}, {4, 5}, {5, 3}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false (The whole graph fails if any component fails)
        assertFalse(solution.isBipartite(V, adj), "Failed on a disconnected graph containing a non-bipartite component.");
    }

    @Test
    public void testSingleNode() {
        int V = 1;
        int[][] edges = {};
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true
        assertTrue(solution.isBipartite(V, adj), "Failed on a single node graph (trivially bipartite).");
    }
}