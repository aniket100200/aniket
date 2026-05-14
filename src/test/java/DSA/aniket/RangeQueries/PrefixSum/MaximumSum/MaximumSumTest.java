package DSA.aniket.RangeQueries.PrefixSum.MaximumSum;

import DSA.aniket.RangeQueries.PrefixSum.MaximumSum.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaximumSumTest {


    private final MaximumSum solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] A = {2, 1, 3, 5, 4};
        int[][] ops = {
                {0, 1},
                {1, 2}
        };

        // Expected: 17
        assertEquals(17, solution.maxSum(A, ops), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] A = {2, 3, 5, 4};
        int[][] ops = {
                {0, 1},
                {1, 3}
        };

        // Expected: 19
        assertEquals(19, solution.maxSum(A, ops), "Failed on Example 2.");
    }

    @Test
    public void testSingleElementArray() {
        int[] A = {42};
        int[][] ops = {
                {0, 0},
                {0, 0},
                {0, 0}
        };

        // Expected: 42 * 3 = 126
        assertEquals(126, solution.maxSum(A, ops), "Failed on single element array with multiple queries.");
    }

    @Test
    public void testNonOverlappingQueries() {
        int[] A = {1, 2, 3, 4, 5};
        int[][] ops = {
                {0, 0},
                {2, 2},
                {4, 4}
        };

        // Frequencies: indices 0, 2, 4 are queried once.
        // We should map the highest numbers (5, 4, 3) to these indices.
        // Total sum = 5 + 4 + 3 = 12
        assertEquals(12, solution.maxSum(A, ops), "Failed on non-overlapping point queries.");
    }

    @Test
    public void testAllElementsQueriedSameAmount() {
        int[] A = {10, 20, 30};
        int[][] ops = {
                {0, 2}, // Query all elements
                {0, 2}  // Query all elements again
        };

        // Sum of all elements = 60. Queried twice = 120. Order doesn't matter.
        assertEquals(120, solution.maxSum(A, ops), "Failed when all elements are queried equally.");
    }

    @Test
    public void testLargeNumbersModulo() {
        // This test ensures the modulo 1000000007 logic is applied correctly
        int[] A = new int[10000];
        for (int i = 0; i < 10000; i++) {
            A[i] = 10000; // Max constraint value
        }

        int[][] ops = new int[10000][2];
        for (int i = 0; i < 10000; i++) {
            ops[i] = new int[]{0, 9999}; // Query the entire array 10,000 times
        }

        // Total raw sum = 10,000 (elements) * 10,000 (value) * 10,000 (queries) = 1,000,000,000,000
        // 1,000,000,000,000 % 1000000007 = 999993007
        assertEquals(999993007, solution.maxSum(A, ops), "Failed to apply modulo 10^9+7 correctly.");
    }
}