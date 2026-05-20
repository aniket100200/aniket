package DSA.aniket.Graphs.NumberOfEnclaves;

import DSA.aniket.Graphs.NumberOfEnclaves.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfEnclavesTest {


    private final NumberOfEnclaves solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_StandardEnclaves() {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        // Expected: 3
        assertEquals(3, solution.numEnclaves(grid), "Failed on Example 1: Standard isolated enclaves.");
    }

    @Test
    public void testExample2_NoEnclaves() {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        // Expected: 0
        assertEquals(0, solution.numEnclaves(grid), "Failed on Example 2: All land is connected to the boundary.");
    }

    @Test
    public void testAllWater() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        // Expected: 0
        assertEquals(0, solution.numEnclaves(grid), "Failed on a grid entirely made of water.");
    }

    @Test
    public void testAllLand() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        // Expected: 0 (All land touches a boundary)
        assertEquals(0, solution.numEnclaves(grid), "Failed on a grid entirely made of land.");
    }

    @Test
    public void testComplexBoundaryConnection() {
        int[][] grid = {
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        // Even though the land at (1,1) is internal, it connects through (2,1), (2,2), (2,3), and (1,3)
        // to the boundary land at (0,3). Thus, 0 enclaves.
        assertEquals(0, solution.numEnclaves(grid), "Failed to detect complex paths to the boundary.");
    }

    @Test
    public void testMultipleDisjointEnclaves() {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // Enclave 1: (1,1) - size 1
        // Enclave 2: (1,3), (2,3) - size 2
        // Enclave 3: (3,1) - size 1
        // Total = 4
        assertEquals(4, solution.numEnclaves(grid), "Failed on multiple disjoint enclaves.");
    }
}