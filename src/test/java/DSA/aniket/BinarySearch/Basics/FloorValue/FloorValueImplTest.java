package DSA.aniket.BinarySearch.Basics.FloorValue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FloorValueImplTest {

    int[] arr = {10, 20, 30, 40, 50};
    FloorValue floorValue = new FloorValueImpl();

    @Test
    void findFloorFor20() {
        assertEquals(20, floorValue.findFloorValue(arr, 20));
    }

    @Test
    void findFloorFor15() {
        assertEquals(10, floorValue.findFloorValue(arr, 15));
    }

    @Test
    void findFloorFor0() {
        assertEquals(-1, floorValue.findFloorValue(arr, 0));
    }

    // --- 1. The "Happy Path" (Standard Cases) ---

    @Test
    public void testTargetIsBetweenTwoNumbers() {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        assertEquals(2, floorValue.findFloorValue(arr, 5), "Floor of 5 should be 2");
    }

    @Test
    public void testTargetIsExactlyEqual() {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        assertEquals(8, floorValue.findFloorValue(arr, 8), "Floor of 8 should be 8");
    }

    // --- 2. Out of Bounds (Boundary Cases) ---

    @Test
    public void testTargetSmallerThanSmallest() {
        int[] arr = {5, 6, 8, 9};
        assertEquals(-1, floorValue.findFloorValue(arr, 4), "Should return -1 when target is too small");
    }

    @Test
    public void testTargetLargerThanLargest() {
        int[] arr = {1, 2, 3, 5, 7};
        assertEquals(7, floorValue.findFloorValue(arr, 10), "Should return last element when target is too large");
    }

    // --- 3. Array Size Edge Cases ---

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, floorValue.findFloorValue(arr, 5), "Should safely handle empty arrays");
    }

    @Test
    public void testSingleElementTargetSmaller() {
        int[] arr = {5};
        assertEquals(-1, floorValue.findFloorValue(arr, 4), "Should return -1 for single element if target is smaller");
    }

    @Test
    public void testSingleElementTargetLarger() {
        int[] arr = {5};
        assertEquals(5, floorValue.findFloorValue(arr, 6), "Should return the element for single element if target is larger");
    }

    // --- 4. Duplicates and Negatives ---

    @Test
    public void testDuplicatesTargetBetween() {
        int[] arr = {2, 2, 4, 4, 4, 8, 9};
        assertEquals(4, floorValue.findFloorValue(arr, 5), "Should return 4, stepping over the duplicates");
    }

    @Test
    public void testDuplicatesTargetMatches() {
        int[] arr = {2, 2, 4, 4, 4, 8, 9};
        assertEquals(4, floorValue.findFloorValue(arr, 4), "Should return 4 when target matches duplicated value");
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-10, -5, -2, 0, 3};
        assertEquals(-5, floorValue.findFloorValue(arr, -3), "Floor of -3 is -5, because -5 <= -3");
    }

    @Test
    public void testAllNegativesTargetSmaller() {
        int[] arr = {-100, -50, -20};
        assertEquals(-1, floorValue.findFloorValue(arr, -150), "Should handle out of bounds with negative numbers");
    }

}