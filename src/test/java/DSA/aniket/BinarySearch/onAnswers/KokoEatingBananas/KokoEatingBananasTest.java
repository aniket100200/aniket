package DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas;

import DSA.aniket.BinarySearch.onAnswers.KokoEatingBananas.OptimalApproach.OptimalApproach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Koko Eating Bananas - Binary Search on Answer")
class KokoEatingBananasTest {

    // Replace 'solver.minEatingSpeed' with your actual method.
    // Assuming signature: public static int minEatingSpeed(int[] piles, int h)

    //    KokoEatingBananas solver = new BrutzForceSolution();
    KokoEatingBananas solver = new OptimalApproach();

    @Test
    @DisplayName("1. Standard Case")
    void testStandardCase() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        assertEquals(4, solver.minEatingSpeed(piles, h),
                "Should find the optimal speed in a standard scenario.");
    }

    @Test
    @DisplayName("2. H equals array length (Must eat max pile per hour)")
    void testHoursEqualsPilesLength() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        // Koko only has 1 hour per pile, so she must eat at the speed of the largest pile.
        assertEquals(30, solver.minEatingSpeed(piles, h),
                "Speed must equal the maximum pile size when H == piles.length.");
    }

    @Test
    @DisplayName("3. H is very large (Can eat very slowly)")
    void testLargeHours() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 1000;
        // She has so much time she can eat exactly 1 banana per hour.
        assertEquals(1, solver.minEatingSpeed(piles, h),
                "Speed should be 1 if there is an abundance of time.");
    }

    @Test
    @DisplayName("4. Single Pile (Math.ceil check)")
    void testSinglePile() {
        int[] piles = {100};
        int h = 3;
        // 100 / 3 = 33.33... which must be rounded UP to 34.
        assertEquals(34, solver.minEatingSpeed(piles, h),
                "Should correctly round up the required speed for a single pile.");
    }

    @Test
    @DisplayName("5. Unbalanced Piles (Extremely skewed data)")
    void testUnbalancedPiles() {
        int[] piles = {1, 1, 1, 1, 1, 1000000000};
        int h = 6;
        // 5 hours for the small piles, leaving exactly 1 hour for the massive pile.
        assertEquals(1000000000, solver.minEatingSpeed(piles, h),
                "Should handle arrays where one pile dwarfs all others.");
    }

    @Test
    @DisplayName("6. OVERFLOW TRAP: Large Piles and Large H")
    void testIntegerOverflowTrap() {
        // If your hours counter is an 'int', this test will fail because
        // the sum of hours will wrap around to a negative number.
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;

        assertEquals(3, solver.minEatingSpeed(piles, h),
                "Total calculated hours must use a 'long' accumulator to prevent overflow.");
    }

    @Test
    @DisplayName("7. Minimum Speed is 1 (Not 0)")
    void testMinimumSpeedIsNotZero() {
        int[] piles = {2, 2};
        int h = 4;
        assertEquals(1, solver.minEatingSpeed(piles, h),
                "Speed cannot be 0, the minimum eating speed is always 1.");
    }

    @Test
    @DisplayName("8. Ceiling Division Precision Trap")
    void testCeilingPrecision() {
        int[] piles = {10};
        int h = 4;
        // 10 / 3 = 3.33... (Requires 4 hours -> Valid)
        // If your code uses floats incorrectly, it might output the wrong value.
        assertEquals(3, solver.minEatingSpeed(piles, h),
                "Should correctly handle ceiling math without floating-point precision errors.");
    }
}