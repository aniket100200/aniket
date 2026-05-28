package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.PrintShortestPath;

import DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.PrintShortestPath.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrintShortestPathWeightedGraphTest {

    PrintShortestPath solution = new Solution();

    @Test
    @DisplayName("Should return shortest path for sample graph")
    @Timeout(1)
    void testExample1() {

        int n = 5;
        int m = 6;

        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Arrays.asList(1, 4, 3, 5),
                result
        );
    }

    @Test
    @DisplayName("Should return -1 when destination is unreachable")
    @Timeout(1)
    void testDisconnectedGraph() {

        int n = 4;
        int m = 2;

        int[][] edges = {
                {1, 2, 1},
                {3, 4, 2}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Collections.singletonList(-1),
                result
        );
    }

    @Test
    @DisplayName("Should choose smaller indirect path over direct path")
    @Timeout(1)
    void testIndirectPathBetter() {

        int n = 3;
        int m = 3;

        int[][] edges = {
                {1, 2, 1},
                {2, 3, 1},
                {1, 3, 5}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Arrays.asList(1, 2, 3),
                result
        );
    }

    @Test
    @DisplayName("Should handle graph with single node")
    @Timeout(1)
    void testSingleNode() {

        int n = 1;
        int m = 0;

        int[][] edges = {};

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Collections.singletonList(1),
                result
        );
    }

    @Test
    @DisplayName("Should handle multiple shortest path possibilities")
    @Timeout(1)
    void testMultipleShortestPaths() {

        int n = 4;
        int m = 4;

        int[][] edges = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 3, 1},
                {3, 4, 2}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        boolean valid =
                result.equals(Arrays.asList(1, 2, 4)) ||
                        result.equals(Arrays.asList(1, 3, 4));

        assertTrue(valid);
    }

    @Test
    @DisplayName("Should handle larger weighted graph correctly")
    @Timeout(1)
    void testLargerGraph() {

        int n = 6;
        int m = 7;

        int[][] edges = {
                {1, 2, 4},
                {1, 3, 1},
                {3, 2, 2},
                {2, 4, 1},
                {3, 5, 5},
                {4, 6, 3},
                {5, 6, 1}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Arrays.asList(1, 3, 2, 4, 6),
                result
        );
    }

    @Test
    @DisplayName("Should return direct path when only one edge exists")
    @Timeout(1)
    void testDirectEdge() {

        int n = 2;
        int m = 1;

        int[][] edges = {
                {1, 2, 10}
        };

        List<Integer> result =
                solution.shortestPath(n, m, edges);

        assertEquals(
                Arrays.asList(1, 2),
                result
        );
    }
}