package DSA.aniket.Graphs.traversal.BFS;

import DSA.aniket.Graphs.traversal.Traversal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BFSGraphTest {

    private final Traversal solution = new BFS();

    // Helper method to build an adjacency list cleanly for our test cases
    private ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges, boolean isDirected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            if (!isDirected) {
                adj.get(edge[1]).add(edge[0]);
            }
        }
        return adj;
    }

    // Helper to build adjacency list directly from 2D arrays (like example inputs)
    private ArrayList<ArrayList<Integer>> buildAdjListDirectly(int V, int[][] adjArray) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int neighbor : adjArray[i]) {
                neighbors.add(neighbor);
            }
            adj.add(neighbors);
        }
        return adj;
    }

    // --- Tests ---

    @Test
    public void testExample1_DirectedTree() {
        int V = 5;
        int[][] adjArray = {
                {1, 2, 3}, // 0 is connected to 1, 2, 3
                {},        // 1 has no outgoing edges
                {4},       // 2 is connected to 4
                {},        // 3 has no outgoing edges
                {}         // 4 has no outgoing edges
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expected, solution.traversal(V, adj), "Failed on Example 1.");
    }

    @Test
    public void testExample2_UndirectedGraph() {
        int V = 4;
        int[][] adjArray = {
                {1},       // 0 connected to 1
                {0, 2, 3}, // 1 connected to 0, 2, 3
                {1},       // 2 connected to 1
                {1}        // 3 connected to 1
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected, solution.traversal(V, adj), "Failed on Example 2.");
    }

    @Test
    public void testGraphWithCycle() {
        int V = 5;
        // Edges: 0-1, 1-2, 2-3, 3-4, 4-0 (A ring of 5 nodes)
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges, true);

        // Expected BFS order starting from 0: 0 -> 1 -> 2 -> 3 -> 4
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expected, solution.traversal(V, adj), "Failed on graph with cycle. Did you handle the visited array correctly?");
    }

    @Test
    public void testStarGraph() {
        int V = 5;
        // 0 is the center connected to 1, 2, 3, 4
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges, false);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expected, solution.traversal(V, adj), "Failed on Star Graph topology.");
    }

    @Test
    public void testDisconnectedGraph() {
        int V = 6;
        // Component 1: 0-1, 0-2. Component 2: 3-4, 4-5
        int[][] edges = {{0, 1}, {0, 2}, {3, 4}, {4, 5}};
        ArrayList<ArrayList<Integer>> adj = buildAdjList(V, edges, false);

        // Should only visit nodes reachable from 0
        List<Integer> expected = Arrays.asList(0, 1, 2);
        assertEquals(expected, solution.traversal(V, adj), "Failed on disconnected graph. Should only traverse the component containing 0.");
    }
}