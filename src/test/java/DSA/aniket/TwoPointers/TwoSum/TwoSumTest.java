package DSA.aniket.TwoPointers.TwoSum;

import DSA.aniket.TwoPointers.TwoSum.OnUnorderedArray.OnUnorderedArray;
import DSA.aniket.TwoPointers.TwoSum.onSortedArray.OnSortedArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumSortedTest {

    private final TwoSum solution = new OnUnorderedArray();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] A = {1, 2, 3, 4};
        int target = 6;

        int[] expected = {2, 4};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        int[] A = {-10, 1, 2, 5, 7};
        int target = 3;

        int[] expected = {2, 3};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on Example 2.");
    }

    @Test
    public void testOnlyTwoElements() {
        int[] A = {5, 9};
        int target = 14;

        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on array with exactly two elements.");
    }

    @Test
    public void testNegativeTarget() {
        int[] A = {-100, -50, -20, 0, 10};
        int target = -70;

        // -50 (index 2) + -20 (index 3) = -70
        int[] expected = {2, 3};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on negative target sum.");
    }

    @Test
    public void testZeroTarget() {
        int[] A = {-5, -2, 0, 2, 8};
        int target = 0;

        // -2 (index 2) + 2 (index 4) = 0
        int[] expected = {2, 4};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on zero target sum.");
    }

    @Test
    public void testLargeNumbers() {
        int[] A = {100000, 100000};
        int target = 200000;

        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on maximum constraint boundary.");
    }

    @Test
    @DisplayName("On Unsorted Array")
    public void testUnordered() {
        int[] A = {1, 5, 6, 4, 3, 19, 10};

        int target = 20;
        int[] expected = {1, 6};

        if (solution.getClass().getName().equals(OnSortedArray.class.getName())) {
            Arrays.sort(A);
            expected = new int[]{1, 7};
        }
        assertArrayEquals(expected, solution.twoSum(A, target), "Failed on maximum constraint boundary.");
    }
}