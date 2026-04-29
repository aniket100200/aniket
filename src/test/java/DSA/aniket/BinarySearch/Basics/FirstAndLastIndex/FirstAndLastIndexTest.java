package DSA.aniket.BinarySearch.Basics.FirstAndLastIndex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FirstAndLastIndexTest {

    FirstAndLastIndex solution = new FirstAndLastIndexImpl();

    @Test
    @DisplayName("Should find range when target appears multiple times")
    void testStandardCase() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        assertArrayEquals(expected, solution.searchRange(nums, target));
    }

    @Test
    @DisplayName("Should return [-1, -1] when target is not in the array")
    void testTargetNotFound() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, solution.searchRange(nums, target));
    }

    @Test
    @DisplayName("Should handle an empty array")
    void testEmptyArray() {
        int[] nums = {};
        int target = 0;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, solution.searchRange(nums, target));
    }

    @Test
    @DisplayName("Should work when target is the only element in the array")
    void testSingleElementFound() {
        int[] nums = {5};
        int target = 5;
        int[] expected = {0, 0};
        assertArrayEquals(expected, solution.searchRange(nums, target));
    }

    @Test
    @DisplayName("Should work when all elements are the target")
    void testAllElementsSame() {
        int[] nums = {8, 8, 8, 8, 8};
        int target = 8;
        int[] expected = {0, 4};
        assertArrayEquals(expected, solution.searchRange(nums, target));
    }

    @Test
    @DisplayName("Should find target at the very boundaries of the array")
    void testBoundaries() {
        int[] nums = {1, 2, 3};
        // Test Start
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(nums, 1));
        // Test End
        assertArrayEquals(new int[]{2, 2}, solution.searchRange(nums, 3));
    }
}