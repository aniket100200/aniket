package DSA.aniket.Graphs.DetectCycle;

import DSA.aniket.Graphs.DetectCycle.UndirectedGraph.UsingDFS.UsingDFS;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectCycleUndirectedGraphTest {


    private final DetectCycle solution = new UsingDFS();

    // Helper method to build an adjacency list cleanly for testing
    private ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected, add both ways
        }
        return adj;
    }

    // --- Tests ---

    @Test
    public void testExample1_CycleExists() {
        int V = 5;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (cycle: 1-2-3-4-1)
        assertTrue(solution.isCycle(V, adj), "Failed on Example 1: Expected a cycle.");
    }

    @Test
    public void testExample2_LinearNoCycle() {
        int V = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false
        assertFalse(solution.isCycle(V, adj), "Failed on Example 2: Should not contain a cycle.");
    }

    @Test
    public void testDisconnectedGraph_WithCycle() {
        int V = 6;
        // Component 1 (0-1), Component 2 (2-3, 3-4, 4-5, 5-2)
        int[][] edges = {
                {0, 1},
                {2, 3}, {3, 4}, {4, 5}, {5, 2}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (Cycle exists in the second component)
        assertTrue(solution.isCycle(V, adj), "Failed on disconnected graph containing a cycle.");
    }

    @Test
    public void testDisconnectedGraph_NoCycle() {
        int V = 5;
        // Component 1 (0-1-2), Component 2 (3-4)
        int[][] edges = {
                {0, 1}, {1, 2},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false
        assertFalse(solution.isCycle(V, adj), "Failed on disconnected graph with no cycles.");
    }

    @Test
    public void testTriangleCycle() {
        int V = 3;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true
        assertTrue(solution.isCycle(V, adj), "Failed to detect a simple triangle cycle.");
    }

    @Test
    public void testSingleNodeGraph() {
        int V = 1;
        int[][] edges = {}; // No edges
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false
        assertFalse(solution.isCycle(V, adj), "Failed on a single node graph.");
    }
}