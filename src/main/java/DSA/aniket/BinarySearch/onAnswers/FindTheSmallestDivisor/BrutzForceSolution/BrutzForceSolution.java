package DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.BrutzForceSolution;

import DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.FindTheSmallestDivisor;

public class BrutzForceSolution implements FindTheSmallestDivisor {

    @Override
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;

        for (int n : nums) high = Math.max(high, n);


        for (int divisor = low; divisor <= high; divisor++) {
            if (isPossible(divisor, nums, threshold)) {
                return divisor;
            }
        }
        return -1;
    }
}