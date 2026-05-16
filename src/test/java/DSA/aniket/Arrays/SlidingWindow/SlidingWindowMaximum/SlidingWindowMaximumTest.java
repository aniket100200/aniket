package DSA.aniket.Arrays.SlidingWindow.SlidingWindowMaximum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {

    private final SlidingWindowMaximum solution = new SlidingWindowMaximum();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {1};
        int k = 1;

        int[] expected = {1};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed on single element array.");
    }

    @Test
    public void testDecreasingArray() {
        int[] nums = {5, 4, 3, 2, 1};
        int k = 2;

        // Window maxes should just be the left element of each window
        int[] expected = {5, 4, 3, 2};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed on strictly decreasing array.");
    }

    @Test
    public void testIncreasingArray() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        // Window maxes should just be the right element of each window
        int[] expected = {2, 3, 4, 5};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed on strictly increasing array.");
    }

    @Test
    public void testAllSameElements() {
        int[] nums = {7, 7, 7, 7, 7};
        int k = 3;

        int[] expected = {7, 7, 7};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed on array with all identical elements.");
    }

    @Test
    public void testWindowSizeEqualsArrayLength() {
        int[] nums = {1, -5, 8, 2, 4};
        int k = 5;

        // Output should just be a single element representing the max of the whole array
        int[] expected = {8};
        assertArrayEquals(expected, solution.SlidingWindowMaximum(nums.length, k, nums), "Failed when k equals array length.");
    }
}