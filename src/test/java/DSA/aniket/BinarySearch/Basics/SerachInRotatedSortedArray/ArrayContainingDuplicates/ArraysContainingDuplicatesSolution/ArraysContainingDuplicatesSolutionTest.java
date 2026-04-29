package DSA.aniket.BinarySearch.Basics.SerachInRotatedSortedArray.ArrayContainingDuplicates.ArraysContainingDuplicatesSolution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraysContainingDuplicatesSolutionTest {

    ArraysContainingDuplicatesSolution solver = new ArraysContainingDuplicatesSolution();

    @Test
    @DisplayName("Should find target in array with many duplicates")
    void testManyDuplicates() {
        int[] nums = {1, 0, 1, 1, 1};
        // The 0 is hidden by duplicates
        assertTrue(solver.search(nums, 0) != -1);
        assertTrue(solver.search(nums, 1) != -1);
    }

    @Test
    @DisplayName("Should return false when target is missing amongst duplicates")
    void testMissingWithDuplicates() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        assertFalse(solver.search(nums, 3) != -1);
    }

    @Test
    @DisplayName("Should handle the worst-case rotation (pivot at duplicates)")
    void testWorstCaseRotation() {
        int[] nums = {1, 1, 1, 1, 1, 2, 1};
        assertTrue(solver.search(nums, 2) != -1);
    }

    @Test
    @DisplayName("Should work with standard duplicate-heavy sorted array")
    void testStandardSortedDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        assertTrue(solver.search(nums, 2) != -1);
        assertFalse(solver.search(nums, 4) != -1);
    }

    @Test
    @DisplayName("Should handle single element with duplicates")
    void testSingleElement() {
        int[] nums = {1};
        assertTrue(solver.search(nums, 1) != -1);
        assertFalse(solver.search(nums, 0) != -1);
    }

    @Test
    @DisplayName("Should handle large gaps between duplicates")
    void testLargeGaps() {
        int[] nums = {10, 10, 10, 1, 10};
        assertTrue(solver.search(nums, 1) != -1);
        assertTrue(solver.search(nums, 10) != -1);
    }
}