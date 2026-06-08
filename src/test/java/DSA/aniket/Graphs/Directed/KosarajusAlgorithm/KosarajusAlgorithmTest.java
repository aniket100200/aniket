package DSA.aniket.Graphs.Directed.KosarajusAlgorithm;

import DSA.aniket.Graphs.Directed.KosarajusAlgorithm.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KosarajusAlgorithmTest {

    private final KosarajusAlgorithm solution = new Solution();


    private ArrayList<ArrayList<Integer>> createGraph(int V) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }

    @Test
    @DisplayName("Example 1 - Three SCCs")
    @Timeout(1)
    void testExample1() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(4);

        int expected = 3;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 2 - Entire Graph One SCC")
    @Timeout(1)
    void testExample2() {

        int V = 3;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        int expected = 1;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 3 - Every Node Separate SCC")
    @Timeout(1)
    void testExample3() {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);

        int expected = 4;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Single Vertex")
    @Timeout(1)
    void testSingleVertex() {

        int V = 1;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        int expected = 1;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Disconnected Vertices")
    @Timeout(1)
    void testDisconnectedVertices() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        int expected = 5;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Two Separate Cycles")
    @Timeout(1)
    void testTwoSeparateCycles() {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(3);

        int expected = 2;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Cycle Connected To Chain")
    @Timeout(1)
    void testCycleConnectedToChain() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        adj.get(2).add(3);
        adj.get(3).add(4);

        int expected = 3;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Large SCC With Tail")
    @Timeout(1)
    void testLargeSCCWithTail() {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        adj.get(3).add(4);
        adj.get(4).add(5);

        int expected = 3;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Star Directed Graph")
    @Timeout(1)
    void testStarGraph() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(4);

        int expected = 5;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Complex Graph With Four SCCs")
    @Timeout(1)
    void testComplexGraph() {

        int V = 8;

        ArrayList<ArrayList<Integer>> adj = createGraph(V);

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        adj.get(2).add(3);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(6).add(7);

        int expected = 4;

        int result = solution.kosaraju(V, adj);

        assertEquals(expected, result);
    }
}