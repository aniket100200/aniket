package DSA.aniket.Greedy.ShortestJobFirst.Solution;

import DSA.aniket.Greedy.ShortestJobFirst.ShortestJobFirst;

import java.util.Arrays;

public class Solution implements ShortestJobFirst {

    /**
     * @param bt
     * @return
     */
    @Override
    public int solve(int[] bt) {
        Arrays.sort(bt);
        long totalWaitingTime = 0;
        long time = 0;
        for (int i = 0; i < bt.length; i++) {
            totalWaitingTime += time;
            time += bt[i];
        }
        return (int) (totalWaitingTime / bt.length);
    }
}