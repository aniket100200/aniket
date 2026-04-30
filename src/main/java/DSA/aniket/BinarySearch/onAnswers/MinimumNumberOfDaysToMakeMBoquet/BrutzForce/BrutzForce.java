package DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet.BrutzForce;

import DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet.MinimumNumberOfDaysToMakeMBoquet;

public class BrutzForce implements MinimumNumberOfDaysToMakeMBoquet {

    @Override
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        /**
         * if no of flower are less than the number of flowers required
         * then it is Impossible to make `M` Bouquet
         */
        if (n < m * k) return -1;
        /**
         * this is greedy approach
         */
        int maxDayForAFlower = 0;
        for (int days : bloomDay) maxDayForAFlower = Math.max(maxDayForAFlower, days);
        //let's take out the range
        for (int i = 1; i <= maxDayForAFlower; i++) {
            if (isPossible(i, bloomDay, m, k)) {
                return i;
            }
        }
        return -1;
    }


}