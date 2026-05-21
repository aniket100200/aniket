package DSA.aniket.Graphs.DetectCycle.DirectedGraph.UsingDFS;

import DSA.aniket.Graphs.DetectCycle.DetectCycle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectCycleDirectedGraphTest {

    private final DetectCycle solution = new UsingDFS();

    // Helper method to build an adjacency list cleanly for testing
    private ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            // Directed graph: only add edge from u to v
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }

    // --- Tests ---

    @Test
    public void testExample1_CycleExists() {
        int V = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 1}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (cycle: 1 -> 2 -> 3 -> 1)
        assertTrue(solution.isCycle(V, adj), "Failed on Example 1: Expected a cycle.");
    }

    @Test
    public void testExample2_NoCycle() {
        int V = 3;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false (Node 2 is visited twice, but not in the same path)
        assertFalse(solution.isCycle(V, adj), "Failed on Example 2: Should not contain a cycle.");
    }

    @Test
    public void testSelfLoop() {
        int V = 2;
        int[][] edges = {
                {0, 1}, {1, 1} // 1 points to itself
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true
        assertTrue(solution.isCycle(V, adj), "Failed to detect a self-loop cycle.");
    }

    @Test
    public void testDisconnectedGraph_WithCycle() {
        int V = 6;
        // Component 1 (0 -> 1 -> 2), Component 2 (3 -> 4 -> 5 -> 3)
        int[][] edges = {
                {0, 1}, {1, 2},
                {3, 4}, {4, 5}, {5, 3}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: true (Cycle exists in the second component)
        assertTrue(solution.isCycle(V, adj), "Failed on disconnected graph containing a cycle.");
    }

    @Test
    public void testLinearDirectedGraph() {
        int V = 5;
        // 0 -> 1 -> 2 -> 3 -> 4
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges);

        // Expected: false
        assertFalse(solution.isCycle(V, adj), "Failed on a simple linear directed graph.");
    }
}