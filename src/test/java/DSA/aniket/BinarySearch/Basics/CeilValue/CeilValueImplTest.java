package DSA.aniket.BinarySearch.Basics.CeilValue;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class CeilValueImplTest {
    // --- 1. The "Happy Path" (Standard Cases) ---

    CeilValue ceilValue = new CeilValueImpl();

    @Test
    public void testTargetIsBetweenTwoNumbers() {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        assertEquals(8, ceilValue.findCeil(arr, 5), "Ceiling of 5 should be 8");
    }

    @Test
    public void testTargetIsExactlyEqual() {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        assertEquals(8, ceilValue.findCeil(arr, 8), "Ceiling of 8 should be 8");
    }

    // --- 2. Out of Bounds (Boundary Cases) ---

    @Test
    public void testTargetSmallerThanSmallest() {
        int[] arr = {5, 6, 8, 9};
        assertEquals(5, ceilValue.findCeil(arr, 4), "Should return the first element when target is smaller than all elements");
    }

    @Test
    public void testTargetLargerThanLargest() {
        int[] arr = {1, 2, 3, 5, 7};
        assertEquals(-1, ceilValue.findCeil(arr, 10), "Should return -1 when target is larger than all elements (No ceiling)");
    }

    // --- 3. Array Size Edge Cases ---

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, ceilValue.findCeil(arr, 5), "Should safely handle empty arrays");
    }

    @Test
    public void testSingleElementTargetSmaller() {
        int[] arr = {5};
        assertEquals(5, ceilValue.findCeil(arr, 4), "Should return the element for single element if target is smaller");
    }

    @Test
    public void testSingleElementTargetLarger() {
        int[] arr = {5};
        assertEquals(-1, ceilValue.findCeil(arr, 6), "Should return -1 for single element if target is larger");
    }

    // --- 4. Duplicates and Negatives ---

    @Test
    public void testDuplicatesTargetBetween() {
        int[] arr = {2, 2, 4, 4, 4, 8, 9};
        assertEquals(8, ceilValue.findCeil(arr, 5), "Should return 8, stepping over the smaller duplicates");
    }

    @Test
    public void testDuplicatesTargetMatches() {
        int[] arr = {2, 2, 4, 4, 4, 8, 9};
        assertEquals(4, ceilValue.findCeil(arr, 4), "Should return 4 when target matches duplicated value");
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-10, -5, -2, 0, 3};
        assertEquals(-2, ceilValue.findCeil(arr, -3), "Ceiling of -3 is -2, because -2 >= -3");
    }

    @Test
    public void testAllNegativesTargetLarger() {
        int[] arr = {-100, -50, -20};
        assertEquals(-1, ceilValue.findCeil(arr, 10), "Should handle out of bounds with negative numbers when target is positive");
    }

    // --- 5. Large Inputs (Performance Testing) ---

    @Test
    public void testLargeInputPerformance() {
        // Generate an array of 1,000,000 elements
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1; // Array: [1, 2, 3 ... 1000000]
        }

        // Ensure the operation completes in under 10 milliseconds
        assertTimeout(Duration.ofMillis(10), () -> {
            int result = ceilValue.findCeil(arr, 1);
            assertEquals(1, result);
        }, "Algorithm should be O(log n) and not time out on large datasets");
    }
}