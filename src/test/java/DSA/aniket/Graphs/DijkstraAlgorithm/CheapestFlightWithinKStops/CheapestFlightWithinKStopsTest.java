package DSA.aniket.Graphs.DijkstraAlgorithm.CheapestFlightWithinKStops;

import DSA.aniket.Graphs.DijkstraAlgorithm.CheapestFlightWithinKStops.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheapestFlightsWithinKStopsTest {

    private final CheapestFlightWithinKStops solution = new Solution();

    @Test
    @DisplayName("Example 1 - Direct flight is cheapest within stop limit")
    @Timeout(1)
    void testExample1() {

        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 3, 500}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 3, 1);

        assertEquals(500, result);
    }

    @Test
    @DisplayName("Example 2 - Cheapest path with one stop")
    @Timeout(1)
    void testExample2() {

        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 2, 1);

        assertEquals(200, result);
    }

    @Test
    @DisplayName("Example 3 - No stops allowed")
    @Timeout(1)
    void testExample3() {

        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 2, 0);

        assertEquals(500, result);
    }

    @Test
    @DisplayName("No possible route within K stops")
    @Timeout(1)
    void testNoRouteWithinKStops() {

        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 3, 1);

        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Source and destination are same")
    @Timeout(1)
    void testSourceEqualsDestination() {

        int n = 3;
        int[][] flights = {
                {0, 1, 50},
                {1, 2, 50}
        };

        int result = solution.findCheapestPrice(n, flights, 1, 1, 1);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Cheapest path requires exactly K stops")
    @Timeout(1)
    void testExactKStops() {

        int n = 5;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {3, 4, 100},
                {0, 4, 1000}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 4, 3);

        assertEquals(400, result);
    }

    @Test
    @DisplayName("Graph with cycle should still return correct answer")
    @Timeout(1)
    void testGraphWithCycle() {

        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 0, 50},
                {1, 2, 100},
                {2, 3, 100}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 3, 2);

        assertEquals(300, result);
    }

    @Test
    @DisplayName("Single city graph")
    @Timeout(1)
    void testSingleCity() {

        int n = 1;
        int[][] flights = {};

        int result = solution.findCheapestPrice(n, flights, 0, 0, 0);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("Direct path cheaper than multi-stop path")
    @Timeout(1)
    void testDirectCheaperThanStops() {

        int n = 3;
        int[][] flights = {
                {0, 1, 300},
                {1, 2, 300},
                {0, 2, 200}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 2, 1);

        assertEquals(200, result);
    }

    @Test
    @DisplayName("Large K value should allow longer path")
    @Timeout(1)
    void testLargeKValue() {

        int n = 6;
        int[][] flights = {
                {0, 1, 50},
                {1, 2, 50},
                {2, 3, 50},
                {3, 4, 50},
                {4, 5, 50}
        };

        int result = solution.findCheapestPrice(n, flights, 0, 5, 4);

        assertEquals(250, result);
    }
}