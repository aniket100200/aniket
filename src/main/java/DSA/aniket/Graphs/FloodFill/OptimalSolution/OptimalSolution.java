package DSA.aniket.Graphs.FloodFill.OptimalSolution;

import DSA.aniket.Graphs.FloodFill.FloodFill;

public class OptimalSolution implements FloodFill {

    @Override
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return image;
        int currColor = image[sr][sc];
        if (currColor == color) return image;
        image[sr][sc] = color;

        if (sr + 1 < image.length && currColor == image[sr + 1][sc])
            floodFill(image, sr + 1, sc, color);
        if (sr - 1 >= 0 && currColor == image[sr - 1][sc])
            floodFill(image, sr - 1, sc, color);

        if (sc + 1 < image[0].length && currColor == image[sr][sc + 1])
            floodFill(image, sr, sc + 1, color);
        if (sc - 1 >= 0 && currColor == image[sr][sc - 1])
            floodFill(image, sr, sc - 1, color);
        return image;
    }
}