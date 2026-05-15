package DSA.aniket.Arrays.RangeQueries.PrefixSum.MaximumSum.Solution;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.MaximumSum.MaximumSum;

import java.util.Arrays;

public class Solution implements MaximumSum {

    final int MOD = 1000000007;

    @Override
    public int maxSum(int[] A, int[][] ops) {
        int[] contribution = new int[A.length];
//        for (int[] op : ops) {
//            for (int i = op[0]; i <= op[1]; i++) {
//                contribution[i]++;
//            }
//        }

        /**
         * Above code is not Feasible
         */

        for (int[] op : ops) {
            contribution[op[0]]++;
            if (op[1] + 1 < A.length)
                contribution[op[1] + 1]--;
        }

        /**
         * now Apply Prefix Sum logic
         */

        for (int i = 1; i < A.length; i++)
            contribution[i] = contribution[i] + contribution[i - 1];

        Arrays.sort(contribution);
        Arrays.sort(A);

        long maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            maxSum = (maxSum % MOD + (contribution[i] * A[i]) % MOD) % MOD;
        }
        return (int) maxSum % MOD;
    }
}