package DSA.aniket.Arrays.RangeQueries.PrefixSum.carPooling.Solution;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.carPooling.CarPooling;

public class Solution implements CarPooling {

    @Override
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pref = new int[1000 + 1];

        /**
         * Create Step Prefix Array
         */
        for (int[] trip : trips) {
            pref[trip[1]] += trip[0];
            pref[trip[2]] -= trip[0];
        }

        /**
         * Create Prefix Array
         */

        if (pref[0] > capacity) return false;

        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i] + pref[i - 1];
            if (pref[i] > capacity) return false;
        }


        return true;
    }
}