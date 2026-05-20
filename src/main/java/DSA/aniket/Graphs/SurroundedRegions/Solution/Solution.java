package DSA.aniket.Graphs.SurroundedRegions.Solution;

import DSA.aniket.Graphs.Pair;
import DSA.aniket.Graphs.SurroundedRegions.SurroundedRegions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution implements SurroundedRegions {

    @Override
    public void solve(char[][] board) {
        /**
         * let's traval on the boundries
         */

        Queue<Pair> que = new ArrayDeque<>();
        int n = board.length;
        int m = board[0].length;

        /**
         * mark connected region of Zero which are on the boundary 'S'
         */
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'S';
                que.add(new Pair(i, 0));
            }
            if (board[i][m - 1] == 'O') {
                board[i][m - 1] = 'S';
                que.add(new Pair(i, m - 1));
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'S';
                que.add(new Pair(0, j));
            }
            if (board[n - 1][j] == 'O') {
                board[n - 1][j] = 'S';
                que.add(new Pair(n - 1, j));
            }
        }

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int i = que.peek().getA();
                int j = que.peek().getB();
                que.poll();

                int[] dr = {0, 1, 0, -1};
                int[] dc = {-1, 0, 1, 0};
                for (int k = 0; k < 4; k++) {
                    int newI = i + dr[k];
                    int newJ = j + dc[k];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && board[newI][newJ] == 'O') {
                        /**
                         * mark it as `S`
                         */
                        board[newI][newJ] = 'S';
                        que.add(new Pair(newI, newJ));
                    }
                }

            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'S') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }


    }
}