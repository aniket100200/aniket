package DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas.OptimalApproach;

import DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas.KokoEatingBananas;

public class OptimalApproach implements KokoEatingBananas {


    @Override
    public int minEatingSpeed(int[] piles, int h) {

        int maxSpeed = Integer.MIN_VALUE;
        int minSpeed = 1;
        //as it say's shell'be doing nothing when there will less bananas than `k`
        //so Maximum speed will be maxSize of the pile
        for (int pile : piles) maxSpeed = Math.max(maxSpeed, pile);
        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            if (isPossible(piles, midSpeed, h)) {
                maxSpeed = midSpeed - 1;
            } else minSpeed = midSpeed + 1;

        }
        return minSpeed;
    }

    /**
     *
     * @param piles
     * @param speed
     * @param h
     * @return
     */
    private boolean isPossible(int[] piles, int speed, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil(1.0 * pile / speed);
        }
        return totalHours <= h;
    }
}