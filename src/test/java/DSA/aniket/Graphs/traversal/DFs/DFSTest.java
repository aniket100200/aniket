package DSA.aniket.Graphs.traversal.DFs;

import DSA.aniket.Graphs.traversal.Traversal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DFSGraphTest {

    private final Traversal solution = new DFS();

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
    public void testExample1_TreeStructure() {
        int V = 5;
        int[][] adjArray = {
                {1, 2, 3}, // 0
                {},        // 1
                {4},       // 2
                {},        // 3
                {}         // 4
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        // DFS goes deep first: 0 -> 1 (backtrack) -> 2 -> 4 (backtrack) -> 3
        List<Integer> expected = Arrays.asList(0, 1, 2, 4, 3);
        assertEquals(expected, solution.traversal(V, adj), "Failed on Example 1.");
    }

    @Test
    public void testExample2_UndirectedGraph() {
        int V = 4;
        int[][] adjArray = {
                {1, 3},    // 0
                {0, 2},    // 1
                {1},       // 2
                {0}        // 3
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected, solution.traversal(V, adj), "Failed on Example 2.");
    }

    @Test
    public void testGraphWithCycle() {
        int V = 5;
        // Edges: 0-1, 1-2, 2-3, 3-4, 4-0 (A ring of 5 nodes)
        // Adjacency list must be ordered properly to simulate standard test case environments
        int[][] adjArray = {
                {1, 4},    // 0
                {0, 2},    // 1
                {1, 3},    // 2
                {2, 4},    // 3
                {3, 0}     // 4
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        // DFS order: 0 -> 1 -> 2 -> 3 -> 4. Cycle to 0 is ignored because 0 is visited.
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(expected, solution.traversal(V, adj), "Failed on graph with cycle. Visited array logic might be flawed.");
    }

    @Test
    public void testLinearGraph() {
        int V = 4;
        // 0 -> 1 -> 2 -> 3
        int[][] adjArray = {
                {1},    // 0
                {2},    // 1
                {3},    // 2
                {}      // 3
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected, solution.traversal(V, adj), "Failed on a simple linear graph.");
    }

    @Test
    public void testDisconnectedGraph() {
        int V = 6;
        // Component 1: 0-1, 0-2. Component 2: 3-4, 4-5
        int[][] adjArray = {
                {1, 2}, // 0
                {0},    // 1
                {0},    // 2
                {4},    // 3
                {3, 5}, // 4
                {4}     // 5
        };
        ArrayList<ArrayList<Integer>> adj = buildAdjListDirectly(V, adjArray);

        // Should only visit nodes reachable from 0. Nodes 3, 4, 5 are ignored.
        List<Integer> expected = Arrays.asList(0, 1, 2);
        assertEquals(expected, solution.traversal(V, adj), "Failed on disconnected graph. DFS from 0 should not reach other components.");
    }

    @Test
    @DisplayName("Test Adjecency Matrix")
    public void testMatrix() {
        int V = 6;
        // Component 1: 0-1, 0-2. Component 2: 3-4, 4-5
//        int[][] adjArray = {
//                {1, 2}, // 0
//                {0},    // 1
//                {0},    // 2
//                {4},    // 3
//                {3, 5}, // 4
//                {4}     // 5
//        };

        int[][] adjArray = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0}

        };

        List<Integer> expected = Arrays.asList(0, 1, 2);
        assertEquals(expected, solution.traversal(V, adjArray), "Failed on disconnected graph. DFS from 0 should not reach other components.");
    }
}