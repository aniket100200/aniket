package DSA.aniket.BinarySearch.Basics.SerachInRotatedSortedArray;

import DSA.aniket.BinarySearch.Basics.SerachInRotatedSortedArray.solutions.BrutzForce.BrutzForce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerachInRotatedSortedArrayTest {

    SerachInRotatedSortedArray solver = new BrutzForce();

    @Test
    @DisplayName("Should find target in a standard rotated array")
    void testStandardRotation() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        // 0 is at index 4
        assertEquals(4, solver.search(nums, target));
    }

    @Test
    @DisplayName("Should find target when rotation is at the very beginning")
    void testSmallRotation() {
        int[] nums = {2, 3, 4, 5, 6, 7, 1};
        assertEquals(0, solver.search(nums, 2));
        assertEquals(6, solver.search(nums, 1));
    }

    @Test
    @DisplayName("Should return -1 when target is not present")
    void testTargetMissing() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        assertEquals(-1, solver.search(nums, target));
    }

    @Test
    @DisplayName("Should handle an array that isn't actually rotated")
    void testNoRotation() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(0, solver.search(nums, 1));
        assertEquals(4, solver.search(nums, 5));
    }

    @Test
    @DisplayName("Should handle single element arrays")
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(0, solver.search(nums, 5));
        assertEquals(-1, solver.search(nums, 10));
    }

    @Test
    @DisplayName("Should handle empty arrays")
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(-1, solver.search(nums, 5));
    }

    @Test
    @DisplayName("Should find target when it is the pivot element")
    void testPivotSearch() {
        int[] nums = {5, 1, 2, 3, 4};
        assertEquals(0, solver.search(nums, 5));
        assertEquals(1, solver.search(nums, 1));
    }
}