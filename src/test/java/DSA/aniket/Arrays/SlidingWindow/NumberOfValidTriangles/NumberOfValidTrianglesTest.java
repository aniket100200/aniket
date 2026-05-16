package DSA.aniket.Arrays.SlidingWindow.NumberOfValidTriangles;

import DSA.aniket.Arrays.SlidingWindow.NumberOfValidTriangles.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidTrianglesTest {

    private final NumberOfValidTriangles solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {2, 2, 3, 4};

        // Expected: 3
        assertEquals(3, solution.validTriangles(nums), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] nums = {4, 2, 3, 4};

        // Expected: 4
        assertEquals(4, solution.validTriangles(nums), "Failed on Example 2.");
    }

    @Test
    public void testNotEnoughElements() {
        int[] nums = {2, 3};

        // Expected: 0
        assertEquals(0, solution.validTriangles(nums), "Failed when array has fewer than 3 elements.");
    }

    @Test
    public void testNoValidTriangles() {
        int[] nums = {1, 2, 3};

        // 1 + 2 is not > 3
        // Expected: 0
        assertEquals(0, solution.validTriangles(nums), "Failed on array where no valid triangles exist.");
    }

    @Test
    public void testAllZeroes() {
        int[] nums = {0, 0, 0};

        // A triangle cannot have side length 0. 0 + 0 > 0 is false.
        // Expected: 0
        assertEquals(0, solution.validTriangles(nums), "Failed on array with all zeroes.");
    }

    @Test
    public void testAllIdenticalElements() {
        int[] nums = {2, 2, 2, 2};

        // Expected combinations: 4 choose 3 = 4
        assertEquals(4, solution.validTriangles(nums), "Failed on array with all identical elements.");
    }

    @Test
    public void testArrayWithZeroesAndPositives() {
        int[] nums = {0, 1, 1, 1};

        // The 0 cannot be used. Only the three 1s can form a triangle (1+1>1).
        // Expected: 1
        assertEquals(1, solution.validTriangles(nums), "Failed to properly filter out zeroes.");
    }
}