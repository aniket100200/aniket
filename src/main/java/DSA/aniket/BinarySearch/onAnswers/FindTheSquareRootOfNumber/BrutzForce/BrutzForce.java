package DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.BrutzForce;

import DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.FindTheSquareRootOfNumber;

public class BrutzForce implements FindTheSquareRootOfNumber {

    @Override
    public int findSquareRoot(int num) {

        if (num < 0) throw new IllegalArgumentException();
        if (num <= 1) return num;

        long low = 1, high = num;

        int pans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == num) return (int) mid;
            else if (mid * mid < num) {
                pans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pans;
    }
}