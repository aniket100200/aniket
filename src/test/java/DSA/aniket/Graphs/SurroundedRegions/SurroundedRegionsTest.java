package DSA.aniket.Graphs.SurroundedRegions;

import DSA.aniket.Graphs.SurroundedRegions.Solution.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SurroundedRegionsTest {


    private final SurroundedRegions solution = new Solution();

    // Helper method to compare 2D arrays deeply
    private boolean areMatricesEqual(char[][] expected, char[][] actual) {
        return Arrays.deepEquals(expected, actual);
    }

    // --- Tests ---

    @Test
    public void testExample1_StandardCase() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] expected = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solution.solve(board);
        assertTrue(areMatricesEqual(expected, board), "Failed on Example 1: Standard capturing.");
    }

    @Test
    public void testExample2_SingleCell() {
        char[][] board = {{'X'}};
        char[][] expected = {{'X'}};

        solution.solve(board);
        assertTrue(areMatricesEqual(expected, board), "Failed on single cell 'X'.");

        char[][] boardO = {{'O'}};
        char[][] expectedO = {{'O'}}; // Because it's on the border, it doesn't get captured.

        solution.solve(boardO);
        assertTrue(areMatricesEqual(expectedO, boardO), "Failed on single cell 'O'.");
    }

    @Test
    public void testAllOs() {
        char[][] board = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };

        // The middle 'O' is connected to the border 'O's, so NOTHING gets captured.
        char[][] expected = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };

        solution.solve(board);
        assertTrue(areMatricesEqual(expected, board), "Failed on board full of 'O's.");
    }

    @Test
    public void testNoOsToCapture() {
        char[][] board = {
                {'X', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'}
        };

        char[][] expected = {
                {'X', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'}
        };

        solution.solve(board);
        assertTrue(areMatricesEqual(expected, board), "Failed on board full of 'X's.");
    }

    @Test
    public void testComplexConnections() {
        char[][] board = {
                {'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        // The entire block of 'O's is connected to the 'O' at (0, 1), so none are captured.
        char[][] expected = {
                {'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        solution.solve(board);
        assertTrue(areMatricesEqual(expected, board), "Failed when a complex internal shape connects to the border.");
    }
}