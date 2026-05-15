package DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.BrutzForce;

import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.SubArrayProductLessThanK;

public class BrutzForce implements SubArrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * Generate All the Subarrays
         */
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                /**
                 * i - j
                 */
                long prod = 1;
                for (int l = i; l <= j; l++) prod *= nums[l];

                if (prod < k) count++;

            }
        }

        return count;
    }
}