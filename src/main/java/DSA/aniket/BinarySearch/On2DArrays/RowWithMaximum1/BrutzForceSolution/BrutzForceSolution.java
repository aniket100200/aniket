package DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1.BrutzForceSolution;

import DSA.aniket.BinarySearch.On2DArrays.RowWithMaximum1.RowWithMaximum1s;

public class BrutzForceSolution implements RowWithMaximum1s {

    @Override
    public int[] rowAndMaximumOnes(int[][] mat) {
        //traverse through all the rows..
        int row_index = 0;
        int count_1 = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                count += mat[i][j];
            }

            if (count > count_1) {
                count_1 = count;
                row_index = i;
            }
        }

        return new int[]{row_index, count_1};
    }
}