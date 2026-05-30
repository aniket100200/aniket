package DSA.aniket.Graphs.DijkstraAlgorithm.MinimumMultiplicationsToReachEnd;

import DSA.aniket.Graphs.DijkstraAlgorithm.MinimumMultiplicationsToReachEnd.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumMultiplicationsToReachEndTest {

    /**
     * replace null with Actual Soltion
     */
    private final MinimumMultiplicationsToReachEnd solution = new Solution();

    @Test
    @DisplayName("Example 1 - Reach target in two multiplications")
    @Timeout(1)
    void testExample1() {
        assertEquals(
                2,
                solution.minimumMultiplications(
                        new int[]{2, 5, 7},
                        3,
                        30
                )
        );
    }

    @Test
    @DisplayName("Example 2 - Standard GFG example")
    @Timeout(1)
    void testExample2() {
        assertEquals(
                4,
                solution.minimumMultiplications(
                        new int[]{3, 4, 65},
                        7,
                        66175
                )
        );
    }

    @Test
    @DisplayName("Start equals end")
    @Timeout(1)
    void testStartEqualsEnd() {
        assertEquals(
                0,
                solution.minimumMultiplications(
                        new int[]{2, 3, 5},
                        100,
                        100
                )
        );
    }

    @Test
    @DisplayName("Impossible to reach target")
    @Timeout(1)
    void testImpossibleCase() {
        assertEquals(
                -1,
                solution.minimumMultiplications(
                        new int[]{2},
                        1,
                        3
                )
        );
    }

    @Test
    @DisplayName("Single multiplication required")
    @Timeout(1)
    void testSingleStep() {
        assertEquals(
                1,
                solution.minimumMultiplications(
                        new int[]{10},
                        5,
                        50
                )
        );
    }

    @Test
    @DisplayName("Multiplier one creates self loops")
    @Timeout(1)
    void testSelfLoopMultiplier() {
        assertEquals(
                -1,
                solution.minimumMultiplications(
                        new int[]{1},
                        2,
                        3
                )
        );
    }

    @Test
    @DisplayName("Reach zero using multiplier zero")
    @Timeout(1)
    void testReachZero() {
        assertEquals(
                1,
                solution.minimumMultiplications(
                        new int[]{0},
                        12345,
                        0
                )
        );
    }

    @Test
    @DisplayName("Large values modulo operation")
    @Timeout(1)
    void testModuloBehavior() {
        assertEquals(
                1,
                solution.minimumMultiplications(
                        new int[]{100000},
                        99999,
                        0
                )
        );
    }

    @Test
    @DisplayName("Multiple paths choose shortest")
    @Timeout(1)
    void testShortestPathChosen() {
        assertEquals(
                2,
                solution.minimumMultiplications(
                        new int[]{2, 10},
                        1,
                        20
                )
        );
    }

    @Test
    @DisplayName("Repeated multipliers")
    @Timeout(1)
    void testRepeatedMultipliers() {
        assertEquals(
                3,
                solution.minimumMultiplications(
                        new int[]{2, 2, 2},
                        1,
                        8
                )
        );
    }
}