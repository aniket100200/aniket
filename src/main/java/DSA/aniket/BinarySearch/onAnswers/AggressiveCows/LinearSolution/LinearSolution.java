package DSA.aniket.BinarySearch.onAnswers.AggressiveCows.LinearSolution;

import DSA.aniket.BinarySearch.onAnswers.AggressiveCows.AggressiveCows;

import java.util.Arrays;

public class LinearSolution implements AggressiveCows {

    @Override
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        //if cows are placed nearby
        int minDist = 1,
                /**
                 *  If cows are placed farthest
                 */
                maxDist = stalls[n - 1];

        for (int dist = maxDist; dist >= minDist; dist--) {

            if (isPossible(dist, stalls, k)) return dist;

        }
        return 0;
    }


}