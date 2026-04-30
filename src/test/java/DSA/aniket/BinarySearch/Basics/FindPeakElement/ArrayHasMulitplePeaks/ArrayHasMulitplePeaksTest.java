package DSA.aniket.BinarySearch.Basics.FindPeakElement.ArrayHasMulitplePeaks;

import DSA.aniket.BinarySearch.Basics.FindPeakElement.FindPeakElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayHasMulitplePeaksTest {

    FindPeakElement solver = new ArrayHasMulitplePeaks();

    /**
     * HELPER METHOD: Validates if the returned index is a true peak.
     * A peak is greater than its neighbors. Boundaries only check one neighbor.
     */
    private boolean isPeak(int[] arr, int index) {
        if (arr == null || arr.length == 0) return false;
        if (arr.length == 1) return index == 0;
        if (index < 0 || index >= arr.length) return false;

        boolean greaterThanLeft = (index == 0 || arr[index] > arr[index - 1]);
        boolean greaterThanRight = (index == arr.length - 1 || arr[index] > arr[index + 1]);

        return greaterThanLeft && greaterThanRight;
    }

    @Test
    @DisplayName("1. Standard multiple peaks separated by a valley")
    void testStandardMultiplePeaks() {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        // Peaks are at index 1 (val 2) and index 5 (val 6)
        int resultIndex = solver.findPeakElement(arr);

        assertTrue(isPeak(arr, resultIndex),
                "Result " + resultIndex + " is not a valid peak in the array.");
    }

    @Test
    @DisplayName("2. Wavy array (zig-zag pattern with many peaks)")
    void testWavyArray() {
        int[] arr = {1, 5, 2, 7, 3, 9, 4};
        // Peaks are at 1 (val 5), 3 (val 7), and 5 (val 9)
        int resultIndex = solver.findPeakElement(arr);

        assertTrue(isPeak(arr, resultIndex),
                "Should find one of the peaks in a zig-zag array.");
    }

    @Test
    @DisplayName("3. Peaks located at both the start and end boundaries")
    void testPeaksAtBoundaries() {
        int[] arr = {10, 2, 1, 4, 8};
        // Peaks are at index 0 (val 10) and index 4 (val 8)
        int resultIndex = solver.findPeakElement(arr);

        assertTrue(isPeak(arr, resultIndex),
                "Should successfully find a boundary peak.");
    }

    @Test
    @DisplayName("4. Large valley between two high peaks")
    void testLargeValley() {
        int[] arr = {20, 10, 5, 2, 1, 4, 15, 30};
        // Peaks are at index 0 (val 20) and index 7 (val 30)
        int resultIndex = solver.findPeakElement(arr);

        assertTrue(isPeak(arr, resultIndex));
    }

    @Test
    @DisplayName("5. Multiple peaks with negative numbers")
    void testNegativePeaks() {
        int[] arr = {-5, -1, -3, -2, -4};
        // Peaks are at index 1 (val -1) and index 3 (val -2)
        int resultIndex = solver.findPeakElement(arr);

        assertTrue(isPeak(arr, resultIndex));
    }

}