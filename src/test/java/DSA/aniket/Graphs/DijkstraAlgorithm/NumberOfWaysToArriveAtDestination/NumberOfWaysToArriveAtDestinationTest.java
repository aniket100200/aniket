package DSA.aniket.Graphs.DijkstraAlgorithm.NumberOfWaysToArriveAtDestination;

import DSA.aniket.Graphs.DijkstraAlgorithm.NumberOfWaysToArriveAtDestination.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfWaysToArriveAtDestinationTest {

    private final NumberOfWaysToArriveAtDestination solution = new Solution();

    @Test
    @DisplayName("LeetCode Example 1")
    @Timeout(1)
    void testExample1() {

        int n = 7;

        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        assertEquals(4, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("LeetCode Example 2")
    @Timeout(1)
    void testExample2() {

        int n = 2;

        int[][] roads = {
                {1, 0, 10}
        };

        assertEquals(1, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Two shortest paths")
    @Timeout(1)
    void testTwoShortestPaths() {

        int n = 4;

        int[][] roads = {
                {0, 1, 1},
                {1, 3, 1},
                {0, 2, 1},
                {2, 3, 1}
        };

        assertEquals(2, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Single node graph")
    @Timeout(1)
    void testSingleNode() {

        int n = 1;
        int[][] roads = {};

        assertEquals(1, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Only one shortest route exists")
    @Timeout(1)
    void testSingleShortestRoute() {

        int n = 3;

        int[][] roads = {
                {0, 1, 2},
                {1, 2, 2},
                {0, 2, 10}
        };

        assertEquals(1, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Three equal shortest paths")
    @Timeout(1)
    void testThreeShortestPaths() {

        int n = 5;

        int[][] roads = {
                {0, 1, 1},
                {1, 4, 1},
                {0, 2, 1},
                {2, 4, 1},
                {0, 3, 1},
                {3, 4, 1}
        };

        assertEquals(3, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Longer path should not be counted")
    @Timeout(1)
    void testIgnoreLongerPath() {

        int n = 4;

        int[][] roads = {
                {0, 1, 1},
                {1, 3, 1},
                {0, 2, 1},
                {2, 3, 5}
        };

        assertEquals(1, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Large edge weights")
    @Timeout(1)
    void testLargeWeights() {

        int n = 3;

        int[][] roads = {
                {0, 1, 1_000_000_000},
                {1, 2, 1_000_000_000},
                {0, 2, 2_000_000_000}
        };

        assertEquals(2, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Diamond graph")
    @Timeout(1)
    void testDiamondGraph() {

        int n = 4;

        int[][] roads = {
                {0, 1, 1},
                {0, 2, 1},
                {1, 3, 1},
                {2, 3, 1}
        };

        assertEquals(2, solution.countPaths(n, roads));
    }

    @Test
    @DisplayName("Multiple shortest paths through intermediate nodes")
    @Timeout(1)
    void testMultipleIntermediatePaths() {

        int n = 6;

        int[][] roads = {
                {0, 1, 1},
                {1, 5, 2},
                {0, 2, 1},
                {2, 5, 2},
                {0, 3, 1},
                {3, 5, 2},
                {0, 4, 10},
                {4, 5, 1}
        };

        assertEquals(3, solution.countPaths(n, roads));
    }
}