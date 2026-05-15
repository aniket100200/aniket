package DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSumCircularSubarray.Solution;

import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSumCircularSubarray.MaximumSumCircularSubarray;

public class Solution implements MaximumSumCircularSubarray {

    @Override
    public long maxSum(int[] arr) {
        long total = 0;
        long maximumSumSubarray = Integer.MIN_VALUE;
        long minimumSumSubarray = Integer.MAX_VALUE;

        long trainMax = 0;
        long trainMin = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            /*total*/
            total += arr[i];

            /*for maximumSubarray Sum*/
            long maxPrev = trainMax + arr[i];
            long maxNew = arr[i];

            trainMax = Math.max(maxNew, maxPrev);

            maximumSumSubarray = Math.max(trainMax, maximumSumSubarray);

            /*For Minimum Subarray Sum*/
            long minPrev = trainMin + arr[i];
            long minNew = arr[i];
            trainMin = Math.min(minPrev, minNew);

            minimumSumSubarray = Math.min(minimumSumSubarray, trainMin);
        }

        if (total == minimumSumSubarray) return maximumSumSubarray;

        long itself = maximumSumSubarray;
        long wrapAround = total - minimumSumSubarray;

        return Math.max(itself, wrapAround);

    }

}