package DSA.aniket.Graphs.NumberOfIslands;

import DSA.aniket.Graphs.Graph;

public interface NumberOfIslands extends Graph {
    int numIslands(char[][] grid);

    default int countDistinctIslands(int[][] grid) {
        return 0;
    }
}