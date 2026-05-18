package DSA.aniket.Graphs.NumberOfProvinces;

import DSA.aniket.Graphs.NumberOfProvinces.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfProvincesTest {


    private final NumberOfProvinces solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_TwoProvinces() {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // Expected: 2
        assertEquals(2, solution.findCircleNum(isConnected), "Failed on Example 1.");
    }

    @Test
    public void testExample2_CompletelyDisconnected() {
        int[][] isConnected = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        // Expected: 3
        assertEquals(3, solution.findCircleNum(isConnected), "Failed on completely disconnected graph.");
    }

    @Test
    public void testFullyConnectedGraph() {
        int[][] isConnected = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        // Expected: 1 (Everyone is friends with everyone)
        assertEquals(1, solution.findCircleNum(isConnected), "Failed on a fully connected graph.");
    }

    @Test
    public void testSingleCity() {
        int[][] isConnected = {
                {1}
        };

        // Expected: 1
        assertEquals(1, solution.findCircleNum(isConnected), "Failed on a single city graph.");
    }

    @Test
    public void testLinearChainConnection() {
        // 0 is connected to 1. 1 is connected to 2. 2 is connected to 3.
        // This forms a single chain/province.
        int[][] isConnected = {
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };

        // Expected: 1
        assertEquals(1, solution.findCircleNum(isConnected), "Failed on a linear chain connection.");
    }

    @Test
    public void testComplexGraph() {
        // 0-1 and 2-3-4
        int[][] isConnected = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1}
        };

        // Expected: 2 provinces
        assertEquals(2, solution.findCircleNum(isConnected), "Failed on multiple complex components.");
    }
}