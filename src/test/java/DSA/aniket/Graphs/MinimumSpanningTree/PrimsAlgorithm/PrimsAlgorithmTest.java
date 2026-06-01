package DSA.aniket.Graphs.MinimumSpanningTree.PrimsAlgorithm;

import DSA.aniket.Graphs.MinimumSpanningTree.PrimsAlgorithm.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimsAlgorithmTest {

    private final PrimsAlgorithm solution = new Solution();


    @Test
    @DisplayName("Example 1 - Triangle Graph")
    @Timeout(1)
    void testExample1() {

        int V = 3;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };

        assertEquals(4,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Example 2 - Standard MST Example")
    @Timeout(1)
    void testExample2() {

        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7},
                {3, 4, 9}
        };

        assertEquals(16,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Single Vertex Graph")
    @Timeout(1)
    void testSingleVertex() {

        int V = 1;
        int[][] edges = {};

        assertEquals(0,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Two Vertices One Edge")
    @Timeout(1)
    void testTwoVertices() {

        int V = 2;

        int[][] edges = {
                {0, 1, 10}
        };

        assertEquals(10,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Square Graph")
    @Timeout(1)
    void testSquareGraph() {

        int V = 4;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 2},
                {2, 3, 3},
                {3, 0, 4},
                {0, 2, 10}
        };

        assertEquals(6,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Already A Tree")
    @Timeout(1)
    void testAlreadyTree() {

        int V = 5;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 2},
                {2, 3, 3},
                {3, 4, 4}
        };

        assertEquals(10,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Graph With Equal Weights")
    @Timeout(1)
    void testEqualWeights() {

        int V = 4;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 5},
                {2, 3, 5},
                {3, 0, 5},
                {0, 2, 5}
        };

        assertEquals(15,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Dense Graph")
    @Timeout(1)
    void testDenseGraph() {

        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {0, 2, 3},
                {0, 3, 1},
                {0, 4, 4},
                {1, 2, 5},
                {1, 3, 2},
                {1, 4, 3},
                {2, 3, 6},
                {2, 4, 7},
                {3, 4, 2}
        };

        assertEquals(8,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Graph With Large Weights")
    @Timeout(1)
    void testLargeWeights() {

        int V = 3;

        int[][] edges = {
                {0, 1, 1000000},
                {1, 2, 2000000},
                {0, 2, 5000000}
        };

        assertEquals(3000000,
                solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Star Graph")
    @Timeout(1)
    void testStarGraph() {

        int V = 6;

        int[][] edges = {
                {0, 1, 1},
                {0, 2, 2},
                {0, 3, 3},
                {0, 4, 4},
                {0, 5, 5}
        };

        assertEquals(15,
                solution.spanningTree(V, edges));
    }
}