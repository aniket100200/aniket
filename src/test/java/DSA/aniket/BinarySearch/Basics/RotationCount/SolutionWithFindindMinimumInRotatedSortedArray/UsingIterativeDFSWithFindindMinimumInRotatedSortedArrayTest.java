package DSA.aniket.BinarySearch.Basics.RotationCount.SolutionWithFindindMinimumInRotatedSortedArray;

import DSA.aniket.BinarySearch.Basics.RotationCount.RotationCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsingIterativeDFSWithFindindMinimumInRotatedSortedArrayTest {

    RotationCount solution = new SolutionWithFindindMinimumInRotatedSortedArray();

    @Test
    @DisplayName("Example 1: Minimum is at index 2")
    void testExample1() {
        int[] arr = {15, 18, 2, 3, 6, 12};
        // Minimum is 2 at index 2
        assertEquals(2, solution.findKRotation(arr), "Should return 2 for [15, 18, 2, 3, 6, 12]");
    }

    @Test
    @DisplayName("Example 2: Minimum is at index 4")
    void testExample2() {
        int[] arr = {7, 9, 11, 12, 5};
        // Minimum is 5 at index 4
        assertEquals(4, solution.findKRotation(arr), "Should return 4 for [7, 9, 11, 12, 5]");
    }

    @Test
    @DisplayName("Example 3: Already sorted (0 rotations)")
    void testAlreadySorted() {
        int[] arr = {7, 9, 11, 12, 15};
        // Minimum is 7 at index 0
        assertEquals(0, solution.findKRotation(arr), "Should return 0 for an already sorted array");
    }

    @Test
    @DisplayName("Rotated once (n-1 rotations)")
    void testRotatedOnce() {
        int[] arr = {10, 2, 3, 4, 5, 6, 7, 8, 9};
        // Minimum is 2 at index 1
        assertEquals(1, solution.findKRotation(arr), "Should return 1 when rotated once");
    }

    @Test
    @DisplayName("Minimum at the very end")
    void testMinAtEnd() {
        int[] arr = {2, 3, 4, 5, 6, 1};
        // Minimum is 1 at index 5
        assertEquals(5, solution.findKRotation(arr), "Should return index of last element");
    }

    @Test
    @DisplayName("Single element array")
    void testSingleElement() {
        int[] arr = {5};
        assertEquals(0, solution.findKRotation(arr), "Single element means 0 rotations");
    }

    @Test
    @DisplayName("Two elements - swapped")
    void testTwoElementsSwapped() {
        int[] arr = {2, 1};
        assertEquals(1, solution.findKRotation(arr), "Should return index 1 for [2, 1]");
    }
}