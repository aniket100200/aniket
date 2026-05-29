package DSA.aniket.Graphs.DijkstraAlgorithm.PathWithMinimumEffort.Solution;

import DSA.aniket.Graphs.DijkstraAlgorithm.PathWithMinimumEffort.PathWithMinimumEffort;

import java.util.PriorityQueue;

public class Solution implements PathWithMinimumEffort {

    /**
     * @param heights
     * @return
     */
    @Override
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> {
            if (x.first == y.first) {
                if (x.second == y.second) {
                    return x.third - y.third;
                }
                return x.second - y.second;
            }
            return x.first - y.first;
        });

        pq.add(new Tuple(0, 0, 0));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (pq.size() > 0) {
            Tuple rTuple = pq.poll();
            int currDiff = rTuple.first;
            int x = rTuple.second;
            int y = rTuple.third;
            if (x == n - 1 && y == m - 1) return currDiff;
            int currVal = heights[x][y];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                boolean isBounded = newX >= 0 && newX < n && newY >= 0 && newY < m;
                if (isBounded) {
                    int newEffort = Math.max(Math.abs(heights[x][y] - heights[newX][newY]), currDiff);
                    if (newEffort < dist[newX][newY]) {
                        dist[newX][newY] = newEffort;
                        pq.add(new Tuple(newEffort, newX, newY));
                    }
                }
            }
        }
        return 0;
    }

}

class Tuple {
    int first;
    int second;
    int third;

    /**
     *
     * @param first  -> distance
     * @param second -> row
     * @param third  -> column
     */
    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}