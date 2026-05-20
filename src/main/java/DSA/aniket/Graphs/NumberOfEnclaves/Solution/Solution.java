package DSA.aniket.Graphs.NumberOfEnclaves.Solution;

import DSA.aniket.Graphs.NumberOfEnclaves.NumberOfEnclaves;

public class Solution implements NumberOfEnclaves {

    public void dfs(int sr, int sc, int[][] grid) {
        grid[sr][sc] = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            int newI = sr + dr[i];
            int newJ = sc + dc[i];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1)
                dfs(newI, newJ, grid);
        }
    }

    @Override
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            /**
             * first col
             */
            if (grid[i][0] == 1) dfs(i, 0, grid);
            /**
             * last col
             */
            if (grid[i][m - 1] == 1) dfs(i, m - 1, grid);
        }

        for (int j = 0; j < m; j++) {
            /**
             * first row
             */

            if (grid[0][j] == 1) dfs(0, j, grid);
            /**
             * last row
             */
            if (grid[n - 1][j] == 1) dfs(n - 1, j, grid);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
}