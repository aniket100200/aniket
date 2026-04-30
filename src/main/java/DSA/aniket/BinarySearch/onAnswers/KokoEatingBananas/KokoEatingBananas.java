package DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas;

public interface KokoEatingBananas {
    /**
     * Each hour, she chooses some pile of bananas and eats k bananas from
     * that pile. If the pile has less than k bananas, she eats all of
     * them instead and will not eat any more bananas during this hour.
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h);
}