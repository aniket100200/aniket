package DSA.aniket.BinarySearch.On2DArrays.SearchIn2DMatrixII.OptimalSolution;

import DSA.aniket.BinarySearch.On2DArrays.SearchIn2DMatrixII.SearchIn2DMatrixII;

public class OptimalSolution implements SearchIn2DMatrixII {

    @Override
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}