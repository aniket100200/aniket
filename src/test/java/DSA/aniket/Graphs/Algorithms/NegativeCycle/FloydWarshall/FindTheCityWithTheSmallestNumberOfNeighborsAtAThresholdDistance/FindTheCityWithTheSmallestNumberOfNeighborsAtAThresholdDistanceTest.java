package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

import DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistanceTest {

    private final FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance solution = new Solution();

    @Test
    @DisplayName("Example 1 - Standard Case")
    @Timeout(1)
    void testExample1() {

        int n = 4;
        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int threshold = 4;

        assertEquals(3,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Example 2 - Small Threshold")
    @Timeout(1)
    void testExample2() {

        int n = 5;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        int threshold = 2;

        assertEquals(0,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Example 3 - No Reachable Neighbor")
    @Timeout(1)
    void testExample3() {

        int n = 2;
        int[][] edges = {
                {0, 1, 5}
        };
        int threshold = 3;

        assertEquals(1,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Single Chain Graph")
    @Timeout(1)
    void testChainGraph() {

        int n = 4;
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 2},
                {2, 3, 2}
        };

        int threshold = 2;

        assertEquals(3,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Complete Graph")
    @Timeout(1)
    void testCompleteGraph() {

        int n = 4;
        int[][] edges = {
                {0, 1, 1},
                {0, 2, 1},
                {0, 3, 1},
                {1, 2, 1},
                {1, 3, 1},
                {2, 3, 1}
        };

        int threshold = 5;

        assertEquals(3,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Tie Breaker Returns Largest Index")
    @Timeout(1)
    void testTieBreaker() {

        int n = 3;
        int[][] edges = {
                {0, 1, 10},
                {1, 2, 10}
        };

        int threshold = 5;

        assertEquals(2,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Threshold Allows All Cities")
    @Timeout(1)
    void testAllReachable() {

        int n = 4;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 1},
                {2, 3, 1}
        };

        int threshold = 100;

        assertEquals(3,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Disconnected Components")
    @Timeout(1)
    void testDisconnectedComponents() {

        int n = 6;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 1},
                {3, 4, 1},
                {4, 5, 1}
        };

        int threshold = 2;

        assertEquals(5,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Minimum Number Of Cities")
    @Timeout(1)
    void testMinimumCities() {

        int n = 2;
        int[][] edges = {
                {0, 1, 1}
        };

        int threshold = 1;

        assertEquals(1,
                solution.findTheCity(n, edges, threshold));
    }

    @Test
    @DisplayName("Large Edge Weights")
    @Timeout(1)
    void testLargeWeights() {

        int n = 4;
        int[][] edges = {
                {0, 1, 1000},
                {1, 2, 1000},
                {2, 3, 1000}
        };

        int threshold = 1500;

        assertEquals(3,
                solution.findTheCity(n, edges, threshold));
    }
}