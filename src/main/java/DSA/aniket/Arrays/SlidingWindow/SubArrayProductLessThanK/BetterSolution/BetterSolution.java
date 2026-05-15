package DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.BetterSolution;

import DSA.aniket.Arrays.SlidingWindow.SubArrayProductLessThanK.SubArrayProductLessThanK;

public class BetterSolution implements SubArrayProductLessThanK {

    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod < k) count++;
                else break;
            }
        }

        return count;
    }
}