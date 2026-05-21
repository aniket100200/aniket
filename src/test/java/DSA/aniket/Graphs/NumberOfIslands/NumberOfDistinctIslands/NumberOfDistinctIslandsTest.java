package DSA.aniket.Graphs.NumberOfIslands.NumberOfDistinctIslands;

import DSA.aniket.Graphs.NumberOfIslands.NumberOfIslands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDistinctIslandsTest {

    private final NumberOfIslands solution = new NumberOfDistinctIslands();

    @Test
    public void testExample1_TwoIdenticalSquares() {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        // Expected: 1 (Both are 2x2 squares)
        assertEquals(1, solution.countDistinctIslands(grid), "Failed on Example 1.");
    }

    @Test
    public void testExample2_MultipleShapes() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        // Expected: 3
        assertEquals(3, solution.countDistinctIslands(grid), "Failed on Example 2.");
    }

    @Test
    public void testAllWater() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        // Expected: 0
        assertEquals(0, solution.countDistinctIslands(grid), "Failed on all water grid.");
    }

    @Test
    public void testAllLand() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        // Expected: 1 (A single massive distinct island)
        assertEquals(1, solution.countDistinctIslands(grid), "Failed on all land grid.");
    }

    @Test
    public void testMirroredIslandsAreDistinct() {
        // An 'L' shape and a mirrored 'L' shape.
        // According to the prompt, they should be considered distinct.
        int[][] grid = {
                {1, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        // Expected: 2
        assertEquals(2, solution.countDistinctIslands(grid), "Failed to recognize mirrored shapes as distinct.");
    }

    @Test
    public void testSingleCells() {
        // 4 single-cell islands. All share the identical shape of 1 block.
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        // Expected: 1
        assertEquals(1, solution.countDistinctIslands(grid), "Failed on multiple identical single-cell islands.");
    }
}