package DSA.aniket.Arrays.SlidingWindow.MinLenAfterDeletingSimillarEnds;

import DSA.aniket.Arrays.SlidingWindow.MinLenAfterDeletingSimillarEnds.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumLengthStringTest {
    private final MinLenAfterDeletingSimillarEnds solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1() {
        String s = "ca";

        // Expected: 2 (no deletions possible)
        assertEquals(2, solution.minimumLength(s), "Failed on Example 1.");
    }

    @Test
    public void testExample2() {
        String s = "cabaabac";

        // Expected: 0
        assertEquals(0, solution.minimumLength(s), "Failed on Example 2.");
    }

    @Test
    public void testExample3() {
        String s = "aabccabba";

        // 1. remove 'a's: "bccabb"
        // 2. remove 'b's: "cca"
        // Remaining string: "cca", length 3
        assertEquals(3, solution.minimumLength(s), "Failed on standard reduction case.");
    }

    @Test
    public void testSingleCharacter() {
        String s = "a";

        // Expected: 1 (pointers start equal, so condition left < right fails immediately)
        assertEquals(1, solution.minimumLength(s), "Failed on single character string.");
    }

    @Test
    public void testAllSameCharactersEven() {
        String s = "aaaa";

        // Expected: 0
        assertEquals(0, solution.minimumLength(s), "Failed on string with even number of same characters.");
    }

    @Test
    public void testAllSameCharactersOdd() {
        String s = "aaaaa";

        // Expected: 0
        assertEquals(0, solution.minimumLength(s), "Failed on string with odd number of same characters.");
    }

    @Test
    public void testStopsOnSingleCharacterLeftover() {
        String s = "abacaba";

        // 1. remove 'a's: "bacab"
        // 2. remove 'b's: "aca"
        // 3. remove 'a's: "c"
        // Length 1 remaining
        assertEquals(1, solution.minimumLength(s), "Failed when exactly one character remains.");
    }
}