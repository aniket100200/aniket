package DSA.aniket.Arrays.RangeQueries.PrefixSum.MakeSumDivisibleByP;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.MakeSumDivisibleByP.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakeSumDivisibleByPTest {

    // The Solution implementation
    private final MakeSumDivisibleByP solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {3, 1, 4, 2};
        int p = 6;

        // Expected: 1 (remove the '4')
        assertEquals(1, solution.minSubarray(nums, p), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 2, 3};
        int p = 3;

        // Expected: 0 (1+2+3=6, already divisible by 3)
        assertEquals(0, solution.minSubarray(nums, p), "Failed on Example 2.");
    }

    @Test
    public void testRemoveWholeArrayNotAllowed() {
        int[] nums = {1, 2, 3};
        int p = 7;

        // Total sum is 6. We would need to remove a subarray of sum % 7 == 6.
        // The only way is to remove the whole array, which is forbidden.
        // Expected: -1
        assertEquals(-1, solution.minSubarray(nums, p), "Failed when removing the whole array is the only valid mathematical option.");
    }

    @Test
    public void testLargeNumbersAndOverflow() {
        // Elements can be up to 10^9, testing boundary conditions
        int[] nums = {1000000000, 1000000000, 1000000000};
        int p = 3;

        // Total sum is 3,000,000,000 which is divisible by 3.
        // Expected: 0
        assertEquals(0, solution.minSubarray(nums, p), "Failed on large numbers (Check for Integer Overflow in total sum).");
    }

    @Test
    public void testRemovePrefix() {
        int[] nums = {6, 3, 5, 2};
        int p = 9;

        // Total sum = 16. Target rem = 16 % 9 = 7.
        // Removing {5, 2} (length 2) leaves 9, which is divisible by 9.
        assertEquals(2, solution.minSubarray(nums, p), "Failed to find optimal suffix removal.");
    }

    @Test
    public void testImpossibleToMakeDivisible() {
        int[] nums = {1, 2};
        int p = 5;

        // Target rem = 3. No subarray sum matches this perfectly without clearing the board.
        // Expected: -1
        assertEquals(-1, solution.minSubarray(nums, p), "Failed when no valid subarray exists.");
    }
}