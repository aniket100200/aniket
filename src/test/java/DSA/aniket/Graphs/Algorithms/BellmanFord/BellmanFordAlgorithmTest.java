package DSA.aniket.Graphs.Algorithms.BellmanFord;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.BellmanFord.BellmanFord;
import DSA.aniket.Graphs.Algorithms.NegativeCycle.BellmanFord.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BellmanFordAlgorithmTest {

    private final BellmanFord solution = new Solution();

    @Test
    @DisplayName("Standard graph with negative edges")
    @Timeout(1)
    void testStandardGraph() {

        int V = 4;

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 5},
                {1, 2, -3},
                {2, 3, 4}
        };

        int[] expected = {0, 4, 1, 5};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Negative cycle exists")
    @Timeout(1)
    void testNegativeCycle() {

        int V = 3;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, -1},
                {2, 0, -1}
        };

        assertArrayEquals(
                new int[]{-1},
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Single vertex graph")
    @Timeout(1)
    void testSingleVertex() {

        int V = 1;
        int[][] edges = {};

        assertArrayEquals(
                new int[]{0},
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Disconnected graph")
    @Timeout(1)
    void testDisconnectedGraph() {

        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3}
        };

        int[] expected = {
                0,
                2,
                5,
                100000000,
                100000000
        };

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("All positive weights")
    @Timeout(1)
    void testPositiveWeights() {

        int V = 4;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 2},
                {2, 3, 3}
        };

        int[] expected = {0, 1, 3, 6};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Negative edge but no cycle")
    @Timeout(1)
    void testNegativeEdgeNoCycle() {

        int V = 3;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, -2}
        };

        int[] expected = {0, 5, 3};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Cycle exists but not negative")
    @Timeout(1)
    void testNonNegativeCycle() {

        int V = 3;

        int[][] edges = {
                {0, 1, 2},
                {1, 2, 2},
                {2, 0, -3}
        };

        int[] expected = {0, 2, 4};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Negative cycle not reachable from source")
    @Timeout(1)
    void testUnreachableNegativeCycle() {

        int V = 5;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 2},
                {3, 4, -5},
                {4, 3, -5}
        };

        int[] expected = {
                0,
                1,
                3,
                100000000,
                100000000
        };

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Multiple shortest path updates")
    @Timeout(1)
    void testMultipleRelaxations() {

        int V = 5;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 5},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 9},
                {3, 4, 4}
        };

        int[] expected = {0, 7, 5, 8, 12};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }

    @Test
    @DisplayName("Long chain graph")
    @Timeout(1)
    void testLongChainGraph() {

        int V = 6;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1},
                {3, 4, 1},
                {4, 5, 1}
        };

        int[] expected = {0, 1, 2, 3, 4, 5};

        assertArrayEquals(
                expected,
                solution.bellmanFord(V, edges, 0)
        );
    }
}