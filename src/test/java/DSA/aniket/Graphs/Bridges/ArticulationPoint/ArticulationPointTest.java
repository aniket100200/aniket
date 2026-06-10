package DSA.aniket.Graphs.Bridges.ArticulationPoint;

import DSA.aniket.Graphs.Bridges.ArticulationPoint.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ArticulationPointTest {

    private final ArticulationPoint solution = new Solution();

    private ArrayList<ArrayList<Integer>> createGraph(
            int V
    ) {

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }

    private void addEdge(
            ArrayList<ArrayList<Integer>> adj,
            int u,
            int v
    ) {

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    @Test
    @DisplayName("Chain Graph")
    @Timeout(1)
    void testChainGraph() {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Arrays.asList(1, 2)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Triangle Graph")
    @Timeout(1)
    void testTriangleGraph() {

        int V = 3;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(-1)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Star Graph")
    @Timeout(1)
    void testStarGraph() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 4);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(0)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Example With Two Articulation Points")
    @Timeout(1)
    void testExampleGraph() {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Arrays.asList(0, 1, 3)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Single Node")
    @Timeout(1)
    void testSingleNode() {

        int V = 1;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(-1)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Two Nodes One Edge")
    @Timeout(1)
    void testTwoNodes() {

        int V = 2;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(-1)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Disconnected Graph")
    @Timeout(1)
    void testDisconnectedGraph() {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);

        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Arrays.asList(1, 4)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Square Cycle")
    @Timeout(1)
    void testSquareCycle() {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(-1)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Root Is Articulation")
    @Timeout(1)
    void testRootArticulation() {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Collections.singletonList(0)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Complex Graph")
    @Timeout(1)
    void testComplexGraph() {

        int V = 7;

        ArrayList<ArrayList<Integer>> adj =
                createGraph(V);

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);

        addEdge(adj, 1, 3);

        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        addEdge(adj, 5, 6);

        ArrayList<Integer> expected =
                new ArrayList<>(
                        Arrays.asList(1, 3, 5)
                );

        ArrayList<Integer> result =
                solution.articulationPoints(V, adj);

        assertIterableEquals(expected, result);
    }
}