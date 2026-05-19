package DSA.aniket.Graphs.FloodFill.Solution;

import DSA.aniket.Graphs.FloodFill.FloodFill;

public class Solution implements FloodFill {

    @Override
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        /**
         * we'll be using DFS
         */

        dfs(image, sr, sc, color, visited);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int[][] visited) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (visited[sr][sc] == 1) return;
        int currColour = image[sr][sc];
        visited[sr][sc] = 1;
        image[sr][sc] = color;
        /**
         * move on all the four directions
         * UP
         * */
        int newI = sr - 1;
        int newJ = sc;
        if (newI >= 0 && visited[newI][newJ] != 1 && image[newI][newJ] == currColour) {
            dfs(image, newI, newJ, color, visited);
        }

        /**
         * down
         */
        newI = sr + 1;
        if (newI < image.length && visited[newI][newJ] != 1 && image[newI][newJ] == currColour) {
            dfs(image, newI, newJ, color, visited);
        }

        /**
         * left
         */
        newI = sr;
        newJ = sc - 1;

        if (newJ >= 0 && visited[newI][newJ] != 1 && image[newI][newJ] == currColour) {
            dfs(image, newI, newJ, color, visited);
        }
        /**
         * right
         */
        newJ = sc + 1;
        if (newJ < image[0].length && visited[newI][newJ] != 1 && image[newI][newJ] == currColour) {
            dfs(image, newI, newJ, color, visited);
        }

    }
}