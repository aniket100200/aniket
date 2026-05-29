package DSA.aniket.Graphs.DijkstraAlgorithm.ShortestDistanceInBinaryMaze.Solution;

import DSA.aniket.Graphs.DijkstraAlgorithm.ShortestDistanceInBinaryMaze.ShortestDistanceInBinaryMaze;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution implements ShortestDistanceInBinaryMaze {

    /**
     * @param grid
     * @param source
     * @param destination
     * @return
     */
    @Override
    public int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (grid[source[0]][source[1]] == 0) return -1;
        /**
         * let's solve it using Dijkstra's Algorithm
         * but we'll be using Queue instead of PriorityQueue as graph is Unit weighted
         */
        int n = grid.length, m = grid[0].length;
        Queue<Pair> que = new ArrayDeque<>();

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[source[0]][source[1]] = 0;
        que.add(new Pair(0, new Coordinates(source[0], source[1])));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (que.size() > 0) {
            Pair rPair = que.poll();
            int currDist = rPair.dist;
            Coordinates node = rPair.coordinates;
            int x = node.x;
            int y = node.y;

            if (destination[0] == x && destination[1] == y) return currDist;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                boolean isXBounded = newX >= 0 && newX < n;
                boolean isYBounded = newY >= 0 && newY < m;
                boolean isNextValid = isXBounded && isYBounded && grid[newX][newY] == 1;
                boolean isNotVisitedBefore = isNextValid && currDist + 1 < dist[newX][newY];

                if (isNextValid && isNotVisitedBefore) {
                    dist[newX][newY] = currDist + 1;
                    que.add(new Pair(currDist + 1, new Coordinates(newX, newY)));
                }
            }


        }


        return -1;
    }


    class Coordinates {
        int x;
        int y;

        /**
         *
         * @param x
         * @param y
         */
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Pair {
        int dist;
        Coordinates coordinates;

        /**
         *
         * @param dist
         * @param coordinates
         */
        public Pair(int dist, Coordinates coordinates) {
            this.dist = dist;
            this.coordinates = coordinates;
        }

    }
}