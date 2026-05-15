package DSA.aniket.Arrays.SlidingWindow.MaximumConsecutiveOnes;

import DSA.aniket.Arrays.SlidingWindow.MaximumConsecutiveOnes.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesTest {

    // The Solution implementation


    private final MaximumConsecutiveOnes solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        // Expected: 6
        assertEquals(6, solution.longestOnes(nums, k), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {0, 0, 0, 1};
        int k = 4;

        // Expected: 4
        assertEquals(4, solution.longestOnes(nums, k), "Failed on Example 2 (k >= total zeros).");
    }

    @Test
    public void testZeroFlipsAllowed() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int k = 0;

        // Expected: 3 (the sequence of three 1s at the end)
        assertEquals(3, solution.longestOnes(nums, k), "Failed when k = 0.");
    }

    @Test
    public void testAllOnes() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 2;

        // Expected: 5
        assertEquals(5, solution.longestOnes(nums, k), "Failed on an array of all 1s.");
    }

    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 3;

        // Expected: 3
        assertEquals(3, solution.longestOnes(nums, k), "Failed on an array of all 0s.");
    }

    @Test
    public void testLargeK() {
        int[] nums = {1, 0, 1, 0};
        int k = 100;

        // k is much larger than the array size
        // Expected: 4
        assertEquals(4, solution.longestOnes(nums, k), "Failed when k is larger than the array length.");
    }
}