package DSA.aniket.Graphs.Directed.TopologicalSort;

import DSA.aniket.Graphs.Directed.TopologicalSort.KahansAlgorithm.KahansAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopologicalSortTest {

    private final TopologicalSort solution = new KahansAlgorithm();

    // Helper method to build an adjacency list cleanly for testing
    private ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // Directed edge
        }
        return adj;
    }

    // --- Validation Helper ---

    // Validates if the returned array is a valid topological sort
    private boolean isValidTopoSort(int V, ArrayList<ArrayList<Integer>> adj, int[] topoOrder) {
        if (topoOrder.length != V) return false;

        // Store the index of each vertex in the topological order
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < V; i++) {
            positionMap.put(topoOrder[i], i);
        }

        // For every directed edge u -> v, u must appear before v
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                // If the position of 'u' is greater than 'v', it's invalid!
                if (positionMap.get(u) > positionMap.get(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    // --- Tests ---

    @Test
    public void testExample1_DiamondGraph() {
        int V = 4;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {2, 3}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        int[] result = solution.topoSort(V, adj);
        assertTrue(isValidTopoSort(V, adj, result), "Failed on Example 1: Invalid topological sort.");
    }

    @Test
    public void testExample2_ComplexDAG() {
        int V = 6;
        int[][] edges = {
                {5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        int[] result = solution.topoSort(V, adj);
        assertTrue(isValidTopoSort(V, adj, result), "Failed on Example 2: Invalid topological sort.");
    }

    @Test
    public void testLinearGraph() {
        int V = 5;
        // 0 -> 1 -> 2 -> 3 -> 4
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        int[] result = solution.topoSort(V, adj);
        assertTrue(isValidTopoSort(V, adj, result), "Failed on linear graph.");
    }

    @Test
    public void testDisconnectedGraph() {
        int V = 5;
        // Component 1: 0 -> 1
        // Component 2: 2 -> 3 -> 4
        int[][] edges = {
                {0, 1},
                {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        int[] result = solution.topoSort(V, adj);
        assertTrue(isValidTopoSort(V, adj, result), "Failed on disconnected graph components.");
    }

    @Test
    public void testNoEdges() {
        int V = 4;
        // Entirely disconnected, no dependencies
        int[][] edges = {};
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        int[] result = solution.topoSort(V, adj);
        assertTrue(isValidTopoSort(V, adj, result), "Failed on graph with 0 edges. Any permutation is valid.");
    }
}