package DSA.aniket.RangeQueries.kadanes.MaximuSumOfRectangleNoLargerThanK;

import DSA.aniket.RangeQueries.kadanes.MaximuSumOfRectangleNoLargerThanK.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumSubmatrixTest {
    private final MaximuSumOfRectangleNoLargerThanK solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        int k = 2;

        // Expected: 2
        assertEquals(2, solution.maxSumSubmatrix(matrix, k), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[][] matrix = {
                {2, 2, -1}
        };
        int k = 3;

        // Expected: 3
        assertEquals(3, solution.maxSumSubmatrix(matrix, k), "Failed on Example 2.");
    }

    @Test
    public void testExactMatchNotPossible() {
        int[][] matrix = {
                {2, 2, -1}
        };
        int k = 0;

        // Rectangles: [2]=2, [2]=2, [-1]=-1, [2,2]=4, [2,-1]=1, [2,2,-1]=3
        // Max sum <= 0 is -1.
        assertEquals(-1, solution.maxSumSubmatrix(matrix, k), "Failed when exact match is not possible.");
    }

    @Test
    public void testAllNegativeMatrix() {
        int[][] matrix = {
                {-5, -2},
                {-3, -4}
        };
        int k = -2;

        // The single element [-2] is the max sum <= -2
        assertEquals(-2, solution.maxSumSubmatrix(matrix, k), "Failed on an all-negative matrix.");
    }

    @Test
    public void testSingleElementMatrix() {
        int[][] matrix = {
                {5}
        };

        assertEquals(5, solution.maxSumSubmatrix(matrix, 10), "Failed on single element matrix (k >= element).");
        assertEquals(5, solution.maxSumSubmatrix(matrix, 5), "Failed on single element matrix (k == element).");
    }

    @Test
    public void testLargeTargetK() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int k = 100000;

        // Sum of all elements is 45. Since 45 <= 100000, 45 should be returned.
        assertEquals(45, solution.maxSumSubmatrix(matrix, k), "Failed when k is much larger than the maximum possible sum.");
    }
}