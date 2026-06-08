package DSA.aniket.Graphs.DisjointSet.MostStoneRemoval;

import DSA.aniket.Graphs.DisjointSet.MostStoneRemoval.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumStoneRemovalTest {

    private final MostStoneRemoval solution = new Solution();


    @Test
    @DisplayName("Example 1 - LeetCode Sample")
    @Timeout(1)
    void testExample1() {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        int expected = 5;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 2 - Two Components")
    @Timeout(1)
    void testExample2() {

        int[][] stones = {
                {0, 0},
                {0, 2},
                {1, 1},
                {2, 0},
                {2, 2}
        };

        int expected = 3;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Example 3 - Single Stone")
    @Timeout(1)
    void testExample3() {

        int[][] stones = {
                {0, 0}
        };

        int expected = 0;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("All Stones Same Row")
    @Timeout(1)
    void testSameRow() {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {0, 2},
                {0, 3}
        };

        int expected = 3;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("All Stones Same Column")
    @Timeout(1)
    void testSameColumn() {

        int[][] stones = {
                {0, 0},
                {1, 0},
                {2, 0},
                {3, 0}
        };

        int expected = 3;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("No Shared Row Or Column")
    @Timeout(1)
    void testNoConnections() {

        int[][] stones = {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3}
        };

        int expected = 0;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Cross Pattern")
    @Timeout(1)
    void testCrossPattern() {

        int[][] stones = {
                {1, 0},
                {1, 1},
                {1, 2},
                {0, 1},
                {2, 1}
        };

        int expected = 4;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Two Independent Components")
    @Timeout(1)
    void testTwoComponents() {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {5, 5},
                {5, 6}
        };

        int expected = 2;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Chain Connectivity")
    @Timeout(1)
    void testChainConnectivity() {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 1},
                {1, 2}
        };

        int expected = 3;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Large Connected Component")
    @Timeout(1)
    void testLargeConnectedComponent() {

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
                {2, 1},
                {3, 1}
        };

        int expected = 5;

        int result = solution.maxRemove(stones, stones.length);

        assertEquals(expected, result);
    }
}