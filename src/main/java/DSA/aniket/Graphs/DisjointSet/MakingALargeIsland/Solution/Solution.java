package DSA.aniket.Graphs.DisjointSet.MakingALargeIsland.Solution;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.MakingALargeIsland.MakingALargeIsland;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

import java.util.HashSet;

public class Solution implements MakingALargeIsland {

    /**
     * @param grid
     * @return
     */
    @Override
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int nodes = n * n;
        DisjointSet ds = new UnionBySize(nodes);
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                for (int indx = 0; indx < 4; indx++) {
                    int newRow = row + dr[indx];
                    int newCol = col + dc[indx];

                    boolean isValid = newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1;
                    if (isValid) {
                        int node = row * n + col;
                        int adjNode = newRow * n + newCol;
                        ds.union(node, adjNode);
                    }
                }
            }
        }

        //step 2
        int max = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int node = row * n + col;
                    max = Math.max(ds.getSize()[node], max);
                    continue;
                }
                HashSet<Integer> ultimateParentSet = new HashSet<>();
                for (int indx = 0; indx < 4; indx++) {
                    int newRow = row + dr[indx];
                    int newCol = col + dc[indx];

                    boolean isValid = newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1;
                    if (isValid) {
                        int adjNode = newRow * n + newCol;
                        ultimateParentSet.add(ds.findParent(adjNode));
                    }

                }

                int totalSize = 1;
                for (int parent : ultimateParentSet) {
                    totalSize += ds.getSize()[parent];
                }

                max = Math.max(totalSize, max);
            }
        }

        return max;
    }
}