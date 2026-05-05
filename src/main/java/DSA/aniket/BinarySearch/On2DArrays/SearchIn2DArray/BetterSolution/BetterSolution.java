package DSA.aniket.BinarySearch.On2DArrays.SearchIn2DArray.BetterSolution;

import DSA.aniket.BinarySearch.On2DArrays.SearchIn2DArray.SearchIn2DArray;

public class BetterSolution implements SearchIn2DArray {

    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;

                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}