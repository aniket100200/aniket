package DSA.aniket.BinarySearch.Basics.FindTheSquareRootOfNumber.BrutzForce;

import DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.FindTheSquareRootOfNumber;
import DSA.aniket.BinarySearch.onAnswers.FindTheSquareRootOfNumber.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BrutzForceTest {

    // Assuming method signature: public static int mySqrt(int x)
    FindTheSquareRootOfNumber solver = new OptimalSolution();

    @Test
    @DisplayName("1. Base Case: Zero")
    void testZero() {
        assertEquals(0, solver.findSquareRoot(0), "The square root of 0 should be 0.");
    }

    @Test
    @DisplayName("2. Base Case: One")
    void testOne() {
        assertEquals(1, solver.findSquareRoot(1), "The square root of 1 should be 1.");
    }

    @Test
    @DisplayName("3. Perfect Square")
    void testPerfectSquare() {
        assertEquals(4, solver.findSquareRoot(16), "Should return the exact root for perfect squares.");
        assertEquals(100, solver.findSquareRoot(10000));
    }

    @Test
    @DisplayName("4. Non-Perfect Square (Rounding down/Floor)")
    void testNonPerfectSquare() {
        // sqrt(8) is 2.82842..., so it should return 2
        assertEquals(2, solver.findSquareRoot(8), "Should truncate the decimal and return the floor value.");
        assertEquals(3, solver.findSquareRoot(15), "Should return 3 for 15, as 4^2 is 16 (too large).");
        assertEquals(2, solver.findSquareRoot(5));
    }

    @Test
    @DisplayName("5. Integer Overflow Trap: Integer.MAX_VALUE")
    void testMaxInteger() {
        // The square root of 2147483647 is approx 46340.95
        // If the algorithm uses `mid * mid` without casting to long, this will freeze or fail.
        assertEquals(46340, solver.findSquareRoot(Integer.MAX_VALUE),
                "Must handle Integer.MAX_VALUE without integer overflow during mid calculation.");
    }

    @Test
    @DisplayName("6. Integer Overflow Trap: Large Perfect Square")
    void testLargePerfectSquare() {
        // 46340 * 46340 = 2147395600 (Very close to Integer.MAX_VALUE)
        assertEquals(46340, solver.findSquareRoot(2147395600),
                "Must correctly find the root of the largest perfect square that fits in a 32-bit int.");
    }

    @Test
    @DisplayName("7. Negative Numbers (Error Handling)")
    void testNegativeNumber() {
        // Assuming your method is designed to throw an exception for invalid inputs
        assertThrows(IllegalArgumentException.class, () -> {
            solver.findSquareRoot(-4);
        }, "Should throw an exception for negative inputs as they result in imaginary numbers.");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 1",
            "4, 2",
            "5, 2",
            "24, 4",
            "25, 5",
            "26, 5",
            "99, 9"
    })
    @DisplayName("8. Rapid check of adjacent boundaries")
    void testMultipleBoundaries(int input, int expectedOutput) {
        assertEquals(expectedOutput, solver.findSquareRoot(input));
    }
}