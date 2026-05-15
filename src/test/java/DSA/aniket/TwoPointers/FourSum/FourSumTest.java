package DSA.aniket.TwoPointers.FourSum;

import DSA.aniket.Arrays.TwoPointers.FourSum.FourSum;
import DSA.aniket.Arrays.TwoPointers.FourSum.solutions.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourSumTest {

    FourSum solution = new OptimalSolution();

    // Helper method to compare lists regardless of order
    private boolean areListsEqualIgnoreOrder(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) return false;
        return expected.containsAll(actual) && actual.containsAll(expected);
    }

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1)
        );

        List<List<Integer>> actual = solution.fourSum(nums, target);
        assertTrue(areListsEqualIgnoreOrder(expected, actual), "Failed on Example 1.");
    }

    @Test
    public void testExample2_AllDuplicates() {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 2, 2, 2)
        );

        List<List<Integer>> actual = solution.fourSum(nums, target);
        assertTrue(areListsEqualIgnoreOrder(expected, actual), "Failed on Example 2 with all duplicates.");
    }

    @Test
    public void testArrayTooSmall() {
        int[] nums = {1, -1, 0};
        int target = 0;

        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = solution.fourSum(nums, target);

        assertEquals(expected, actual, "Failed on array with length less than 4.");
    }

    @Test
    public void testIntegerOverflowPrevention() {
        // These numbers add up to a value larger than Integer.MAX_VALUE or Integer.MIN_VALUE
        // A naive `int sum` would overflow and potentially register a false positive/negative.
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296; // This is the exact overflowed int value of the sum

        List<List<Integer>> expected = new ArrayList<>(); // Should be empty because true sum is 4,000,000,000
        List<List<Integer>> actual = solution.fourSum(nums, target);

        assertEquals(expected, actual, "Failed on Integer Overflow. Ensure you are using 'long' for the sum.");
    }

    @Test
    public void testTargetNotPossible() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 100;

        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = solution.fourSum(nums, target);

        assertEquals(expected, actual, "Failed when the target cannot be reached.");
    }

    @Test
    public void testDuplicates() {
        int[] nums = new int[]{-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        List<List<Integer>> expected = List.of(List.of(-2, -1, 1, 2), List.of(-1, -1, 1, 1));
        List<List<Integer>> actual = solution.fourSum(nums, target);
        assertEquals(expected, actual, "Failed when the target cannot be reached.");
    }
}