package DSA.aniket.RangeQueries.PrefixSum.GridGame.Solution;

import DSA.aniket.RangeQueries.PrefixSum.GridGame.GridGame;

public class Solution implements GridGame {

    @Override
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        /**
         * Create Suffix and Prefix array as you'll be splitting it on some point
         */
        long[] suffix = new long[n];
        long[] prefix = new long[n];
        suffix[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i >= 0; i--) suffix[i] = grid[0][i] * 1L + suffix[i + 1] * 1L;
        prefix[0] = grid[1][0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] * 1L + grid[1][i] * 1L;
        long minPossible = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            /**
             * If A choose to go down from point `i`
             */

            long left = 0;
            if (i > 0) {
                left = prefix[i - 1];
            }

            long right = 0;
            if (i + 1 < n) {
                right = suffix[i + 1];
            }

            long maxBCanCollect = Math.max(left, right);
            minPossible = Math.min(minPossible, maxBCanCollect);
        }
        return minPossible;
    }
}