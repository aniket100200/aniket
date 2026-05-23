package DSA.aniket.Graphs.Directed.TopologicalSort.AlienDictionary;

import DSA.aniket.Graphs.Directed.TopologicalSort.AlienDictionary.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienDictionaryTest {

    private final AlienDictionary solution = new Solution();


    /**
     * Helper method to validate alien ordering.
     */
    private boolean isValidAlienOrder(
            String order,
            String[] words
    ) {

        if (order.isEmpty()) {
            return false;
        }

        Map<Character, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            rankMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int minLength = Math.min(
                    first.length(),
                    second.length()
            );

            boolean foundDifference = false;

            for (int j = 0; j < minLength; j++) {

                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                if (c1 != c2) {

                    if (rankMap.get(c1)
                            > rankMap.get(c2)) {
                        return false;
                    }

                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference
                    && first.length() > second.length()) {
                return false;
            }
        }

        return true;
    }

    @Test
    @DisplayName("Should return valid ordering for standard example")
    void testStandardExample() {

        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        String result = solution.alienOrder(words);

        assertTrue(
                isValidAlienOrder(result, words),
                "Failed to generate valid alien ordering."
        );
    }

    @Test
    @DisplayName("Should return correct ordering for two characters")
    void testTwoCharacters() {

        String[] words = {"z", "x"};

        String result = solution.alienOrder(words);

        assertEquals(
                "zx",
                result,
                "Failed on two character ordering."
        );
    }

    @Test
    @DisplayName("Should return empty string when cycle exists")
    void testCycleDetection() {

        String[] words = {"z", "x", "z"};

        String result = solution.alienOrder(words);

        assertEquals(
                "",
                result,
                "Failed to detect cycle in graph."
        );
    }

    @Test
    @DisplayName("Should handle single word input")
    void testSingleWord() {

        String[] words = {"abc"};

        String result = solution.alienOrder(words);

        assertEquals(
                3,
                result.length(),
                "Failed on single word input."
        );
    }

    @Test
    @DisplayName("Should return empty string for invalid prefix ordering")
    void testInvalidPrefixCase() {

        String[] words = {"abc", "ab"};

        String result = solution.alienOrder(words);

        assertEquals(
                "",
                result,
                "Failed to detect invalid prefix ordering."
        );
    }

    @Test
    @DisplayName("Should process disconnected graph correctly")
    void testDisconnectedGraph() {

        String[] words = {"a", "b", "c"};

        String result = solution.alienOrder(words);

        assertTrue(
                isValidAlienOrder(result, words),
                "Failed on disconnected graph."
        );
    }

    @Test
    @DisplayName("Should handle duplicate adjacent words")
    void testDuplicateWords() {

        String[] words = {"abc", "abc"};

        String result = solution.alienOrder(words);

        assertEquals(
                3,
                result.length(),
                "Failed on duplicate words."
        );
    }

    @Test
    @DisplayName("Should generate valid order for complex graph")
    void testComplexGraph() {

        String[] words = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad"
        };

        String result = solution.alienOrder(words);

        assertTrue(
                isValidAlienOrder(result, words),
                "Failed on complex dependency graph."
        );
    }

    @Test
    @DisplayName("Should include all independent characters")
    void testIndependentCharacters() {

        String[] words = {"a", "b", "c", "d"};

        String result = solution.alienOrder(words);

        assertEquals(
                4,
                result.length(),
                "Failed to include all independent characters."
        );
    }

    @Test
    @DisplayName("Should detect cycle in larger dependency graph")
    void testLargeCycleGraph() {

        String[] words = {
                "abc",
                "abx",
                "axx",
                "abc"
        };

        String result = solution.alienOrder(words);

        assertEquals(
                "",
                result,
                "Failed to detect larger cyclic dependency."
        );
    }
}