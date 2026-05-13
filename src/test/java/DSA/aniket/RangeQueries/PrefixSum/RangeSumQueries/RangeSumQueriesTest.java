package DSA.aniket.RangeQueries.PrefixSum.RangeSumQueries;

import DSA.aniket.RangeQueries.PrefixSum.RangeSumQueries.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RangeSumQueryBatchTest {

    private final RangeSumQueries solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        int[][] ranges = {
                {0, 2},
                {2, 5},
                {0, 5}
        };

        int[] expected = {1, -1, -3};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on standard Example 1.");
    }

    @Test
    public void testExample2_AllPositiveNumbers() {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] ranges = {
                {0, 4},
                {1, 3},
                {4, 4}
        };

        int[] expected = {15, 9, 5};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on all positive numbers.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {42};
        int[][] ranges = {
                {0, 0},
                {0, 0}
        };

        int[] expected = {42, 42};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on a single element array.");
    }

    @Test
    public void testPointQueries() {
        // Queries where left == right
        int[] arr = {10, 20, 30, 40, 50};
        int[][] ranges = {
                {0, 0},
                {2, 2},
                {4, 4}
        };

        int[] expected = {10, 30, 50};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on point queries (left == right).");
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] arr = {-1, -2, -3, -4, -5};
        int[][] ranges = {
                {0, 4},
                {1, 3},
                {0, 0}
        };

        int[] expected = {-15, -9, -1};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on all negative numbers.");
    }

    @Test
    public void testZeroesAndNegatives() {
        int[] arr = {0, 0, -1, 0, -2, 0};
        int[][] ranges = {
                {0, 5},
                {0, 2},
                {3, 5}
        };

        int[] expected = {-3, -1, -2};
        int[] actual = solution.sumQuery(arr, ranges);

        assertArrayEquals(expected, actual, "Failed on array with zeroes and negative numbers.");
    }
}