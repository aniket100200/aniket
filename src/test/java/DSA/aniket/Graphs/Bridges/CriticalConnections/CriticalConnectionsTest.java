package DSA.aniket.Graphs.Bridges.CriticalConnections;

import DSA.aniket.Graphs.Bridges.CriticalConnections.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CriticalConnectionsInANetworkTest {

    private final CriticalConnections solution = new Solution();

    private void normalize(
            List<List<Integer>> bridges
    ) {
        for (int i = 0; i < bridges.size(); i++) {
            List<Integer> ans = bridges.get(i);
            bridges.set(i, new ArrayList<>());
        }
        Collections.sort(bridges, (a, b) -> {

            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }

            return a.get(1) - b.get(1);
        });
    }

    @Test
    @DisplayName("Example 1 - LeetCode Sample")
    @Timeout(1)
    void testExample1() {

        int n = 4;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(1, 3)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(1, 3));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Single Edge Graph")
    @Timeout(1)
    void testSingleEdge() {

        int n = 2;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(0, 1));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Two Bridges")
    @Timeout(1)
    void testTwoBridges() {

        int n = 5;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(1, 3),
                        List.of(3, 4)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(1, 3));
        expected.add(List.of(3, 4));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Pure Cycle")
    @Timeout(1)
    void testCycle() {

        int n = 4;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 3),
                        List.of(3, 0)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Chain Graph")
    @Timeout(1)
    void testChainGraph() {

        int n = 5;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 3),
                        List.of(3, 4)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(0, 1));
        expected.add(List.of(1, 2));
        expected.add(List.of(2, 3));
        expected.add(List.of(3, 4));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Star Graph")
    @Timeout(1)
    void testStarGraph() {

        int n = 5;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(0, 3),
                        List.of(0, 4)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(0, 1));
        expected.add(List.of(0, 2));
        expected.add(List.of(0, 3));
        expected.add(List.of(0, 4));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Complex Graph With One Bridge")
    @Timeout(1)
    void testComplexGraph() {

        int n = 6;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(2, 3),
                        List.of(3, 4),
                        List.of(4, 5),
                        List.of(5, 3)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(2, 3));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Fully Connected Graph")
    @Timeout(1)
    void testCompleteGraph() {

        int n = 4;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(0, 3),
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(2, 3)
                );

        List<List<Integer>> expected =
                Collections.emptyList();

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Triangle With Tail")
    @Timeout(1)
    void testTriangleWithTail() {

        int n = 5;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(2, 3),
                        List.of(3, 4)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        expected.add(List.of(2, 3));
        expected.add(List.of(3, 4));

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("No Bridges In SCC")
    @Timeout(1)
    void testNoBridgeSCC() {

        int n = 5;

        List<List<Integer>> connections =
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 3),
                        List.of(3, 4),
                        List.of(4, 0)
                );

        List<List<Integer>> expected =
                new ArrayList<>();

        List<List<Integer>> result =
                solution.criticalConnections(
                        n,
                        connections
                );

        normalize(expected);
        normalize(result);

        assertIterableEquals(expected, result);
    }
}