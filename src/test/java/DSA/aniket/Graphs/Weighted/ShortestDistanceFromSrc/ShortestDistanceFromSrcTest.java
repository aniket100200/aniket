package DSA.aniket.Graphs.Weighted.ShortestDistanceFromSrc;

import DSA.aniket.Graphs.Weighted.ShortestDistanceFromSrc.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShortestDistanceInDirectedAcyclicGraphTest {

    private final ShortestDistanceFromSrc solution = new Solution();


    @Test
    void testExample1() {

        int V = 6;
        int E = 7;

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        int[] expected = {0, 2, 3, 6, 1, 5};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testUnreachableNode() {

        int V = 4;
        int E = 2;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3}
        };

        int[] expected = {0, 5, 8, (int) 1e9};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testAlternativeShortestPath() {

        int V = 5;
        int E = 6;

        int[][] edges = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 3, 3},
                {2, 3, 1},
                {3, 4, 2},
                {1, 4, 10}
        };

        int[] expected = {0, 1, 2, 3, 5};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testSingleNodeGraph() {

        int V = 1;
        int E = 0;

        int[][] edges = {};

        int[] expected = {0};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testNegativeWeightsInDAG() {

        int V = 4;
        int E = 4;

        int[][] edges = {
                {0, 1, 1},
                {0, 2, 4},
                {1, 2, -2},
                {2, 3, 2}
        };

        int[] expected = {0, 1, -1, 1};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testDisconnectedGraph() {

        int V = 6;
        int E = 3;

        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3},
                {4, 5, 1}
        };

        int[] expected = {0, 2, 5, (int) 1e9, (int) 1e9, (int) 1e9};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testZeroWeightEdges() {

        int V = 5;
        int E = 5;

        int[][] edges = {
                {0, 1, 0},
                {1, 2, 0},
                {2, 3, 0},
                {3, 4, 0},
                {0, 4, 10}
        };

        int[] expected = {0, 0, 0, 0, 0};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }

    @Test
    void testMultiplePaths() {

        int V = 5;
        int E = 7;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 3},
                {2, 1, 1},
                {1, 3, 2},
                {2, 3, 8},
                {3, 4, 7},
                {2, 4, 15}
        };

        int[] expected = {0, 4, 3, 6, 13};

        assertArrayEquals(expected, solution.shortestPath(V, E, edges));
    }
}