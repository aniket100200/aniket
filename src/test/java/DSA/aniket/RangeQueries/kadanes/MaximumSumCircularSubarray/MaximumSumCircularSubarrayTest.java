package DSA.aniket.RangeQueries.kadanes.MaximumSumCircularSubarray;

import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSumCircularSubarray.MaximumSumCircularSubarray;
import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSumCircularSubarray.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSumCircularArrayTest {


    private final MaximumSumCircularSubarray solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_StandardMax() {
        int[] arr = {1, -2, 3, -2};

        // Max is just the single element [3]
        // Expected: 3
        assertEquals(3, solution.maxSum(arr), "Failed on Example 1.");
    }

    @Test
    public void testExample2_CircularMax() {
        int[] arr = {1, -3, 1};

        // Max wraps around: 1 (index 2) + 1 (index 0) = 2
        // Expected: 2
        assertEquals(2, solution.maxSum(arr), "Failed on Example 2 (Circular Wrap).");
    }

    @Test
    public void testLargerCircularWrap() {
        int[] arr = {5, -3, 5};

        // Max wraps around: 5 + 5 = 10
        // Expected: 10
        assertEquals(10, solution.maxSum(arr), "Failed on larger wrap-around scenario.");
    }

    @Test
    public void testAllNegativeNumbers() {
        // EDGE CASE: If all numbers are negative, Total Sum == Min Sum.
        // Total - Min = 0. But the subarray CANNOT be empty.
        // The answer should just be the largest single negative number.
        int[] arr = {-5, -2, -9, -1, -3};

        // Expected: -1
        assertEquals(-1, solution.maxSum(arr), "Failed on all-negative array. Handle the total_sum == min_sum edge case!");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {42};

        // Expected: 42
        assertEquals(42, solution.maxSum(arr), "Failed on a single element array.");
    }

    @Test
    public void testSingleNegativeElement() {
        int[] arr = {-42};

        // Expected: -42
        assertEquals(-42, solution.maxSum(arr), "Failed on a single negative element array.");
    }

    @Test
    public void testAllPositiveNumbers() {
        int[] arr = {1, 2, 3, 4, 5};

        // Max is the sum of the entire array: 1+2+3+4+5 = 15
        // Expected: 15
        assertEquals(15, solution.maxSum(arr), "Failed on all-positive array.");
    }
}