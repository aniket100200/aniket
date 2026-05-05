package DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1.OptimalSolution;

import DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1.RowWithMaximum1s;

public class OptimalSolution implements RowWithMaximum1s {

    @Override
    public int[] rowAndMaximumOnes(int[][] mat) {
        /**
         * we'll be using Binary Search to count the number of ones'
         */

        int row_index = 0;
        int ans_count = 0;

        for (int row = 0; row < mat.length; row++) {
            int lb = lowerBound(mat, 1, row);
            int n = mat[row].length;

            if (lb < n) {
                int totalCount = n - lb;
                if (totalCount > ans_count) {
                    row_index = row;
                    ans_count = totalCount;
                }

            }
        }
        return new int[]{row_index, ans_count};
    }

    /**
     * It'll give the point where val>= tar
     * i.e. the first value where the above condition satisfy
     *
     * @param mat
     * @param tar
     * @param row
     * @return
     */
    public int lowerBound(int[][] mat, int tar, int row) {
        int low = 0, high = mat[row].length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (mat[row][mid] >= tar) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}