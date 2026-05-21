package DSA.aniket.Graphs.NumberOfIslands.NumberOfDistinctIslands;

import DSA.aniket.Graphs.NumberOfIslands.NumberOfIslands;
import DSA.aniket.Graphs.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands implements NumberOfIslands {

    @Override
    public int numIslands(char[][] grid) {
        return 0;
    }


    public String bfs(int[][] grid, int i, int j) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(i, j));
        StringBuilder sb = new StringBuilder();
        sb.append("C00");
        grid[i][j] = 0;

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int ii = que.peek().getA();
                int jj = que.peek().getB();
                que.poll();
                int[] dc = {1, 0, -1, 0};
                int[] dr = {0, -1, 0, 1};
                for (int k = 0; k < 4; k++) {
                    int newI = ii + dr[k];
                    int newJ = jj + dc[k];
                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 0;
                        if (dr[k] == -1) {
                            sb.append("U");
                        } else if (dr[k] == 1) {
                            sb.append("D");
                        } else if (dc[k] == -1) {
                            sb.append("L");
                        } else if (dc[k] == 1) {
                            sb.append("R");
                        }

                        que.add(new Pair(newI, newJ));

                        sb.append("" + (newI - i) + (newJ - j));
                    }
                }
            }
        }

        return sb.toString();
    }


    @Override
    public int countDistinctIslands(int[][] grid) {
        Set<String> unique = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    unique.add(bfs(grid, i, j));
                }
            }
        }
        return unique.size();
    }
}