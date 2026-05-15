package DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.OptimalApproach;

import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.SubArrayProductLessThanK;

public class OptimalApproach implements SubArrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * check if every element is greater than or equal it it
         */

        if (!isValid(nums, k))
            return 0;
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
            while (sp < ep && product >= k) {
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

    boolean isValid(int[] arr, int k) {
        for (int i : arr) {
            if (i < k) return true;
        }

        return false;
    }
}