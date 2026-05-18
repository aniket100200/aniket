package DSA.aniket.Graphs.NumberOfIslands;

import DSA.aniket.Graphs.NumberOfIslands.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfIslandsDSUTest {

    private final NumberOfIslands solution = new Solution();

    @Test
    public void testExample1() {
        char[][] grid = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };

        // Expected: 4
        assertEquals(4, solution.numIslands(grid), "Failed on Example 1.");
    }

    // --- Tests ---

    @Test
    public void testDiagonalConnections() {
        // Because 8 directions are allowed, this entire diagonal line is ONE island.
        char[][] grid = {
                {'L', 'W', 'W'},
                {'W', 'L', 'W'},
                {'W', 'W', 'L'}
        };

        // Expected: 1
        assertEquals(1, solution.numIslands(grid), "Failed to recognize diagonal connections.");
    }

    @Test
    public void testAllWater() {
        char[][] grid = {
                {'W', 'W', 'W'},
                {'W', 'W', 'W'},
                {'W', 'W', 'W'}
        };

        // Expected: 0
        assertEquals(0, solution.numIslands(grid), "Failed on an all-water grid.");
    }

    @Test
    public void testAllLand() {
        char[][] grid = {
                {'L', 'L', 'L'},
                {'L', 'L', 'L'},
                {'L', 'L', 'L'}
        };

        // Expected: 1
        assertEquals(1, solution.numIslands(grid), "Failed on an all-land grid.");
    }

    @Test
    public void testSingleCells() {
        char[][] landGrid = {{'L'}};
        char[][] waterGrid = {{'W'}};

        assertEquals(1, solution.numIslands(landGrid), "Failed on single cell land grid.");
        assertEquals(0, solution.numIslands(waterGrid), "Failed on single cell water grid.");
    }
}