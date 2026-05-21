package DSA.aniket.Graphs.NumberOfIslands;

public interface NumberOfIslands {
    int numIslands(char[][] grid);

    default int countDistinctIslands(int[][] grid) {
        return 0;
    }
}