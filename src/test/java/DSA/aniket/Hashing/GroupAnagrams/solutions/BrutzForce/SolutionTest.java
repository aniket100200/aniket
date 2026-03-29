package DSA.aniket.Hashing.GroupAnagrams.solutions.BrutzForce;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution=new Solution();
    private List<List<String>> normalize(List<List<String>> input) {
        if (input == null) return null;

        List<List<String>> normalized = new ArrayList<>();

        // Sort the contents of each inner list
        for (List<String> group : input) {
            List<String> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            normalized.add(sortedGroup);
        }

        // Sort the outer list to ensure consistent ordering of groups
        normalized.sort((list1, list2) -> {
            if (list1.size() != list2.size()) {
                return Integer.compare(list1.size(), list2.size());
            }
            // If sizes are equal, compare elements lexicographically
            for (int i = 0; i < list1.size(); i++) {
                int cmp = list1.get(i).compareTo(list2.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return normalized;
    }
    private void assertAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }
    // 1. Standard Cases
    @Test
    void testStandardMixedAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    @Test
    void testNoAnagrams() {
        String[] strs = {"abc", "def", "xyz"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("def"),
                Arrays.asList("xyz")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    // 2. Edge Cases from Constraints
    @Test
    void testEmptyString() {
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    @Test
    void testMultipleEmptyStrings() {
        String[] strs = {"", "b", ""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("", ""),
                Arrays.asList("b")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    @Test
    void testSingleCharacter() {
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    // 3. Tricky Frequencies & Repetitions
    @Test
    void testIdenticalStrings() {
        String[] strs = {"aaa", "aaa", "aaa"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("aaa", "aaa", "aaa")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }

    @Test
    void testSameCharsDifferentFrequencies() {
        String[] strs = {"aab", "aba", "baa", "abb", "bab", "bba"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("aab", "aba", "baa"),
                Arrays.asList("abb", "bab", "bba")
        );
        assertAnagramGroupsEqual(expected, solution.groupAnagrams(strs));
    }
}
