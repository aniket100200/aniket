package DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.FindTheSquareRootOfNumber;

public class OptimalSolution implements FindTheSquareRootOfNumber {

    @Override
    public int findSquareRoot(int num) {

        if (num < 0) throw new IllegalArgumentException();
        int low = 1, high = num;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (mid == num / mid) return mid;

            if (mid > num / mid) high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }
}