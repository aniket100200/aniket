package DSA.aniket.BinarySearch.Basics.FindPeakElement.ArrayHashOnePeak;

import DSA.aniket.BinarySearch.Basics.FindPeakElement.FindPeakElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayHashOnePeakTest {

    private final FindPeakElement solver = new ArrayHashOnePeak();

    @Test
    @DisplayName("1. Peak is somewhere in the middle (Standard Case)")
    void testPeakInMiddle() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        // The peak is 12, which is at index 3
        assertEquals(3, solver.findPeakElement(arr), "Should find the peak in the middle of the array.");
    }

    @Test
    @DisplayName("2. Peak is the very first element (Strictly Decreasing Array)")
    void testPeakAtStart() {
        int[] arr = {20, 15, 10, 5, 1};
        // The peak is 20, which is at index 0
        assertEquals(0, solver.findPeakElement(arr), "Should return index 0 when the array is strictly decreasing.");
    }

    @Test
    @DisplayName("3. Peak is the very last element (Strictly Increasing Array)")
    void testPeakAtEnd() {
        int[] arr = {1, 5, 10, 15, 20};
        // The peak is 20, which is at index 4
        assertEquals(4, solver.findPeakElement(arr), "Should return the last index when the array is strictly increasing.");
    }

    @Test
    @DisplayName("4. Single element array")
    void testSingleElement() {
        int[] arr = {42};
        // A single element is technically the peak of its array
        assertEquals(0, solver.findPeakElement(arr), "Should return index 0 for a single-element array.");
    }

    @Test
    @DisplayName("5. Two elements - Peak is the first element")
    void testTwoElementsPeakFirst() {
        int[] arr = {9, 3};
        assertEquals(0, solver.findPeakElement(arr), "Should handle size-2 arrays where the first element is the peak.");
    }

    @Test
    @DisplayName("6. Two elements - Peak is the second element")
    void testTwoElementsPeakSecond() {
        int[] arr = {3, 9};
        assertEquals(1, solver.findPeakElement(arr), "Should handle size-2 arrays where the second element is the peak.");
    }

    @Test
    @DisplayName("7. Array with negative numbers")
    void testNegativeNumbers() {
        int[] arr = {-10, -5, -2, -8, -12};
        // The peak is -2, which is at index 2
        assertEquals(2, solver.findPeakElement(arr), "Should correctly identify the peak among negative numbers.");
    }

    @Test
    @DisplayName("8. Steep peak (sharp difference between neighbors)")
    void testSteepPeak() {
        int[] arr = {1, 2, 100, 3, 1};
        // The peak is 100, which is at index 2
        assertEquals(2, solver.findPeakElement(arr), "Should find the peak even with drastic value changes.");
    }

}