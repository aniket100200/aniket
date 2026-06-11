package DSA.aniket.Greedy.LemonadeChange;

import DSA.aniket.Greedy.LemonadeChange.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LemonadeChangeTest {

    private final LemonadeChange solution = new Solution();


    @Test
    @DisplayName("Standard Example 1: Able to provide change to everyone")
    @Timeout(1)
    public void testStandardExample1() {
        int[] bills = {5, 5, 5, 10, 20};
        assertTrue(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Standard Example 2: Run out of $5 bills for the last customer")
    @Timeout(1)
    public void testStandardExample2() {
        int[] bills = {5, 5, 10, 10, 20};
        assertFalse(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Edge Case: First customer requires change")
    @Timeout(1)
    public void testFailsOnFirstCustomer() {
        int[] bills = {10, 5, 5};
        assertFalse(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Corner Case: All customers pay with exact change ($5)")
    @Timeout(1)
    public void testAllFives() {
        int[] bills = {5, 5, 5, 5, 5};
        assertTrue(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Corner Case: Changing a $20 with three $5s")
    @Timeout(1)
    public void testChangeTwentyWithThreeFives() {
        int[] bills = {5, 5, 5, 20};
        assertTrue(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Edge Case: Fails when needing to change $20 but only have two $5s")
    @Timeout(1)
    public void testFailsTwentyWithTwoFives() {
        int[] bills = {5, 5, 20};
        assertFalse(solution.lemonadeChange(bills));
    }

    @Test
    @DisplayName("Edge Case: Alternating 5s and 10s building up")
    @Timeout(1)
    public void testAlternatingFivesAndTens() {
        int[] bills = {5, 10, 5, 10, 5, 10, 5, 20};
        assertTrue(solution.lemonadeChange(bills));
    }
}