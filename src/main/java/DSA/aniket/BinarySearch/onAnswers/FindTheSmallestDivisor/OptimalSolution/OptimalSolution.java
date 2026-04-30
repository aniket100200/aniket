package DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.FindTheSmallestDivisor;

public class OptimalSolution implements FindTheSmallestDivisor {

    @Override
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums == null || nums.length == 0) return -1;
        int low = 1, high = nums[0];
        for (int num : nums) high = Math.max(high, num);
        /**
         * low is pointing to the divisor where answer is not possible with the givent threasold
         * at last it'll be pointing to the answer
         */

        while (low <= high) {
            int divisor = low + (high - low) / 2;

            if (isPossible(divisor, nums, threshold))
                high = divisor - 1;
            else
                low = divisor + 1;

        }
        return low; //due to opposite polarity
    }
}