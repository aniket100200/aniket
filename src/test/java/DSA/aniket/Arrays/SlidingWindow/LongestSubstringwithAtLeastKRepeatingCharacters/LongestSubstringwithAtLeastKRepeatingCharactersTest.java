package DSA.aniket.Arrays.SlidingWindow.LongestSubstringwithAtLeastKRepeatingCharacters;

import DSA.aniket.Arrays.SlidingWindow.LongestSubstringwithAtLeastKRepeatingCharacters.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringKRepeatingTest {

    private final LongestSubstringwithAtLeastKRepeatingCharacters solution = new Solution();

    @Test
    public void testExample1() {
        String str = "xxxyy";
        int k = 3;

        // Expected: 3 ("xxx")
        assertEquals(3, solution.longestSubstring(str, k), "Failed on Example 1.");
    }

    // --- Tests ---

    @Test
    public void testExample2() {
        String str = "xyxyyz";
        int k = 2;

        // Expected: 5 ("xyxyy")
        assertEquals(5, solution.longestSubstring(str, k), "Failed on Example 2.");
    }

    @Test
    public void testKIsOne() {
        String str = "abcd";
        int k = 1;

        // Expected: 4 (The whole string is valid since every character appears at least 1 time)
        assertEquals(4, solution.longestSubstring(str, k), "Failed when k = 1.");
    }

    @Test
    public void testKIsGreaterThanStringLength() {
        String str = "abc";
        int k = 5;

        // Expected: 0
        assertEquals(0, solution.longestSubstring(str, k), "Failed when k is larger than the string length.");
    }

    @Test
    public void testNoValidSubstring() {
        String str = "abcdef";
        int k = 2;

        // Expected: 0
        assertEquals(0, solution.longestSubstring(str, k), "Failed when no characters meet the k requirement.");
    }

    @Test
    public void testWholeStringValid() {
        String str = "aabbcc";
        int k = 2;

        // Expected: 6
        assertEquals(6, solution.longestSubstring(str, k), "Failed when the entire string is valid.");
    }

    @Test
    public void testMultipleSplitsRequired() {
        // Here, 'c' breaks the string, leaving "ababb" and "d".
        // In "ababb", 'a' appears twice, 'b' appears three times. Valid length = 5.
        String str = "ababbcd";
        int k = 2;

        // Expected: 5
        assertEquals(5, solution.longestSubstring(str, k), "Failed on complex string requiring multiple splits.");
    }
}