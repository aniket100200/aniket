package DSA.aniket.Graphs.ShortestDistanceInBinaryMaze;

import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.ShortestDistanceInBinaryMaze.ShortestDistanceInBinaryMaze;
import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.ShortestDistanceInBinaryMaze.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestDistanceInBinaryMazeTest {

    private ShortestDistanceInBinaryMaze solution = new Solution();

    @Test
    @DisplayName("Should return shortest distance for reachable destination")
//    @Timeout(1)
    void testExample1() {

        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 0, 1}
        };

        int[] source = {0, 0};

        int[] destination = {3, 3};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("Should handle another reachable maze correctly")
    @Timeout(1)
    void testExample2() {

        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[] source = {0, 0};

        int[] destination = {2, 2};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("Should return -1 when destination is unreachable")
    @Timeout(1)
    void testUnreachableDestination() {

        int[][] grid = {
                {1, 0},
                {0, 1}
        };

        int[] source = {0, 0};

        int[] destination = {1, 1};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Should return 0 when source equals destination")
    @Timeout(1)
    void testSourceEqualsDestination() {

        int[][] grid = {
                {1, 1},
                {1, 1}
        };

        int[] source = {0, 0};

        int[] destination = {0, 0};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return -1 when source cell is blocked")
    @Timeout(1)
    void testBlockedSource() {

        int[][] grid = {
                {0, 1},
                {1, 1}
        };

        int[] source = {0, 0};

        int[] destination = {1, 1};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Should return -1 when destination cell is blocked")
    @Timeout(1)
    void testBlockedDestination() {

        int[][] grid = {
                {1, 1},
                {1, 0}
        };

        int[] source = {0, 0};

        int[] destination = {1, 1};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Should handle single cell grid")
    @Timeout(1)
    void testSingleCellGrid() {

        int[][] grid = {
                {1}
        };

        int[] source = {0, 0};

        int[] destination = {0, 0};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should find shortest path in larger maze")
    @Timeout(1)
    void testLargerMaze() {

        int[][] grid = {
                {1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        int[] source = {0, 0};

        int[] destination = {4, 4};

        int result =
                solution.shortestPath(grid, source, destination);

        assertEquals(8, result);
    }
}