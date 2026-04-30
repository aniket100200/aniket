package DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas.BrutzForceSolution;

import DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas.KokoEatingBananas;

public class BrutzForceSolution implements KokoEatingBananas {
    /**
     *
     * @param piles
     * @param h
     * @return we'll start from the speed of 1 to Integer.MAX_VALUE
     */
    @Override
    public int minEatingSpeed(int[] piles, int h) {
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (isPossible(i, piles, h)) return i;
        }
        return -1;
    }

    public boolean isPossible(int rate, int[] piles, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil(1.0 * pile / rate);
        }

        return totalHours <= h;
    }
}