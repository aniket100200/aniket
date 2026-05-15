package DSA.aniket.RangeQueries.PrefixSum.carPooling;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.carPooling.CarPooling;
import DSA.aniket.Arrays.RangeQueries.PrefixSum.carPooling.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarPoolingTest {

    private final CarPooling solution = new Solution();

    @Test
    public void testExample1_ValidCapacity() {
        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 5;

        assertTrue(solution.carPooling(trips, capacity),
                "Expected true: Car has enough capacity to hold 5 passengers at overlapping interval [3, 5].");
    }

    @Test
    public void testExample2_InsufficientCapacity() {
        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 4;

        assertFalse(solution.carPooling(trips, capacity),
                "Expected false: Overlapping interval requires capacity 5, but car only has 4.");
    }

    @Test
    public void testSimultaneousDropOffAndPickUp() {
        // Passengers drop off at 5, new passengers pick up at 5.
        // Peak capacity needed is only 4 (never 7).
        int[][] trips = {
                {4, 1, 5},
                {3, 5, 8}
        };
        int capacity = 4;

        assertTrue(solution.carPooling(trips, capacity),
                "Expected true: Drop-offs happen before pick-ups at the same location.");
    }

    @Test
    public void testMultipleOverlaps() {
        int[][] trips = {
                {3, 2, 7},
                {3, 7, 9},
                {8, 3, 9}
        };
        int capacity = 11;

        assertTrue(solution.carPooling(trips, capacity),
                "Expected true: Peak passenger count is 11 between location 3 and 7.");
    }

    @Test
    public void testCapacityExceededAtStart() {
        // Single trip exceeds capacity immediately
        int[][] trips = {
                {10, 1, 5}
        };
        int capacity = 9;

        assertFalse(solution.carPooling(trips, capacity),
                "Expected false: A single trip exceeds the total car capacity.");
    }

    @Test
    public void testNonOverlappingTrips() {
        // Car can technically transport infinite people if they never overlap
        int[][] trips = {
                {10, 1, 2},
                {10, 2, 3},
                {10, 3, 4}
        };
        int capacity = 10;

        assertTrue(solution.carPooling(trips, capacity),
                "Expected true: Trips are sequential and never overlap.");
    }

    @Test
    public void testMyCase() {
        int[][] trips = {
                {10, 0, 1},
                {5, 2, 3},
                {5, 3, 10}
        };

        int capacity = 5;
        assertFalse(solution.carPooling(trips, capacity));


    }
}