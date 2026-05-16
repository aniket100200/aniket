package DSA.aniket.Arrays.SlidingWindow.MinimumWindowSubstring;

import DSA.aniket.Arrays.SlidingWindow.MinimumWindowSubstring.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinWindowSubstringTest {


    private final MinimumWindowSubstring solution = new Solution();


    // --- Tests ---

    @Test
    public void testExample1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        // Expected: "BANC"
        assertEquals("BANC", solution.minWindow(s, t), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        String s = "a";
        String t = "a";

        // Expected: "a"
        assertEquals("a", solution.minWindow(s, t), "Failed on Example 2 (exact match).");
    }

    @Test
    public void testExample3() {
        String s = "a";
        String t = "aa";

        // Expected: ""
        assertEquals("", solution.minWindow(s, t), "Failed on Example 3 (target larger than source).");
    }

    @Test
    public void testMultipleValidWindows() {
        // "cwa" is length 3, "bac" is length 3. It should find the first or minimum.
        String s = "cwaefgcwaefgbac";
        String t = "ca";

        // "cw" -> no. "cwa" -> yes (len 3).
        // "ac" at the end is length 2!
        assertEquals("ac", solution.minWindow(s, t), "Failed to find the absolute minimum window.");
    }

    @Test
    public void testTargetNotInString() {
        String s = "abcdef";
        String t = "xyz";

        // Expected: ""
        assertEquals("", solution.minWindow(s, t), "Failed when target characters do not exist in string.");
    }

    @Test
    public void testDuplicateCharactersInTarget() {
        String s = "abacabac";
        String t = "aab";

        // "aba" at the beginning is length 3 and has two 'a's and one 'b'.
        assertEquals("aba", solution.minWindow(s, t), "Failed handling duplicates in target string.");
    }

    @Test
    public void testExactStringMatch() {
        String s = "hello";
        String t = "hello";

        assertEquals("hello", solution.minWindow(s, t), "Failed when strings are identical.");
    }
}