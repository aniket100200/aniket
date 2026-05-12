package DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray.ContainingDuplicates.ContainingDuplicatesSolution;

import DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray.MinimumInRotatedSortedArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainingDuplicatesUsingIterativeDFSTest {

    MinimumInRotatedSortedArray solution = new ContainingDuplicatesSolution();

    @Test
    @DisplayName("Example 1: Basic rotation with unique elements")
    void testExample1() {
        int[] nums = {1, 3, 5};
        assertEquals(1, solution.findMin(nums), "Should find 1 in [1,3,5]");
    }

    @Test
    @DisplayName("Example 2: Multiple duplicates with minimum in the middle")
    void testExample2() {
        int[] nums = {2, 2, 2, 0, 1};
        assertEquals(0, solution.findMin(nums), "Should find 0 in [2,2,2,0,1]");
    }

    @Test
    @DisplayName("Worst Case: nums[low] == nums[mid] == nums[high]")
    void testAmbiguousCase() {
        // This is the O(n) case where binary search needs to shrink linearly
        int[] nums = {1, 0, 1, 1, 1};
        assertEquals(0, solution.findMin(nums), "Should find 0 even when bookended by 1s");
    }

    @Test
    @DisplayName("Large number of duplicates at the end")
    void testDuplicatesAtEnd() {
        int[] nums = {10, 1, 10, 10, 10};
        assertEquals(1, solution.findMin(nums), "Should find 1 despite many duplicates");
    }

    @Test
    @DisplayName("Minimum is a duplicate value")
    void testMinIsDuplicate() {
        int[] nums = {3, 3, 1, 1, 3};
        assertEquals(1, solution.findMin(nums), "Should find 1 when the minimum itself is repeated");
    }

    @Test
    @DisplayName("All elements are the same")
    void testAllSame() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(2, solution.findMin(nums), "Should return the value when all elements are identical");
    }

    @Test
    @DisplayName("Two elements with duplicates")
    void testTwoElements() {
        int[] nums = {1, 1};
        assertEquals(1, solution.findMin(nums), "Should handle two identical elements");
    }

}