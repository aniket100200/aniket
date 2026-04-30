package DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet.MinimumNumberOfDaysToMakeMBoquet;

public class OptimalSolution implements MinimumNumberOfDaysToMakeMBoquet {

    @Override
    public int minDays(int[] bloomDay, int m, int k) {

        //base condition
        //if there are m*k flowers then and only then you can create M bouquets

        int n = bloomDay.length;

        if (n < 1.0 * m * k) return -1; //it is not possible to make M boquet

        //let's see if evey flower blooms at day 1 it is not possible
        int minDays = Integer.MAX_VALUE; //due to opposite polarity it'll be pointing to the
        int maxDays = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            maxDays = Math.max(maxDays, day);
            minDays = Math.min(minDays, day);
        }

        while (minDays <= maxDays) {
            int midDays = minDays + (maxDays - minDays) / 2;

            if (isPossible(midDays, bloomDay, m, k)) {
                maxDays = midDays - 1;
            } else {
                minDays = midDays + 1;
            }
        }

        return minDays; //Remember due to opposite polarity
    }
}