package DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.OptimalApproach;

import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.SubArrayProductLessThanK;

public class OptimalApproach implements SubArrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * base case
         */
        if (k <= 1) return 0;
        int sp = 0, ep = 0;
        int count = 0;
        long product = 1;
        while (ep < nums.length) {
            /**
             * let's include the people
             */
            product *= nums[ep];
            /**
             * make a valid condition
             */
            while (product >= k) {
                product /= nums[sp];
                sp++;
            }

            /**
             * Calcuate the Answer
             */
            count += (ep - sp + 1);

            /**
             * include more people
             */
            ep++;
        }
        return count;
    }


}