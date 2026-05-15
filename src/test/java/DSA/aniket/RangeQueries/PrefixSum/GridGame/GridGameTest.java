package DSA.aniket.RangeQueries.PrefixSum.GridGame;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.GridGame.GridGame;
import DSA.aniket.Arrays.RangeQueries.PrefixSum.GridGame.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridGameTest {


    private final GridGame solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[][] grid = {
                {2, 5, 4},
                {1, 5, 1}
        };

        // Expected: 4
        assertEquals(4L, solution.gridGame(grid), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[][] grid = {
                {1, 2, 1, 15},
                {1, 3, 3, 1}
        };

        // Expected: 7
        assertEquals(7L, solution.gridGame(grid), "Failed on Example 2.");
    }

    @Test
    public void testExample3_Robot1ForcesZero() {
        int[][] grid = {
                {3, 3, 1},
                {8, 5, 2}
        };

        // Robot 1 drops at index 0 to minimize Robot 2.
        // Robot 2 gets max(top remaining, bottom before).
        // Top remaining: 3 + 1 = 4. Bottom before: 0. Max is 4.
        assertEquals(4L, solution.gridGame(grid), "Failed on alternate grid layout.");
    }

    @Test
    public void testSingleColumnGrid() {
        int[][] grid = {
                {10},
                {20}
        };

        // Robot 1 takes both cells. Robot 2 gets 0.
        assertEquals(0L, solution.gridGame(grid), "Failed on a 1-column grid.");
    }

    @Test
    public void testLargeGrid_PreventsIntegerOverflow() {
        // Create a grid large enough to exceed 32-bit signed integer limits
        int n = 50000;
        int[][] grid = new int[2][n];

        for (int i = 0; i < n; i++) {
            grid[0][i] = 100000;
            grid[1][i] = 100000;
        }
        long expectedScore = 2500000000L;

        assertEquals(expectedScore, solution.gridGame(grid),
                "Failed on large grid. Check for integer overflow (use long instead of int).");
    }
}