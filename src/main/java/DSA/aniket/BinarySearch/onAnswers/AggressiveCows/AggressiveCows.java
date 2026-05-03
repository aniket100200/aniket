package DSA.aniket.BinarySearch.onAnswers.AggressiveCows;

public interface AggressiveCows {
    int aggressiveCows(int[] stalls, int k);

    default boolean isPossible(int minDist, int[] stalls, int cows) {
        int cowCount = 1;
        int lastPlacedCow = 0;

        for (int i = 1; i < stalls.length; i++) {
            int distanceDiffrence = stalls[i] - stalls[lastPlacedCow];
            if (distanceDiffrence >= minDist) {
                cowCount++;
                lastPlacedCow = i;
            }
        }

        return cowCount >= cows;
    }
}