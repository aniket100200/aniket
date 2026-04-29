package DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray;

import DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray.BrutzeForce.BrutzeForce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumInRotatedSortedArrayTest {

    MinimumInRotatedSortedArray solution = new BrutzeForce();

    @Test
    @DisplayName("Example 1: Minimum is in the middle-right")
    void testExample1() {
        int[] nums = {3, 4, 5, 1, 2};
        assertEquals(1, solution.findMin(nums), "Should find 1 in [3,4,5,1,2]");
    }

    @Test
    @DisplayName("Example 2: Minimum is at a larger offset")
    void testExample2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, solution.findMin(nums), "Should find 0 in [4,5,6,7,0,1,2]");
    }

    @Test
    @DisplayName("Example 3: Array is rotated n times (already sorted)")
    void testExample3() {
        int[] nums = {11, 13, 15, 17};
        assertEquals(11, solution.findMin(nums), "Should find 11 in [11,13,15,17]");
    }

    @Test
    @DisplayName("Single element array")
    void testSingleElement() {
        int[] nums = {1};
        assertEquals(1, solution.findMin(nums), "Should return the only element");
    }

    @Test
    @DisplayName("Two elements - rotated")
    void testTwoElementsRotated() {
        int[] nums = {2, 1};
        assertEquals(1, solution.findMin(nums), "Should find 1 in [2,1]");
    }

    @Test
    @DisplayName("Two elements - not rotated")
    void testTwoElementsSorted() {
        int[] nums = {1, 2};
        assertEquals(1, solution.findMin(nums), "Should find 1 in [1,2]");
    }

    @Test
    @DisplayName("Minimum is the last element")
    void testMinAtEnd() {
        int[] nums = {2, 3, 4, 5, 1};
        assertEquals(1, solution.findMin(nums), "Should find 1 at the end of the array");
    }
}