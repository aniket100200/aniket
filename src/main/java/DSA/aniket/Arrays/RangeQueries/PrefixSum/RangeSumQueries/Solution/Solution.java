package DSA.aniket.Arrays.RangeQueries.PrefixSum.RangeSumQueries.Solution;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.RangeSumQueries.RangeSumQueries;

public class Solution implements RangeSumQueries {

    @Override
    public int[] sumQuery(int[] arr, int[][] ranges) {
        /**
         * let's use the power of Prefix Sum
         */
        int n = arr.length;
        int[] pre = new int[n];
        for (int i = 1; i < arr.length; i++) {

            pre[i] = pre[i] + pre[i - 1];
        }
        int[] ans = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int si = range[0];
            int ei = range[1];

            if (si == 0) ans[i] = pre[ei];
            else ans[i] = pre[ei] - pre[si - 1];
        }

        return ans;
    }
}