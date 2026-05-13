package DSA.aniket.RangeQueries.PrefixSum.RangeSum2D.Solution;

import DSA.aniket.RangeQueries.PrefixSum.RangeSum2D.RangeSum2D;

public class NumMatrix implements RangeSum2D {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length][matrix[0].length];
        prefixSum(matrix);
        /**
         * Now Prefix Sum is Ready
         */
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /**
         * we have to give it based on the region
         */
        //A-B-C+D
        //let's calcuate the answer

        int A = prefix[row2][col2];
        int B = col1 == 0 ? 0 : prefix[row2][col1 - 1];
        int C = row1 == 0 ? 0 : prefix[row1 - 1][col2];
        int D = row1 == 0 || col1 == 0 ? 0 : prefix[row1 - 1][col1 - 1];
        return A - B - C + D;
    }

    public void prefixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;


        prefix[0][0] = matrix[0][0];


        /**
         * for the First Row
         */
        for (int j = 1; j < m; j++) {
            prefix[0][j] = matrix[0][j] + prefix[0][j - 1];
        }
        /**
         * for the first column
         */
        for (int i = 1; i < n; i++) {
            prefix[i][0] = matrix[i][0] + prefix[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int A = matrix[i][j];
                int B = prefix[i][j - 1];
                int C = prefix[i - 1][j];
                int D = prefix[i - 1][j - 1];

                prefix[i][j] = A + B + C - D;
            }
        }
    }
}