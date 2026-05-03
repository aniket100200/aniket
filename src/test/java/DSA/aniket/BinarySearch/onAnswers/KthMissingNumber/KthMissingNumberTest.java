package DSA.aniket.BinarySearch.onAnswers.KthMissingNumber;

import DSA.aniket.BinarySearch.onAnswers.KthMissingNumber.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Kth Missing Positive Number - Test Suite")
class KthMissingNumberTest {

    // Replace 'YourClass.findKthPositive' with your actual method.
    // Assuming signature: public static int findKthPositive(int[] arr, int k)

    KthMissingNumber solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1 (Missing numbers scattered)")
    void testExample1() {
        int[] arr = {2, 3, 4, 7, 11};
        assertEquals(9, solver.findKthPositive(arr, 5),
                "Should correctly identify the 5th missing number among scattered gaps.");
    }

    @Test
    @DisplayName("2. Missing numbers AFTER the array: Example 2")
    void testMissingAfterArray() {
        int[] arr = {1, 2, 3, 4};
        // The array is perfect, no missing numbers inside it.
        // We need the 2nd missing number after the array ends (4 + 2 = 6).
        assertEquals(6, solver.findKthPositive(arr, 2),
                "Should append K to the end of the array if no numbers are missing inside.");
    }

    @Test
    @DisplayName("3. BOUNDARY TRAP: Missing numbers BEFORE the array")
    void testMissingBeforeArray() {
        int[] arr = {5, 6, 7, 8, 9};
        // The missing numbers are 1, 2, 3, 4. The 2nd missing is 2.
        assertEquals(2, solver.findKthPositive(arr, 2),
                "If K is smaller than the first element minus 1, the answer is just K.");
    }

    @Test
    @DisplayName("4. Single Element Array: Missing before")
    void testSingleElementMissingBefore() {
        int[] arr = {4};
        assertEquals(1, solver.findKthPositive(arr, 1),
                "Should handle a size-1 array where the missing number precedes the element.");
    }

    @Test
    @DisplayName("5. Single Element Array: Missing after")
    void testSingleElementMissingAfter() {
        int[] arr = {2};
        assertEquals(4, solver.findKthPositive(arr, 3),
                "Should handle a size-1 array where the missing number follows the element.");
    }

    @Test
    @DisplayName("6. Missing number is exactly the first gap")
    void testMissingExactlyAtStart() {
        int[] arr = {2, 3, 4};
        // The missing number is 1.
        assertEquals(1, solver.findKthPositive(arr, 1),
                "Should accurately return 1 when the array starts at 2.");
    }

    @Test
    @DisplayName("7. Massive Gaps (Large array values)")
    void testMassiveGaps() {
        int[] arr = {100, 200, 300};
        assertEquals(5, solver.findKthPositive(arr, 5),
                "Should work efficiently even when gaps between numbers are large.");
    }

    @Test
    @DisplayName("8. Extreme Constraints (Max K)")
    void testExtremeK() {
        int[] arr = {1, 2, 3};
        int k = 1000;
        assertEquals(1003, solver.findKthPositive(arr, k),
                "Should handle the upper constraint limit safely.");
    }
}