package DSA.aniket.Graphs.DisjointSet.MakeNetworkConnected;

import DSA.aniket.Graphs.DisjointSet.MakeNetworkConnected.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfOperationsToMakeNetworkConnectedTest {

    private final MakeNetworkConnected solution = new Solution();


    @Test
    @DisplayName("Example 1 - One Operation Needed")
    @Timeout(1)
    void testExample1() {

        int n = 4;

        int[][] connections = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        assertEquals(1, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Example 2 - Two Operations Needed")
    @Timeout(1)
    void testExample2() {

        int n = 6;

        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        assertEquals(2, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Example 3 - Not Enough Cables")
    @Timeout(1)
    void testExample3() {

        int n = 6;

        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2}
        };

        assertEquals(-1, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Already Connected Network")
    @Timeout(1)
    void testAlreadyConnected() {

        int n = 4;

        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 3}
        };

        assertEquals(0, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Single Computer")
    @Timeout(1)
    void testSingleComputer() {

        int n = 1;
        int[][] connections = {};

        assertEquals(0, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Two Computers Connected")
    @Timeout(1)
    void testTwoComputersConnected() {

        int n = 2;

        int[][] connections = {
                {0, 1}
        };

        assertEquals(0, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Two Computers Not Connected")
    @Timeout(1)
    void testTwoComputersNotConnected() {

        int n = 2;
        int[][] connections = {};

        assertEquals(-1, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Multiple Components With Sufficient Extra Cables")
    @Timeout(1)
    void testMultipleComponents() {

        int n = 7;

        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 0},
                {3, 4},
                {4, 5},
                {5, 3}
        };

        assertEquals(2, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Large Connected Component And One Isolated Node")
    @Timeout(1)
    void testOneIsolatedNode() {

        int n = 5;

        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 3},
                {0, 2}
        };

        assertEquals(1, solution.makeConnected(n, connections));
    }

    @Test
    @DisplayName("Chain Network Already Connected")
    @Timeout(1)
    void testChainNetwork() {

        int n = 8;

        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7}
        };

        assertEquals(0, solution.makeConnected(n, connections));
    }
}