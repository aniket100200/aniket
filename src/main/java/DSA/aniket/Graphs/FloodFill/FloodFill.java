package DSA.aniket.Graphs.FloodFill;

import DSA.aniket.Graphs.Graph;

public interface FloodFill extends Graph {
    int[][] floodFill(int[][] image, int sr, int sc, int color);
}