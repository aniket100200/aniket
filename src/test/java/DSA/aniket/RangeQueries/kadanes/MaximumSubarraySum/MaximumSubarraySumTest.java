package DSA.aniket.RangeQueries.kadanes.MaximumSubarraySum;

import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSubarraySum.MaximumSubarraySum;
import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSubarraySum.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarraySumTest {

    private final MaximumSubarraySum solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4, -10};

        // Expected: 10
        assertEquals(10, solution.maxSubArray(nums), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {2, -1, 0, 1, 2, 1};

        // Expected: 5
        assertEquals(5, solution.maxSubArray(nums), "Failed on Example 2.");
    }

    @Test
    public void testAllNegativeNumbers() {
        // If all numbers are negative, the max subarray is just the largest single negative number.
        // A common bug in Kadane's is returning 0 instead of -1 here.
        int[] nums = {-5, -2, -9, -1, -3};

        // Expected: -1
        assertEquals(-1, solution.maxSubArray(nums), "Failed on an array with all negative numbers.");
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {42};

        // Expected: 42
        assertEquals(42, solution.maxSubArray(nums), "Failed on a single element array.");
    }

    @Test
    public void testSingleNegativeElement() {
        int[] nums = {-42};

        // Expected: -42
        assertEquals(-42, solution.maxSubArray(nums), "Failed on a single negative element array.");
    }

    @Test
    public void testAlternatingPositivesAndNegatives() {
        int[] nums = {4, -1, 2, -7, 3, 4};

        // Subarray [4, -1, 2] = 5. Subarray [3, 4] = 7. Max is 7.
        // Expected: 7
        assertEquals(7, solution.maxSubArray(nums), "Failed on alternating positive and negative numbers.");
    }
}