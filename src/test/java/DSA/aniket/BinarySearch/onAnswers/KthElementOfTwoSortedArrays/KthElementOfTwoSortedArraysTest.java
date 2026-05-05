package DSA.aniket.BinarySearch.onAnswers.KthElementOfTwoSortedArrays;

import DSA.aniket.BinarySearch.onAnswers.KthElementOfTwoSortedArrays.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthElementTest {

    private final KthElementOfTwoSortedArrays solution = new OptimalSolution();

    @Test
    @DisplayName("Should find the K-th element in standard mixed arrays")
    void testStandardCase1() {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        assertEquals(6, solution.kthElement(a, b, 5));
    }

    @Test
    @DisplayName("Should find the K-th element when arrays are interleaved")
    void testStandardCase2() {
        int[] a = {1, 4, 8, 10, 12};
        int[] b = {5, 7, 11, 15, 17};
        assertEquals(10, solution.kthElement(a, b, 6));
    }

    @Test
    @DisplayName("Should work when K is 1 (the absolute minimum)")
    void testKIsOne() {
        int[] a = {2, 3, 4};
        int[] b = {1, 5, 6};
        assertEquals(1, solution.kthElement(a, b, 1));
    }

    @Test
    @DisplayName("Should work when K is the total length of both arrays (maximum)")
    void testKIsTotalLength() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        assertEquals(6, solution.kthElement(a, b, 6));
    }

    @Test
    @DisplayName("Should handle when all elements of array A are smaller than array B")
    void testSequentialArrays() {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        // K falls in array A
        assertEquals(3, solution.kthElement(a, b, 3));

        // K falls in array B
        assertEquals(6, solution.kthElement(a, b, 6));
    }

    @Test
    @DisplayName("Should handle when array A is much larger than array B")
    void testDifferentSizes() {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int[] b = {2, 4};
        assertEquals(4, solution.kthElement(a, b, 4));
        assertEquals(7, solution.kthElement(a, b, 6));
    }

    @Test
    @DisplayName("Should handle arrays with duplicate elements")
    void testDuplicates() {
        int[] a = {1, 1, 2, 2, 3};
        int[] b = {1, 2, 2, 4, 5};
        // Merged: 1, 1, 1, 2, 2, 2, 2, 3, 4, 5
        assertEquals(2, solution.kthElement(a, b, 6));
    }

    @Test
    @DisplayName("Should work when the target element requires picking 0 elements from the smaller array")
    void testZeroElementsFromA() {
        int[] a = {10, 20, 30};
        int[] b = {1, 2, 3, 4, 5};
        // To find the 2nd element, we must pick 0 from a and 2 from b.
        assertEquals(2, solution.kthElement(a, b, 2));
    }
}