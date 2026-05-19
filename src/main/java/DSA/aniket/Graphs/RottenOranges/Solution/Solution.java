package DSA.aniket.Graphs.RottenOranges.Solution;

import DSA.aniket.Graphs.RottenOranges.RottenOranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution implements RottenOranges {

    @Override
    public int orangesRotting(int[][] grid) {
        /**
         * 0-> Empty Cell
         * 1 -> Fresh Orange
         * 2 -> rotten Orange
         */

        Queue<Pair> que = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) que.add(new Pair(i, j));
            }
        }

        // if (que.size() == 0) return -1;
        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair p1 = que.poll();
                int i = p1.i;
                int j = p1.j;

                /**
                 * all the four Directions
                 */
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    que.add(new Pair(i + 1, j));
                    grid[i + 1][j] = 2;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    que.add(new Pair(i, j + 1));
                    grid[i][j + 1] = 2;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    que.add(new Pair(i - 1, j));
                    grid[i - 1][j] = 2;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    que.add(new Pair(i, j - 1));
                    grid[i][j - 1] = 2;
                }

            }
            level++;
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) if (grid[i][j] == 1) return -1;


        return level == 0 ? 0 : level - 1;


    }

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}