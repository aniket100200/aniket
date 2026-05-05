package DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays;

import DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTwoSortedArraysTest {

    private final MedianOfTwoSortedArrays solution = new OptimalSolution();

    @Test
    @DisplayName("Should calculate median for odd total length")
    void testOddTotalLength() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should calculate median for even total length")
    void testEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should handle when the first array is empty")
    void testFirstArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should handle when the second array is empty")
    void testSecondArrayEmpty() {
        int[] nums1 = {2, 4};
        int[] nums2 = {};
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should calculate median when elements overlap completely")
    void testOverlappingElements() {
        int[] nums1 = {1, 5, 8, 10, 18, 20};
        int[] nums2 = {2, 3, 6, 7};
        // Merged: 1, 2, 3, 5, 6, 7, 8, 10, 18, 20
        // Median: (6 + 7) / 2 = 6.5
        assertEquals(6.5, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should calculate median when all elements of nums1 are smaller than nums2")
    void testSequentialArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6, 7};
        assertEquals(4.0, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should calculate median with negative numbers")
    void testNegativeNumbers() {
        int[] nums1 = {-5, 3, 6, 12, 15};
        int[] nums2 = {-12, -10, -6, -3, 4, 10};
        // Merged: -12, -10, -6, -5, -3, 3, 4, 6, 10, 12, 15
        // Median is the 6th element: 3
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }

    @Test
    @DisplayName("Should handle single element arrays")
    void testSingleElements() {
        int[] nums1 = {2};
        int[] nums2 = {3};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.00001);
    }
}