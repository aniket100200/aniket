package DSA.aniket.BinarySearch.onAnswers.AggressiveCows.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.AggressiveCows.AggressiveCows;

import java.util.Arrays;

public class OptimalSolution implements AggressiveCows {

    @Override
    public int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int minDist = 1, maxDist = stalls[n - 1] - stalls[0];

        /**
         *  as minDist is pointing to the possible state
         *  and maxDist is pointing to the Impossible state
         *  so at last of BS maxDist Will be pointing to your answer
         */

        while (minDist <= maxDist) {
            int midDist = minDist + (maxDist - minDist) / 2;

            if (isPossible(midDist, stalls, k)) {
                minDist = midDist + 1;
            } else maxDist = midDist - 1;
        }
        return maxDist;
    }
}