package DSA.aniket.BinarySearch.Basics.SingleElementInSortedArray.SingleElementInSortedArrayImpl;

import DSA.aniket.BinarySearch.Basics.SingleElementInSortedArray.SingleElementInSortedArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleElementInSortedArrayImplTest {
    private final int NOT_FOUND = -1; // Adjust this to your method's specific 'null' return
    SingleElementInSortedArray solver = new SingleElementInSortedArrayImpl();

    @Test
    @DisplayName("1. Exact Match: Target exists")
    void testExactMatch() {
        int[] arr = {15};
        assertEquals(15, solver.singleNonDuplicate(arr), "Should return the value 15 when found.");
    }

    @Test
    @DisplayName("2. No Match: Target is smaller than element")
    void testTargetSmaller() {
        int[] arr = {15};
        assertEquals(15, solver.singleNonDuplicate(arr), "Should return sentinel if target < element.");
    }

    @Test
    @DisplayName("3. No Match: Target is larger than element")
    void testTargetLarger() {
        int[] arr = {15};
        assertEquals(15, solver.singleNonDuplicate(arr), "Should return sentinel if target > element.");
    }

    @Test
    @DisplayName("4. Zero Value: Target and element are 0")
    void testZeroValue() {
        int[] arr = {0};
        assertEquals(0, solver.singleNonDuplicate(arr), "Should correctly return 0 when it's the target.");
    }

    @Test
    @DisplayName("5. Negative Value: Target and element are negative")
    void testNegativeValue() {
        int[] arr = {-10};
        assertEquals(-10, solver.singleNonDuplicate(arr), "Should handle negative integers correctly.");
    }

    @Test
    @DisplayName("6. Boundary: Integer.MAX_VALUE")
    void testMaxValue() {
        int[] arr = {Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE, solver.singleNonDuplicate(arr));
    }

    @Test
    @DisplayName("7. Boundary: Integer.MIN_VALUE")
    void testMinValue() {
        int[] arr = {Integer.MIN_VALUE};
        assertEquals(Integer.MIN_VALUE, solver.singleNonDuplicate(arr));
    }
}