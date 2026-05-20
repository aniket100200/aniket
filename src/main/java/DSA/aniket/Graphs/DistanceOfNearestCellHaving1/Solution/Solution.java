package DSA.aniket.Graphs.DistanceOfNearestCellHaving1.Solution;

import DSA.aniket.Graphs.DistanceOfNearestCellHaving1.DistanceOfNearestCellHaving1;
import DSA.aniket.Graphs.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution implements DistanceOfNearestCellHaving1 {

    @Override
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<Pair> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    que.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int i = que.peek().getA();
                int j = que.peek().getB();
                que.poll();

                ans[i][j] = level;
                int[] dr = {1, 0, -1, 0};
                int[] dc = {0, 1, 0, -1};
                for (int k = 0; k < 4; k++) {
                    int newI = i + dr[k];
                    int newJ = j + dc[k];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && visited[newI][newJ] == 0) {
                        que.add(new Pair(newI, newJ));
                        visited[newI][newJ] = 1;
                    }
                }
            }

            level++;
        }
        return ans;
    }
}