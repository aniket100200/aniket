package DSA.aniket.RangeQueries.kadanes.MaximuSumOfRectangleNoLargerThanK.Solution;

import DSA.aniket.RangeQueries.kadanes.MaximuSumOfRectangleNoLargerThanK.MaximuSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

public class Solution implements MaximuSumOfRectangleNoLargerThanK {

    @Override
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] rows = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {
                for (int i = 0; i < matrix.length; i++) rows[i] += matrix[i][right];
                int currAns = maxSubArraySumAtMostK(rows, k);
                ans = Math.max(currAns, ans);
            }
        }
        return ans;
    }

    /**
     * this is the core logic for the Question
     *
     * @param arr
     * @param k
     * @return
     */
    public int maxSubArraySumAtMostK(int[] arr, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int maxi = Integer.MIN_VALUE;
        int pref = 0;
        for (int i = 0; i < arr.length; i++) {
            pref += arr[i];
            Integer closestToIdeal = ts.ceiling(pref - k);
            if (closestToIdeal != null) {
                int subArraySum = pref - closestToIdeal;
                maxi = Math.max(maxi, subArraySum);
            }

            ts.add(pref);

        }

        return maxi;
    }
}