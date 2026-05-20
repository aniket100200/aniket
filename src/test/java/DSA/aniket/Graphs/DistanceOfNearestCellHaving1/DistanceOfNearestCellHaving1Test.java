package DSA.aniket.Graphs.DistanceOfNearestCellHaving1;

import DSA.aniket.Graphs.DistanceOfNearestCellHaving1.Solution.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NearestCellHavingOneTest {

    private final DistanceOfNearestCellHaving1 solution = new Solution();

    // Helper method to compare 2D arrays deeply
    private boolean areMatricesEqual(int[][] expected, int[][] actual) {
        return Arrays.deepEquals(expected, actual);
    }

    // --- Tests ---

    @Test
    public void testExample1_SingleOneInCenter() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] expected = {
                {2, 1, 2},
                {1, 0, 1},
                {2, 1, 2}
        };

        int[][] result = solution.nearest(grid);
        assertTrue(areMatricesEqual(expected, result), "Failed on Example 1.");
    }

    @Test
    public void testExample2_MultipleOnes() {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] expected = {
                {1, 0, 0},
                {0, 0, 1},
                {0, 1, 0}
        };

        int[][] result = solution.nearest(grid);
        assertTrue(areMatricesEqual(expected, result), "Failed on Example 2.");
    }

    @Test
    public void testAllOnes() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        // Everything should be distance 0
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] result = solution.nearest(grid);
        assertTrue(areMatricesEqual(expected, result), "Failed on grid with all 1s.");
    }

    @Test
    public void testOneInCorner() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int[][] expected = {
                {4, 3, 2},
                {3, 2, 1},
                {2, 1, 0}
        };

        int[][] result = solution.nearest(grid);
        assertTrue(areMatricesEqual(expected, result), "Failed when the only 1 is in the corner.");
    }

    @Test
    public void testRectangularGrid() {
        int[][] grid = {
                {0, 0},
                {0, 1},
                {0, 0},
                {1, 0}
        };

        int[][] expected = {
                {2, 1},
                {1, 0},
                {1, 1},
                {0, 1}
        };

        int[][] result = solution.nearest(grid);
        assertTrue(areMatricesEqual(expected, result), "Failed on a rectangular (non-square) grid.");
    }
}