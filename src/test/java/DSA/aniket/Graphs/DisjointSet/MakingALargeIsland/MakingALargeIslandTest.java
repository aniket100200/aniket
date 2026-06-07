package DSA.aniket.Graphs.DisjointSet.MakingALargeIsland;

import DSA.aniket.Graphs.DisjointSet.MakingALargeIsland.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakingALargeIslandTest {

    private final MakingALargeIsland solution = new Solution();


    @Test
    @DisplayName("Example 1 - Diagonal Islands")
    @Timeout(1)
    void testExample1() {

        int[][] grid = {
                {1, 0},
                {0, 1}
        };

        int expected = 3;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 2 - One Flip Connects All")
    @Timeout(1)
    void testExample2() {

        int[][] grid = {
                {1, 1},
                {1, 0}
        };

        int expected = 4;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 3 - Entire Grid Already Land")
    @Timeout(1)
    void testExample3() {

        int[][] grid = {
                {1, 1},
                {1, 1}
        };

        int expected = 4;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Single Cell Water")
    @Timeout(1)
    void testSingleCellWater() {

        int[][] grid = {
                {0}
        };

        int expected = 1;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Single Cell Land")
    @Timeout(1)
    void testSingleCellLand() {

        int[][] grid = {
                {1}
        };

        int expected = 1;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("All Water Grid")
    @Timeout(1)
    void testAllWaterGrid() {

        int[][] grid = {
                {0, 0},
                {0, 0}
        };

        int expected = 1;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Center Cell Connects Four Islands")
    @Timeout(1)
    void testCenterConnectsFourIslands() {

        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        int expected = 3;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Bridge Two Large Components")
    @Timeout(1)
    void testBridgeTwoComponents() {

        int[][] grid = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1}
        };

        int expected = 7;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Large Existing Island")
    @Timeout(1)
    void testLargeExistingIsland() {

        int[][] grid = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int expected = 9;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Multiple Zeros Around Island")
    @Timeout(1)
    void testMultipleZerosAroundIsland() {

        int[][] grid = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        int expected = 3;

        int result = solution.largestIsland(grid);

        assertEquals(expected, result);
    }
}