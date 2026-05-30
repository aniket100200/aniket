package DSA.aniket.Graphs.DijkstraAlgorithm.UsingSet;

import DSA.aniket.Graphs.Algorithms.DijkstraAlgorithm.UsingSet.UsingSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsingSetTest {

    UsingSet solution = new UsingSet();

    @Test
    @DisplayName("Testing Using Set")
    public void test1() {
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 2},
                {0, 2, 5}
        };

        int[] expected = {4, 2, 0};

        assertTrue(check(expected, solution.dijstra(3, edges, 2)));
    }

    public boolean check(int[] actual, int[] expected) {
        if (actual.length != expected.length) return false;
        for (int i = 0; i < expected.length; i++) if (actual[i] != expected[i]) return false;
        return true;
    }

}