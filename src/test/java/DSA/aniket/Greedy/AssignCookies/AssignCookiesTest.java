package DSA.aniket.Greedy.AssignCookies;

import DSA.aniket.Greedy.AssignCookies.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignCookiesTest {

    private final AssignCookies solution = new Solution();

    @Test
    @DisplayName("Standard Example 1: Not enough cookies of sufficient size")
    @Timeout(1)
    public void testStandardExample1() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        assertEquals(1, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Standard Example 2: Abundance of cookies")
    @Timeout(1)
    public void testStandardExample2() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        assertEquals(2, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Edge Case: No cookies available")
    @Timeout(1)
    public void testNoCookies() {
        int[] g = {1, 2, 3};
        int[] s = {};
        assertEquals(0, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Edge Case: No children to satisfy")
    @Timeout(1)
    public void testNoChildren() {
        int[] g = {};
        int[] s = {1, 2, 3};
        assertEquals(0, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Edge Case: All cookies are too small")
    @Timeout(1)
    public void testCookiesTooSmall() {
        int[] g = {10, 20, 30};
        int[] s = {1, 2, 3};
        assertEquals(0, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Edge Case: Massive cookies for small greed factors")
    @Timeout(1)
    public void testCookiesVeryLarge() {
        int[] g = {1, 2, 3};
        int[] s = {100, 200, 300};
        assertEquals(3, solution.findContentChildren(g, s));
    }

    @Test
    @DisplayName("Corner Case: Unsorted arrays as input")
    @Timeout(1)
    public void testUnsortedInput() {
        int[] g = {5, 2, 8, 1};
        int[] s = {10, 4, 1, 6};
        // Sorted g: 1, 2, 5, 8
        // Sorted s: 1, 4, 6, 10
        // Pairs: (1,1), (2,4), (5,6), (8,10) -> All 4 satisfied
        assertEquals(4, solution.findContentChildren(g, s));
    }
}