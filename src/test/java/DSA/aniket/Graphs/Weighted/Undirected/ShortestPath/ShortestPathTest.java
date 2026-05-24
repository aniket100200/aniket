package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath;

import DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShortestPathInUndirectedGraphTest {

    private final ShortestPath solution = new Solution();

    @Test
    void testExample1() {

        int V = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 4}
        };

        int src = 0;

        int[] expected = {0, 1, 1, 2, 2};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testDisconnectedGraph() {

        int V = 6;

        int[][] edges = {
                {0, 1},
                {0, 3},
                {3, 4},
                {4, 5}
        };

        int src = 0;

        int[] expected = {0, 1, -1, 1, 2, 3};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testLinearGraph() {

        int V = 4;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3}
        };

        int src = 2;

        int[] expected = {2, 1, 0, 1};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testSingleNodeGraph() {

        int V = 1;

        int[][] edges = {};

        int src = 0;

        int[] expected = {0};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testNoEdges() {

        int V = 5;

        int[][] edges = {};

        int src = 2;

        int[] expected = {-1, -1, 0, -1, -1};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testCompleteGraph() {

        int V = 4;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int src = 0;

        int[] expected = {0, 1, 1, 1};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testCycleGraph() {

        int V = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 0}
        };

        int src = 0;

        int[] expected = {0, 1, 2, 2, 1};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testSourceAtEnd() {

        int V = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        int src = 4;

        int[] expected = {4, 3, 2, 1, 0};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testMultipleDisconnectedComponents() {

        int V = 8;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int src = 0;

        int[] expected = {0, 1, 2, -1, -1, -1, -1, -1};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }

    @Test
    void testTreeStructure() {

        int V = 7;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {2, 6}
        };

        int src = 0;

        int[] expected = {0, 1, 1, 2, 2, 2, 2};

        assertArrayEquals(expected, solution.shortestPath(V, edges, src));
    }
}