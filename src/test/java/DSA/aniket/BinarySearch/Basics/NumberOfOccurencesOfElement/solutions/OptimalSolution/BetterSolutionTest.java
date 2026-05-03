package DSA.aniket.BinarySearch.Basics.NumberOfOccurencesOfElement.solutions.OptimalSolution;

import DSA.aniket.BinarySearch.Basics.NumberOfOccurencesOfElement.NumberOfOccurencesOfElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterSolutionTest {

    NumberOfOccurencesOfElement solver = new OptimalSolution();

    @Test
    @DisplayName("Should count multiple occurrences of the target")
    void testMultipleOccurrences() {
        int[] nums = {1, 2, 4, 4, 4, 5, 6};
        int target = 4;
        // Indices of 4 are 2, 3, 4. Total = 3
        assertEquals(3, solver.countOccurrences(nums, target));
    }

    @Test
    @DisplayName("Should return 0 when target is not present")
    void testTargetMissing() {
        int[] nums = {1, 2, 3, 5, 6};
        int target = 4;
        assertEquals(0, solver.countOccurrences(nums, target));
    }

    @Test
    @DisplayName("Should return 0 for an empty array")
    void testEmptyArray() {
        int[] nums = {};
        int target = 10;
        assertEquals(0, solver.countOccurrences(nums, target));
    }

    @Test
    @DisplayName("Should count correctly when all elements are the target")
    void testAllElementsSame() {
        int[] nums = {7, 7, 7, 7, 7};
        int target = 7;
        assertEquals(5, solver.countOccurrences(nums, target));
    }

    @Test
    @DisplayName("Should count correctly at the start and end of the array")
    void testBoundaries() {
        int[] nums = {1, 1, 2, 3, 5, 5};

        // Start of array
        assertEquals(2, solver.countOccurrences(nums, 1));

        // End of array
        assertEquals(2, solver.countOccurrences(nums, 5));
    }

    @Test
    @DisplayName("Should return 1 for a single element array if it matches")
    void testSingleElementMatch() {
        int[] nums = {10};
        assertEquals(1, solver.countOccurrences(nums, 10));
        assertEquals(0, solver.countOccurrences(nums, 5));
    }
}