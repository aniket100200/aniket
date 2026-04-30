package DSA.aniket.BinarySearch.onAnswers.NthRootOfNumber.BrutzeForce;

import DSA.aniket.BinarySearch.onAnswers.NthRootOfNumber.NthRootOfNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrutzeForceTest {
    // Replace 'YourClass.nthRoot' with your actual method.
    // Assuming signature: public static int nthRoot(int n, int m)
    NthRootOfNumber solver = new BrutzeForce();

    @Test
    @DisplayName("1. Perfect Integer Root (Square Root)")
    void testPerfectSquareRoot() {
        assertEquals(3, solver.nthRoot(2, 9), "2nd root of 9 should be 3.");
    }

    @Test
    @DisplayName("2. Perfect Integer Root (Cube Root)")
    void testPerfectCubeRoot() {
        assertEquals(3, solver.nthRoot(3, 27), "3rd root of 27 should be 3.");
    }

    @Test
    @DisplayName("3. Not an Integer Root")
    void testNonIntegerRoot() {
        assertEquals(-1, solver.nthRoot(2, 8), "Square root of 8 is not an integer, should return -1.");
        assertEquals(-1, solver.nthRoot(3, 30), "Cube root of 30 is not an integer, should return -1.");
    }

    @Test
    @DisplayName("4. Base Case: M is 1")
    void testMIsOne() {
        assertEquals(1, solver.nthRoot(5, 1), "Any root of 1 is exactly 1.");
    }

    @Test
    @DisplayName("5. Base Case: N is 1")
    void testNIsOne() {
        assertEquals(15, solver.nthRoot(1, 15), "The 1st root of a number is the number itself.");
    }

    @Test
    @DisplayName("6. Base Case: M is 0")
    void testMIsZero() {
        assertEquals(0, solver.nthRoot(3, 0), "Any valid root of 0 is 0.");
    }

    @Test
    @DisplayName("7. Overflow Trap: Large N, Small M")
    void testLargeN() {
        // If mid > 1, mid^100 will overflow instantly.
        // Code must break early or handle overflow gracefully.
        assertEquals(-1, solver.nthRoot(100, 2), "Should safely return -1 without overflowing integers.");
    }

    @Test
    @DisplayName("8. High Boundary Exact Match")
    void testLargeExactMatch() {
        // 1000^3 = 1,000,000,000
        assertEquals(1000, solver.nthRoot(3, 1000000000), "Should correctly find roots for large values of M.");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 16, 4",    // Exact square root
            "4, 16, 2",    // Exact 4th root
            "5, 32, 2",    // Exact 5th root
            "4, 69, -1",   // No integer 4th root
            "6, 4096, 4",  // Exact 6th root
            "2, 1048576, 1024" // Larger exact square root
    })
    @DisplayName("9. Parameterized checks for various N and M combinations")
    void testVariousCombinations(int n, int m, int expected) {
        assertEquals(expected, solver.nthRoot(n, m));
    }


}