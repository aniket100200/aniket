package DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays.BrutzForceSolution;

import DSA.aniket.BinarySearch.onAnswers.MedianOfTwoSortedArrays.MedianOfTwoSortedArrays;

public class BrutzForceSolution implements MedianOfTwoSortedArrays {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge Two Sorted Arrays
        int[] arr = mergeTwoSortedArrays(nums1, nums2);
        int n = arr.length;

        if ((n) % 2 == 1) return arr[n / 2];
        return (arr[n / 2] + arr[n / 2 - 1]) * 1.0 / 2;
    }

    public int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n + m];

        int first = 0, second = 0, i = 0;

        while (first < n && second < m) {
            if (nums1[first] <= nums2[second]) {
                ans[i++] = nums1[first++];
            } else ans[i++] = nums2[second++];
        }

        while (first < n) {
            ans[i++] = nums1[first++];
        }
        while (second < m) {
            ans[i++] = nums2[second++];
        }

        return ans;
    }
}