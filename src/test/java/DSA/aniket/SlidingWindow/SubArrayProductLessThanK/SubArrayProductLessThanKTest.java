package DSA.aniket.SlidingWindow.SubArrayProductLessThanK;

import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.BetterSolution.BetterSolution;
import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.SubArrayProductLessThanK;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarrayProductLessThanKTest {

    private final SubArrayProductLessThanK solution = new BetterSolution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {10, 5, 2, 5};
        int k = 100;

        // Expected: 8
        assertEquals(8, solution.numSubarrayProductLessThanK(nums, k), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 2, 3};
        int k = 0;

        // Expected: 0
        assertEquals(0, solution.numSubarrayProductLessThanK(nums, k), "Failed on Example 2 (k = 0).");
    }

    @Test
    public void testKEqualsOne() {
        int[] nums = {1, 1, 1};
        int k = 1;

        // The product must be *strictly* less than 1. Since nums[i] >= 1, this is 0.
        // Expected: 0
        assertEquals(0, solution.numSubarrayProductLessThanK(nums, k), "Failed when k = 1.");
    }

    @Test
    public void testAllSubarraysValid() {
        int[] nums = {2, 2, 2};
        int k = 10;

        // Products:
        // Size 1: [2]=2, [2]=2, [2]=2 (all < 10) -> 3
        // Size 2: [2,2]=4, [2,2]=4 (all < 10) -> 2
        // Size 3: [2,2,2]=8 (all < 10) -> 1
        // Total = 6
        assertEquals(6, solution.numSubarrayProductLessThanK(nums, k), "Failed when all possible subarrays are valid.");
    }

    @Test
    public void testSingleElementValid() {
        int[] nums = {5};
        int k = 6;

        assertEquals(1, solution.numSubarrayProductLessThanK(nums, k), "Failed on single valid element array.");
    }

    @Test
    public void testSingleElementInvalid() {
        int[] nums = {5};
        int k = 5;

        assertEquals(0, solution.numSubarrayProductLessThanK(nums, k), "Failed on single invalid element array (must be strictly less).");
    }

    @Test
    public void ifNumbersAreGreaterThanK() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 1;

        assertEquals(0, solution.numSubarrayProductLessThanK(nums, k), "Failed on single invalid element array (must be strictly less).");

    }
}