package DSA.aniket.BinarySearch.On2DArrays.SearchIn2DArray;

import DSA.aniket.BinarySearch.On2DArrays.search.SearchIn2DArray.OptimalSolution.OptimalSolution;
import DSA.aniket.BinarySearch.On2DArrays.search.SearchIn2DArray.SearchIn2DArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Search2DMatrixTest {

    private final SearchIn2DArray solution = new OptimalSolution();

    @Test
    @DisplayName("Should find target in a standard matrix")
    void testTargetPresentStandard() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        assertTrue(solution.searchMatrix(matrix, 3));
        assertTrue(solution.searchMatrix(matrix, 16));
        assertTrue(solution.searchMatrix(matrix, 34));
    }

    @Test
    @DisplayName("Should return false when target is missing from standard matrix")
    void testTargetMissingStandard() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        assertFalse(solution.searchMatrix(matrix, 13));
        assertFalse(solution.searchMatrix(matrix, 22));
    }

    @Test
    @DisplayName("Should handle 1x1 matrix")
    void testSingleElement() {
        int[][] matrix = {{1}};
        assertTrue(solution.searchMatrix(matrix, 1));
        assertFalse(solution.searchMatrix(matrix, 0));
        assertFalse(solution.searchMatrix(matrix, 2));
    }

    @Test
    @DisplayName("Should handle single row matrix")
    void testSingleRow() {
        int[][] matrix = {{1, 3, 5, 7}};
        assertTrue(solution.searchMatrix(matrix, 3));
        assertFalse(solution.searchMatrix(matrix, 4));
    }

    @Test
    @DisplayName("Should handle single column matrix")
    void testSingleColumn() {
        int[][] matrix = {
                {1},
                {3},
                {5},
                {7}
        };
        assertTrue(solution.searchMatrix(matrix, 5));
        assertFalse(solution.searchMatrix(matrix, 2));
    }

    @Test
    @DisplayName("Should return false if target is smaller than the smallest element")
    void testTargetTooSmall() {
        int[][] matrix = {
                {10, 20},
                {30, 40}
        };
        assertFalse(solution.searchMatrix(matrix, 5));
    }

    @Test
    @DisplayName("Should return false if target is larger than the largest element")
    void testTargetTooLarge() {
        int[][] matrix = {
                {10, 20},
                {30, 40}
        };
        assertFalse(solution.searchMatrix(matrix, 50));
    }
}