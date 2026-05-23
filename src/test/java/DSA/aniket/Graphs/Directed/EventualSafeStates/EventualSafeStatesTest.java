package DSA.aniket.Graphs.Directed.EventualSafeStates;

import DSA.aniket.Graphs.Directed.EventualSafeStates.UsingKahansAlgo.UsingKahansAlgo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventualSafeStatesTest {

    // The Solution implementation
    private final EventualSafeStates solution = new UsingKahansAlgo();

    // Helper method to build an adjacency list cleanly for testing
    private List<List<Integer>> buildAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // Directed edge
        }
        return adj;
    }

    // --- Tests ---

    @Test
    public void testExample1_MixedSafeAndUnsafe() {
        int V = 7;
        int[][] edges = {
                {0, 1}, {0, 2},
                {1, 2}, {1, 3},
                {2, 5},
                {3, 0},
                {4, 5}
        };
        List<List<Integer>> adj = buildAdjList(V, edges);

        // Expected: [2, 4, 5, 6]
        List<Integer> expected = Arrays.asList(2, 4, 5, 6);
        assertEquals(expected, solution.eventualSafeNodes(V, adj), "Failed on Example 1.");
    }

    @Test
    public void testExample2_AllLeadToCycle() {
        int V = 4;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 1}
        };
        List<List<Integer>> adj = buildAdjList(V, edges);

        // Expected: [] (Node 0 points to cycle, so it is also unsafe)
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.eventualSafeNodes(V, adj), "Failed when all paths lead to a cycle.");
    }

    @Test
    public void testNoCycles_AllSafe() {
        int V = 5;
        // 0 -> 1 -> 2 -> 3 -> 4
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        List<List<Integer>> adj = buildAdjList(V, edges);

        // Expected: [0, 1, 2, 3, 4]
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expected, solution.eventualSafeNodes(V, adj), "Failed on linear graph (all safe).");
    }

    @Test
    public void testSelfLoop() {
        int V = 3;
        int[][] edges = {
                {0, 1}, {1, 1}, {2, 0}
        };
        List<List<Integer>> adj = buildAdjList(V, edges);

        // Node 1 has a self-loop (unsafe).
        // Node 0 points to 1 (unsafe).
        // Node 2 points to 0 (unsafe).
        // Expected: []
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, solution.eventualSafeNodes(V, adj), "Failed to detect a self-loop making paths unsafe.");
    }

    @Test
    public void testDisconnectedGraph() {
        int V = 5;
        // Component 1: 0 -> 1 (Safe)
        // Component 2: 2 -> 3 -> 4 -> 2 (Cycle, Unsafe)
        int[][] edges = {
                {0, 1},
                {2, 3}, {3, 4}, {4, 2}
        };
        List<List<Integer>> adj = buildAdjList(V, edges);

        // Expected: [0, 1]
        List<Integer> expected = Arrays.asList(0, 1);
        assertEquals(expected, solution.eventualSafeNodes(V, adj), "Failed on disconnected graph.");
    }
}