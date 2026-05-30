package DSA.aniket.Graphs.DijkstraAlgorithm.MinimumMultiplicationsToReachEnd.Solution;

import DSA.aniket.Graphs.DijkstraAlgorithm.MinimumMultiplicationsToReachEnd.MinimumMultiplicationsToReachEnd;
import DSA.aniket.Graphs.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution implements MinimumMultiplicationsToReachEnd {
    final int MOD = 100000;

    /**
     * @param arr
     * @param start
     * @param end
     * @return
     */
    @Override
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;
        start = start % MOD;
        end = end % MOD;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, start));
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;


        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rPair = que.poll();
                int currDist = rPair.getA();
                int node = rPair.getB();
                for (int i = 0; i < arr.length; i++) {
                    int neighbour = ((node % MOD) * (arr[i] % MOD)) % MOD;
                    if (currDist + 1 < dist[neighbour]) {
                        dist[neighbour] = currDist + 1;
                        if (neighbour == end) return currDist + 1;
                        que.add(new Pair(currDist + 1, neighbour));
                    }
                }
            }
        }

        return -1;
    }
}