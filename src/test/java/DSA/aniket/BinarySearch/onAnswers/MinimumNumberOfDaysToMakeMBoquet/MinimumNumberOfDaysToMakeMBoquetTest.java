package DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet;

import DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Minimum Days to Make M Bouquets - Test Suite")
class MinDaysBouquetsTest {

    // Replace 'YourClass.minDays' with your actual method.
    // Assuming signature: public static int minDays(int[] bloomDay, int m, int k)

    MinimumNumberOfDaysToMakeMBoquet solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1")
    void testExample1() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        assertEquals(3, solver.minDays(bloomDay, 3, 1),
                "Should make 3 bouquets of 1 flower in 3 days.");
    }

    @Test
    @DisplayName("2. Impossible Case: Example 2 (Not enough flowers total)")
    void testExample2() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        assertEquals(-1, solver.minDays(bloomDay, 3, 2),
                "Requires 6 flowers but only 5 exist. Should return -1.");
    }

    @Test
    @DisplayName("3. Adjacency Check: Example 3")
    void testExample3() {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        // After 7 days, we have [x,x,x,x,_,x,x]. We can only make 1 bouquet of 3.
        // We must wait until day 12.
        assertEquals(12, solver.minDays(bloomDay, 2, 3),
                "Must wait for day 12 to get the second contiguous sequence of 3 flowers.");
    }

    @Test
    @DisplayName("4. All flowers bloom on the same day")
    void testSameBloomDay() {
        int[] bloomDay = {5, 5, 5, 5, 5, 5};
        assertEquals(5, solver.minDays(bloomDay, 2, 3),
                "If all flowers bloom simultaneously, it takes exactly that many days.");
    }

    @Test
    @DisplayName("5. Need exactly the entire garden")
    void testEntireGardenNeeded() {
        int[] bloomDay = {1, 2, 3, 4, 5};
        assertEquals(5, solver.minDays(bloomDay, 1, 5),
                "To use all flowers, you must wait for the absolute maximum bloom day.");
    }

    @Test
    @DisplayName("6. OVERFLOW TRAP: Large M and K")
    void testIntegerOverflowTrap() {
        int[] bloomDay = {1, 2, 3, 4, 5};
        int m = 1000000; // 10^6
        int k = 100000;  // 10^5

        // m * k = 100,000,000,000 which far exceeds Integer.MAX_VALUE (2,147,483,647)
        // If the code uses 'int' for m * k, it wraps to a negative number and bypasses the failure check.
        assertEquals(-1, solver.minDays(bloomDay, m, k),
                "Must correctly identify impossible states without integer overflow.");
    }

    @Test
    @DisplayName("7. Large Bloom Days (Binary Search Mid Overflow)")
    void testLargeBloomDays() {
        // Values up to 10^9
        int[] bloomDay = {1000000000, 1000000000};
        assertEquals(1000000000, solver.minDays(bloomDay, 1, 2),
                "Algorithm must handle max constraints (10^9) without overflowing mid calculation.");
    }

    @Test
    @DisplayName("8. Broken Adjacency Chains")
    void testBrokenChains() {
        int[] bloomDay = {1, 10, 1, 10, 1, 10, 1};
        // We want 2 bouquets of 2 flowers.
        // The 1s bloom early, but they are isolated by the 10s.
        assertEquals(10, solver.minDays(bloomDay, 2, 2),
                "Must wait for the 10s to bloom to form contiguous pairs.");
    }

    @Test
    @DisplayName("9. For Integer Over Flow Case")
    void testIntegerOverFlow() {
        assertEquals(-1, solver.minDays(new int[10000000], 89945, 32127));
    }

}