package DSA.aniket.Graphs.DisjointSet.NumberOfIslandsII;

import DSA.aniket.Graphs.DisjointSet.NumberOfIslandsII.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class NumberOfIslandsIITest {

    private final NumberOfIslandsII solution = new Solution();


    @Test
    @DisplayName("Example 1 - GFG Sample")
    @Timeout(1)
    void testExample1() {

        int n = 4;
        int m = 5;

        int[][] operators = {
                {1, 1},
                {0, 1},
                {3, 3},
                {3, 4}
        };

        List<Integer> expected = List.of(1, 1, 2, 2);

        List<Integer> result = solution.numOfIslands(n, m, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Example 2 - Isolated Lands")
    @Timeout(1)
    void testExample2() {

        int n = 4;
        int m = 5;

        int[][] operators = {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3}
        };

        List<Integer> expected = List.of(1, 2, 3, 4);

        List<Integer> result = solution.numOfIslands(n, m, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Bridge Cell Merges Multiple Islands")
    @Timeout(1)
    void testBridgeMerge() {

        int n = 3;
        int m = 3;

        int[][] operators = {
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1},
                {1, 1}
        };

        List<Integer> expected = List.of(1, 1, 2, 3, 1);

        List<Integer> result = solution.numOfIslands(n, m, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Single Cell Grid")
    @Timeout(1)
    void testSingleCell() {

        int[][] operators = {
                {0, 0}
        };

        List<Integer> expected = List.of(1);

        List<Integer> result = solution.numOfIslands(1, 1, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Duplicate Operation")
    @Timeout(1)
    void testDuplicateOperation() {

        int[][] operators = {
                {0, 0},
                {0, 0},
                {0, 0}
        };

        List<Integer> expected = List.of(1, 1, 1);

        List<Integer> result = solution.numOfIslands(2, 2, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Horizontal Expansion")
    @Timeout(1)
    void testHorizontalExpansion() {

        int[][] operators = {
                {0, 0},
                {0, 1},
                {0, 2},
                {0, 3}
        };

        List<Integer> expected = List.of(1, 1, 1, 1);

        List<Integer> result = solution.numOfIslands(1, 4, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Vertical Expansion")
    @Timeout(1)
    void testVerticalExpansion() {

        int[][] operators = {
                {0, 0},
                {1, 0},
                {2, 0},
                {3, 0}
        };

        List<Integer> expected = List.of(1, 1, 1, 1);

        List<Integer> result = solution.numOfIslands(4, 1, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Four Separate Islands")
    @Timeout(1)
    void testSeparateIslands() {

        int[][] operators = {
                {0, 0},
                {0, 2},
                {2, 0},
                {2, 2}
        };

        List<Integer> expected = List.of(1, 2, 3, 4);

        List<Integer> result = solution.numOfIslands(3, 3, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Merge Two Islands")
    @Timeout(1)
    void testMergeTwoIslands() {

        int[][] operators = {
                {0, 0},
                {0, 2},
                {0, 1}
        };

        List<Integer> expected = List.of(1, 2, 1);

        List<Integer> result = solution.numOfIslands(1, 3, operators);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Large Connected Block")
    @Timeout(1)
    void testLargeConnectedBlock() {

        int[][] operators = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        List<Integer> expected = List.of(1, 1, 1, 1);

        List<Integer> result = solution.numOfIslands(2, 2, operators);

        assertIterableEquals(expected, result);
    }
}