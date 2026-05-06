package DSA.aniket.BinarySearch.On2DArrays.search.SearchIn2DArray.BrutzForceSolution;

import DSA.aniket.BinarySearch.On2DArrays.search.SearchIn2DArray.SearchIn2DArray;

public class BrutzForceSolution implements SearchIn2DArray {

    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}