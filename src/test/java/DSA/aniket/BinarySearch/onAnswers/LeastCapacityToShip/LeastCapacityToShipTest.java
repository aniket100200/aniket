package DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip;

import DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Ship Packages Within D Days - Test Suite")
class ShipPackagesTest {

    // Replace 'YourClass.shipWithinDays' with your actual method.
    // Assuming signature: public static int shipWithinDays(int[] weights, int days)

    LeastCapacityToShip solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1")
    void testExample1() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(15, solver.shipWithinDays(weights, 5),
                "Should find optimal capacity 15 for a sequential array over 5 days.");
    }

    @Test
    @DisplayName("2. Standard Case: Example 2 (Scattered weights)")
    void testExample2() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        assertEquals(6, solver.shipWithinDays(weights, 3),
                "Should correctly handle unevenly distributed weights.");
    }

    @Test
    @DisplayName("3. Standard Case: Example 3 (Repeated smaller weights)")
    void testExample3() {
        int[] weights = {1, 2, 3, 1, 1};
        assertEquals(3, solver.shipWithinDays(weights, 4));
    }

    @Test
    @DisplayName("4. Minimum Days (Days = 1)")
    void testOneDay() {
        int[] weights = {10, 20, 30};
        // To ship everything in 1 day, the capacity MUST equal the sum of all weights.
        assertEquals(60, solver.shipWithinDays(weights, 1),
                "If days == 1, capacity must be the total sum of the array.");
    }

    @Test
    @DisplayName("5. Maximum Days (Days = array length)")
    void testMaxDays() {
        int[] weights = {10, 50, 20, 40};
        // We have exactly enough days to ship one package per day.
        // The capacity MUST equal the heaviest single package.
        assertEquals(50, solver.shipWithinDays(weights, 4),
                "If days == length, capacity must be the maximum single element in the array.");
    }

    @Test
    @DisplayName("6. Single Element Array")
    void testSingleElement() {
        int[] weights = {500};
        assertEquals(500, solver.shipWithinDays(weights, 1),
                "Single package requires capacity equal to its weight.");
    }

    @Test
    @DisplayName("7. All Weights are Equal")
    void testEqualWeights() {
        int[] weights = {10, 10, 10, 10, 10};
        assertEquals(20, solver.shipWithinDays(weights, 3),
                "Algorithm should correctly partition identical weights.");
    }

    @Test
    @DisplayName("8. Heaviest Package at the End")
    void testHeaviestAtEnd() {
        int[] weights = {1, 1, 1, 1, 1, 100};
        // Even with 6 days, the ship MUST be able to carry the 100-weight package.
        assertEquals(100, solver.shipWithinDays(weights, 6),
                "Lower bound must never be less than the maximum element in the array.");
    }
}