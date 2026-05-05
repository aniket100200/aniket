package DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays.BetterSolution;

import DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays.MedianOfTwoSortedArrays;

public class BetterSolution implements MedianOfTwoSortedArrays {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int first = 0, last = 0;
        int countIndex = 0;

        int n = nums1.length;
        int m = nums2.length;

        int mid1 = (n + m) / 2;
        int mid2 = mid1 - 1;

        int val1 = -1;
        int val2 = -1;

        while (first < n && last < m) {
            if (nums1[first] <= nums2[last]) {
                if (countIndex == mid1) {
                    val1 = nums1[first];
                } else if (countIndex == mid2)
                    val2 = nums1[first];
                first++;
            } else {
                if (countIndex == mid1)
                    val1 = nums2[last];
                else if (countIndex == mid2)
                    val2 = nums2[last];

                last++;
            }
            countIndex++;
        }

        while (first < n) {
            if (countIndex == mid1) {
                val1 = nums1[first];
            } else if (countIndex == mid2)
                val2 = nums1[first];
            first++;

            countIndex++;
        }

        while (last < m) {
            if (countIndex == mid1)
                val1 = nums2[last];
            else if (countIndex == mid2)
                val2 = nums2[last];

            countIndex++;

            last++;
        }

        if ((n + m) % 2 == 1) return val1;
        return (val1 + val2) * 1.0 / 2;
    }
}