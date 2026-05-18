package DSA.aniket.Graphs.NumberOfIslands.Solution;

import DSA.aniket.Graphs.NumberOfIslands.NumberOfIslands;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution implements NumberOfIslands {

    @Override
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && visited[i][j] != 1) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int[][] visited, int i, int j) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(i, j));
        int n = grid.length;
        int m = grid[0].length;
        while (que.size() > 0) {
            Pair rPair = que.poll();
            int a = rPair.a;
            int b = rPair.b;
            visited[a][b] = 1;
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int newRow = a + delRow;
                    int newCol = b + delCol;
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 'L' && visited[newRow][newCol] != 1) {
                        que.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}