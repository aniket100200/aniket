package DSA.aniket.BinarySearch.onAnswers.KthMissingNumber.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.KthMissingNumber.KthMissingNumber;

public class OptimalSolution implements KthMissingNumber {

    @Override
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // missingCountTillIndex = arr[index] - (index+1)
            int missingNumberTillCurrentIndex = arr[mid] - (mid + 1);
            if (missingNumberTillCurrentIndex < k) low = mid + 1;
            else high = mid - 1;
        }
        //see the README.md for the clarification
//        return low + k;

        return 1 + high + k;
    }
}