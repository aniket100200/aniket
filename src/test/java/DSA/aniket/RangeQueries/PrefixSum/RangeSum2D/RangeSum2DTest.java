package DSA.aniket.RangeQueries.PrefixSum.RangeSum2D;

import DSA.aniket.RangeQueries.PrefixSum.RangeSum2D.Solution.NumMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumQuery2DTest {

    @Test
    public void testExample1() {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3), "Sum of region (2,1) to (4,3) should be 8");
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2), "Sum of region (1,1) to (2,2) should be 11");
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4), "Sum of region (1,2) to (2,4) should be 12");
    }

    // --- Tests ---

    @Test
    public void testFullMatrixQuery() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        assertEquals(10, numMatrix.sumRegion(0, 0, 1, 1), "Sum of the entire matrix should be 10");
    }

    @Test
    public void testPointQuery() {
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        // Querying a single cell (row1 == row2, col1 == col2)
        assertEquals(10, numMatrix.sumRegion(0, 0, 0, 0));
        assertEquals(50, numMatrix.sumRegion(1, 1, 1, 1));
        assertEquals(90, numMatrix.sumRegion(2, 2, 2, 2));
    }

    @Test
    public void testSingleElementMatrix() {
        int[][] matrix = {
                {-42}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        assertEquals(-42, numMatrix.sumRegion(0, 0, 0, 0), "Sum of single element matrix should be -42");
    }

    @Test
    public void testSingleRowMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4, 5}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        assertEquals(15, numMatrix.sumRegion(0, 0, 0, 4), "Sum of entire row should be 15");
        assertEquals(9, numMatrix.sumRegion(0, 1, 0, 3), "Sum from col 1 to 3 should be 9");
    }

    @Test
    public void testSingleColumnMatrix() {
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        assertEquals(15, numMatrix.sumRegion(0, 0, 4, 0), "Sum of entire column should be 15");
        assertEquals(9, numMatrix.sumRegion(1, 0, 3, 0), "Sum from row 1 to 3 should be 9");
    }

    @Test
    public void testQueriesTouchingBorders() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        RangeSum2D numMatrix = new NumMatrix(matrix);

        // Touching top border
        assertEquals(6, numMatrix.sumRegion(0, 0, 1, 2));
        // Touching left border
        assertEquals(6, numMatrix.sumRegion(0, 0, 2, 1));
    }

}