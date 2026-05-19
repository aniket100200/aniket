package DSA.aniket.Graphs.RottenOranges;

import DSA.aniket.Graphs.RottenOranges.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RottingOrangesTest {


    private final RottenOranges solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        // Expected: 4
        assertEquals(4, solution.orangesRotting(grid), "Failed on standard Example 1.");
    }

    @Test
    public void testExample2_UnreachableOrange() {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        // Expected: -1 (bottom-left orange cannot be reached)
        assertEquals(-1, solution.orangesRotting(grid), "Failed on unreachable fresh orange.");
    }

    @Test
    public void testExample3_NoFreshOranges() {
        int[][] grid = {
                {0, 2}
        };

        // Expected: 0
        assertEquals(0, solution.orangesRotting(grid), "Failed when no fresh oranges exist initially.");
    }

    @Test
    public void testAllRottenInitially() {
        int[][] grid = {
                {2, 2},
                {2, 2}
        };

        // Expected: 0
        assertEquals(0, solution.orangesRotting(grid), "Failed when all oranges are already rotten.");
    }

    @Test
    public void testAllFreshInitially() {
        int[][] grid = {
                {1, 1},
                {1, 1}
        };

        // Expected: -1 (no rotten oranges to spread the rot)
        assertEquals(-1, solution.orangesRotting(grid), "Failed when there are no rotten oranges to start with.");
    }

    @Test
    public void testEmptyGrid() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0}
        };

        // Expected: 0
        assertEquals(-1, solution.orangesRotting(grid), "Failed on completely empty grid.");
    }
}