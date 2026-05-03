package DSA.aniket.BinarySearch.onAnswers.KthMissingNumber.BrutzeForceSolution;

import DSA.aniket.BinarySearch.onAnswers.KthMissingNumber.KthMissingNumber;

public class BrutzeForceSolution implements KthMissingNumber {

    @Override
    public int findKthPositive(int[] arr, int k) {
        //k might be answer if all the number before are missing
        //as it is sorted
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (i <= k) k++;
            else return k;
        }
        return -1;
    }
}