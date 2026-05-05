package DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1;

import DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RowWithMaximumOnesTest {

    private final RowWithMaximum1s solution = new OptimalSolution();

    @Test
    @DisplayName("Example 1: Tie breaker should pick the smallest row index")
    void testExample1() {
        int[][] mat = {
                {0, 1},
                {0, 1}
        };
        int[] expected = {0, 1};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Example 2: Should find the max row at the end")
    void testExample2() {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Example 3: Should find the max row in the middle")
    void testExample3() {
        int[][] mat = {
                {0, 0},
                {1, 1},
                {0, 0}
        };
        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Should handle a matrix with all zeros")
    void testAllZeros() {
        int[][] mat = {
                {0, 0},
                {0, 0},
                {0, 0}
        };
        // Should pick row 0 with 0 ones
        int[] expected = {0, 0};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Should handle a matrix with all ones")
    void testAllOnes() {
        int[][] mat = {
                {1, 1, 1},
                {1, 1, 1}
        };
        // Should pick row 0 with 3 ones
        int[] expected = {0, 3};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Should correctly tie-break between multiple rows with the same max ones")
    void testComplexTieBreaker() {
        int[][] mat = {
                {0, 1, 0}, // 1 one
                {1, 1, 1}, // 3 ones (Index 1)
                {0, 0, 0}, // 0 ones
                {1, 1, 1}  // 3 ones (Index 3)
        };
        int[] expected = {1, 3};
        assertArrayEquals(expected, solution.rowAndMaximumOnes(mat));
    }

    @Test
    @DisplayName("Should handle single element matrix")
    void testSingleElement() {
        int[][] mat1 = {{1}};
        assertArrayEquals(new int[]{0, 1}, solution.rowAndMaximumOnes(mat1));

        int[][] mat2 = {{0}};
        assertArrayEquals(new int[]{0, 0}, solution.rowAndMaximumOnes(mat2));
    }
}