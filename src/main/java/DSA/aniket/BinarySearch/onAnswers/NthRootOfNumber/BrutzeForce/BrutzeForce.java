package DSA.aniket.BinarySearch.onAnswers.NthRootOfNumber.BrutzeForce;

import DSA.aniket.BinarySearch.onAnswers.NthRootOfNumber.NthRootOfNumber;

public class BrutzeForce implements NthRootOfNumber {

    @Override
    public int nthRoot(int n, int m) {

        if (m <= 1) return m;

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int helperResponse = helper(n, mid, m);

            if (helperResponse == 1) return mid;

            else if (helperResponse == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     *
     * @param n
     * @param m
     * @param tar
     * @return case 1: when m^n = tar
     * case 2: when m^n > tar
     * case 0: when m^n < tar
     */
    public int helper(int n, int m, int tar) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= m;
            if (ans > tar) return 2;
        }

        if (ans == tar) return 1;

        return 0;
    }


}