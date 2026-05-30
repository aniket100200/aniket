package DSA.aniket.Graphs.DijkstraAlgorithm.PathWithMinimumEffort;

import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.PathWithMinimumEffort.PathWithMinimumEffort;
import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.PathWithMinimumEffort.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathWithMinimumEffortTest {

    private final PathWithMinimumEffort solution = new Solution();

    @Test
    @DisplayName("Should return minimum effort for sample case 1")
    @Timeout(1)
    void testExample1() {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return minimum effort for sample case 2")
    @Timeout(1)
    void testExample2() {

        int[][] heights = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("Should return zero effort when flat path exists")
    @Timeout(1)
    void testExample3() {

        int[][] heights = {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should handle single cell grid")
    @Timeout(1)
    void testSingleCell() {

        int[][] heights = {
                {10}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should handle uniform height grid")
    @Timeout(1)
    void testUniformGrid() {

        int[][] heights = {
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should choose path with smaller maximum difference")
    @Timeout(1)
    void testOptimalPathSelection() {

        int[][] heights = {
                {1, 10, 6},
                {1, 3, 2},
                {7, 8, 2}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should handle larger grid correctly")
    @Timeout(1)
    void testLargerGrid() {

        int[][] heights = {
                {1, 2, 3, 4},
                {2, 8, 3, 5},
                {3, 4, 5, 6},
                {7, 8, 9, 10}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("Should handle high effort unavoidable path")
    @Timeout(1)
    void testHighEffortPath() {

        int[][] heights = {
                {1, 100},
                {100, 100}
        };

        int result =
                solution.minimumEffortPath(heights);

        assertEquals(99, result);
    }

    @Test
    @Timeout(1)
    @DisplayName("Edge Case")
    void test() {
        int[][] heights = {{1, 2, 3, 4}, {2, 8, 3, 5}, {3, 4, 5, 6}, {7, 8, 9, 1}};
        int result =
                solution.minimumEffortPath(heights);

        assertEquals(5, result);
    }
}


