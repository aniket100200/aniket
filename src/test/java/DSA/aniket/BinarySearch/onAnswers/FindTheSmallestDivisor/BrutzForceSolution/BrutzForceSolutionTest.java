package DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.BrutzForceSolution;

import DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor.FindTheSmallestDivisor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Smallest Divisor Given a Threshold - Test Suite")
class SmallestDivisorTest {

    FindTheSmallestDivisor solver = new BrutzForceSolution();
    // Assuming signature: public static int smallestDivisor(int[] nums, int threshold)

    @Test
    @DisplayName("1. Standard Case: Example 1")
    void testExample1() {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        assertEquals(5, solver.smallestDivisor(nums, threshold),
                "Should find the optimal divisor 5 to keep the sum <= 6.");
    }

    @Test
    @DisplayName("2. Standard Case: Example 2 (Threshold equals array length)")
    void testExample2() {
        int[] nums = {44, 22, 33, 11, 1};
        int threshold = 5;
        // Since threshold == length, every element must divide down to 1.
        // Therefore, the divisor must be at least the maximum element in the array.
        assertEquals(44, solver.smallestDivisor(nums, threshold),
                "Divisor must equal the max element when threshold equals array length.");
    }

    @Test
    @DisplayName("3. Large Threshold (Divisor can be 1)")
    void testLargeThreshold() {
        int[] nums = {1, 2, 3};
        int threshold = 100;
        // Even with a divisor of 1, the sum is 6, which is <= 100.
        // The minimum possible divisor is always 1.
        assertEquals(1, solver.smallestDivisor(nums, threshold),
                "Should safely return 1 when the threshold is massively larger than the array sum.");
    }

    @Test
    @DisplayName("4. Single Element Array")
    void testSingleElement() {
        int[] nums = {100};
        int threshold = 2;
        // 100 / 50 = 2.
        assertEquals(50, solver.smallestDivisor(nums, threshold),
                "Should correctly calculate the exact ceiling division for a single element.");
    }

    @Test
    @DisplayName("5. Ceiling Math Precision Check")
    void testCeilingMath() {
        int[] nums = {10};
        int threshold = 4;
        // 10 / 3 = 3.33... which rounds up to 4.
        assertEquals(3, solver.smallestDivisor(nums, threshold),
                "Must correctly round up decimals to the nearest whole integer.");
    }

    @Test
    @DisplayName("6. OVERFLOW TRAP: Maximum constraints testing sum accumulator")
    void testSumOverflowTrap() {
        // Create an array of 50,000 elements, all set to 1,000,000
        int[] nums = new int[50000];
        Arrays.fill(nums, 1000000);
        int threshold = 1000000;

        // If the 'sum' variable inside the helper method is an 'int',
        // 50,000 * 1,000,000 will wrap around to a negative number,
        // causing the condition to falsely evaluate to true for small divisors.
        assertEquals(50000, solver.smallestDivisor(nums, threshold),
                "The helper method must use a 'long' to accumulate the sum to prevent integer overflow.");
    }

    @Test
    @DisplayName("7. Boundary: Array elements all 1s")
    void testAllOnes() {
        int[] nums = {1, 1, 1, 1, 1};
        int threshold = 10;
        assertEquals(1, solver.smallestDivisor(nums, threshold),
                "Should correctly handle arrays containing only the minimum constraint value.");
    }
}