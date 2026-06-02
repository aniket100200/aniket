package DSA.aniket.Graphs.DisjointSet.KrushkalsAlgorithm;

import DSA.aniket.Graphs.DisjointSet.KrushkalsAlgorithm.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KruskalsAlgorithmTest {

    private final KrushkalsAlgorithm solution = new Solution();

    @Test
    @DisplayName("Example 1 - Basic Triangle Graph")
    @Timeout(1)
    void testExample1() {
        int V = 3;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };

        assertEquals(4, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Example 2 - Standard MST Example")
    @Timeout(1)
    void testExample2() {
        int V = 4;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        assertEquals(19, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Example 3 - Five Vertex Graph")
    @Timeout(1)
    void testExample3() {
        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 2, 3},
                {1, 3, 8},
                {1, 4, 5},
                {2, 4, 7}
        };

        assertEquals(16, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Single Vertex Graph")
    @Timeout(1)
    void testSingleVertex() {
        int V = 1;
        int[][] edges = {};

        assertEquals(0, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Two Vertices One Edge")
    @Timeout(1)
    void testTwoVertices() {
        int V = 2;

        int[][] edges = {
                {0, 1, 7}
        };

        assertEquals(7, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Graph With Duplicate Edges")
    @Timeout(1)
    void testDuplicateEdges() {
        int V = 3;

        int[][] edges = {
                {0, 1, 10},
                {0, 1, 5},
                {1, 2, 2},
                {0, 2, 100}
        };

        assertEquals(7, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Graph Containing Self Loop")
    @Timeout(1)
    void testSelfLoop() {
        int V = 3;

        int[][] edges = {
                {0, 0, 1},
                {0, 1, 4},
                {1, 2, 5}
        };

        assertEquals(9, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("All Edge Weights Equal")
    @Timeout(1)
    void testEqualWeights() {
        int V = 4;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1},
                {0, 3, 1},
                {0, 2, 1}
        };

        assertEquals(3, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Already a Tree")
    @Timeout(1)
    void testAlreadyTree() {
        int V = 5;

        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };

        assertEquals(14, solution.spanningTree(V, edges));
    }

    @Test
    @DisplayName("Large Edge Weight Values")
    @Timeout(1)
    void testLargeWeights() {
        int V = 3;

        int[][] edges = {
                {0, 1, 1_000_000},
                {1, 2, 2_000_000},
                {0, 2, 5_000_000}
        };

        assertEquals(3_000_000, solution.spanningTree(V, edges));
    }
}