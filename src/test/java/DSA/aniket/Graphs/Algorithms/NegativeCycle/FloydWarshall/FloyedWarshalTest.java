package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FloydWarshallAlgorithmTest {

    private final FloydWarshall solution = new Solution();


    private void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    @DisplayName("Example 1 - Standard Floyd Warshall Case")
    @Timeout(1)
    void testExample1() {
        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, 4},
                {-1, -1, -1, 0}
        };

        int[][] expected = {
                {0, 2, 5, 9},
                {1, 0, 3, 7},
                {-1, -1, 0, 4},
                {-1, -1, -1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Example 2 - All Vertices Become Reachable")
    @Timeout(1)
    void testExample2() {
        int[][] matrix = {
                {0, 5, -1},
                {-1, 0, 2},
                {1, -1, 0}
        };

        int[][] expected = {
                {0, 5, 7},
                {3, 0, 2},
                {1, 6, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Example 3 - Completely Disconnected Graph")
    @Timeout(1)
    void testDisconnectedGraph() {
        int[][] matrix = {
                {0, -1},
                {-1, 0}
        };

        int[][] expected = {
                {0, -1},
                {-1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Single Vertex Graph")
    @Timeout(1)
    void testSingleVertex() {
        int[][] matrix = {
                {0}
        };

        int[][] expected = {
                {0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Indirect Path Shorter Than Direct Path")
    @Timeout(1)
    void testIndirectPathShorter() {
        int[][] matrix = {
                {0, 10, 100},
                {-1, 0, 5},
                {-1, -1, 0}
        };

        int[][] expected = {
                {0, 10, 15},
                {-1, 0, 5},
                {-1, -1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Already Optimal Matrix")
    @Timeout(1)
    void testAlreadyOptimal() {
        int[][] matrix = {
                {0, 1, 2},
                {1, 0, 1},
                {2, 1, 0}
        };

        int[][] expected = {
                {0, 1, 2},
                {1, 0, 1},
                {2, 1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Directed Graph Reachability")
    @Timeout(1)
    void testDirectedGraph() {
        int[][] matrix = {
                {0, 4, -1},
                {-1, 0, 6},
                {-1, -1, 0}
        };

        int[][] expected = {
                {0, 4, 10},
                {-1, 0, 6},
                {-1, -1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    @DisplayName("Graph With Multiple Intermediate Vertices")
    @Timeout(1)
    void testMultipleIntermediateVertices() {
        int[][] matrix = {
                {0, 3, -1, -1},
                {-1, 0, 4, -1},
                {-1, -1, 0, 2},
                {-1, -1, -1, 0}
        };

        int[][] expected = {
                {0, 3, 7, 9},
                {-1, 0, 4, 6},
                {-1, -1, 0, 2},
                {-1, -1, -1, 0}
        };

        solution.shortestDistance(matrix);

        assertMatrixEquals(expected, matrix);
    }
}