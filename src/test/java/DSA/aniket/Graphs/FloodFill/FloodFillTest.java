package DSA.aniket.Graphs.FloodFill;

import DSA.aniket.Graphs.FloodFill.Solution.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloodFillTest {

    private final FloodFill solution = new Solution();

    // Helper method to compare 2D arrays deeply
    private boolean areMatricesEqual(int[][] expected, int[][] actual) {
        return Arrays.deepEquals(expected, actual);
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        int[][] expected = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };

        int[][] result = solution.floodFill(image, sr, sc, color);
        assertTrue(areMatricesEqual(expected, result), "Failed on Example 1.");
    }

    @Test
    public void testExample2_SameColor() {
        int[][] image = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int sr = 0, sc = 0, color = 0;

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] result = solution.floodFill(image, sr, sc, color);
        assertTrue(areMatricesEqual(expected, result), "Failed on Example 2 (infinite loop check).");
    }

    @Test
    public void testSinglePixelGrid() {
        int[][] image = {{5}};
        int sr = 0, sc = 0, color = 9;

        int[][] expected = {{9}};

        int[][] result = solution.floodFill(image, sr, sc, color);
        assertTrue(areMatricesEqual(expected, result), "Failed on a 1x1 grid.");
    }

    @Test
    public void testDisconnectedRegions() {
        int[][] image = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 3;

        // Only the center 1 should change, because diagonals don't count
        int[][] expected = {
                {1, 0, 1},
                {0, 3, 0},
                {1, 0, 1}
        };

        int[][] result = solution.floodFill(image, sr, sc, color);
        assertTrue(areMatricesEqual(expected, result), "Failed to ignore disconnected (diagonal) regions.");
    }

    @Test
    public void testFillEntireGrid() {
        int[][] image = {
                {4, 4, 4},
                {4, 4, 4},
                {4, 4, 4}
        };
        int sr = 2, sc = 2, color = 7;

        int[][] expected = {
                {7, 7, 7},
                {7, 7, 7},
                {7, 7, 7}
        };

        int[][] result = solution.floodFill(image, sr, sc, color);
        assertTrue(areMatricesEqual(expected, result), "Failed to fill the entire uniform grid.");
    }
}