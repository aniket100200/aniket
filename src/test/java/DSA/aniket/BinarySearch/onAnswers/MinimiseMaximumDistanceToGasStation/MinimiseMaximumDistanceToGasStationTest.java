package DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation;

import DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation.BetterApproach.BetterSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Minimize Max Distance to Gas Station - Floating Point Binary Search")
class GasStationDistanceTest {

    // Allowed margin of error strictly set to 10^-6
    private static final double EPSILON = 1e-6;
    // Assuming signature: public static double findSmallestMaxDist(int[] stations, int k)
    MinimiseMaximumDistanceToGasStation solver = new BetterSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1 (Uniform Gaps)")
    void testExample1() {
        int[] stations = {1, 2, 3, 4, 5};
        assertEquals(1.000000, solver.minMaxDist(stations, 2), EPSILON,
                "Should return the existing max gap if adding stations doesn't help.");
    }

    @Test
    @DisplayName("2. Standard Case: Example 2 (Scattered Gaps)")
    void testExample2() {
        int[] stations = {3, 6, 12, 19, 33};
        assertEquals(6.000000, solver.minMaxDist(stations, 3), EPSILON);
    }

    @Test
    @DisplayName("3. TRAP: k = 0 (No stations added)")
    void testZeroStationsAdded() {
        int[] stations = {1, 5, 15, 20};
        // The max gap is 10 (between 5 and 15). Since we add 0 stations, the answer is 10.
        assertEquals(10.000000, solver.minMaxDist(stations, 0), EPSILON,
                "If k=0, the answer is exactly the maximum existing gap in the array.");
    }

    @Test
    @DisplayName("4. Extreme Single Gap (Max Distance vs High K)")
    void testExtremeSingleGap() {
        int[] stations = {0, 1000000}; // Only two stations, massive gap
        int k = 1;
        // Adding 1 station perfectly splits it in half.
        assertEquals(500000.000000, solver.minMaxDist(stations, k), EPSILON);
    }

    @Test
    @DisplayName("5. Massive K (Crushing the distance to fractions)")
    void testMassiveK() {
        int[] stations = {1, 10};
        int k = 8;
        // The total distance is 9. We add 8 stations, splitting it into 9 segments.
        // 9 / 9 = 1.000000
        assertEquals(1.000000, solver.minMaxDist(stations, k), EPSILON,
                "Must handle floating point divisions perfectly when K is large.");
    }

    @Test
    @DisplayName("6. Repeating Decimal Precision")
    void testRepeatingDecimals() {
        int[] stations = {0, 10};
        int k = 2;
        // Total distance 10. Add 2 stations -> 3 segments.
        // 10 / 3 = 3.333333...
        assertEquals(3.333333, solver.minMaxDist(stations, k), EPSILON,
                "Must be accurate to exactly 6 decimal places for repeating fractions.");
    }

    @Test
    @DisplayName("7. Floating Point Loop Infinite Safety")
    void testLargeArraySmallGaps() {
        // Simulating the constraints edge case
        int[] stations = new int[100000];
        for (int i = 0; i < stations.length; i++) {
            stations[i] = i * 2; // Gaps of exactly 2
        }
        assertEquals(1.000000, solver.minMaxDist(stations, 100000), EPSILON,
                "Algorithm must not hit an infinite loop due to floating point limits.");
    }
}