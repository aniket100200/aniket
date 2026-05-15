package DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSubarraySum.Solution;

import DSA.aniket.Arrays.RangeQueries.kadanes.MaximumSubarraySum.MaximumSubarraySum;

public class Solution implements MaximumSubarraySum {

    @Override
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
            } else sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}