package DSA.aniket.Graphs.WordLadder.WordLadder1;

import DSA.aniket.Graphs.WordLadder.WordLadder1.Solution.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderITest {

    private final WordLadder1 solution = new Solution();


    @Test
    void testExample1() {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        int expected = 5;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testExample2() {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log"
        );

        int expected = 0;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testSimpleTransformation() {

        String beginWord = "cat";
        String endWord = "dog";

        List<String> wordList = Arrays.asList(
                "cot", "cog", "dog"
        );

        int expected = 4;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testDirectTransformation() {

        String beginWord = "hit";
        String endWord = "hot";

        List<String> wordList = Arrays.asList(
                "hot"
        );

        int expected = 2;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testNoPossiblePath() {

        String beginWord = "abc";
        String endWord = "xyz";

        List<String> wordList = Arrays.asList(
                "abx", "axx", "xxy"
        );

        int expected = 0;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testSingleCharacterWords() {

        String beginWord = "a";
        String endWord = "c";

        List<String> wordList = Arrays.asList(
                "a", "b", "c"
        );

        int expected = 2;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testMultiplePaths() {

        String beginWord = "red";
        String endWord = "tax";

        List<String> wordList = Arrays.asList(
                "ted", "tex", "red", "tax", "tad", "den", "rex", "pee"
        );

        int expected = 4;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testLargeDictionary() {

        String beginWord = "talk";
        String endWord = "tail";

        List<String> wordList = Arrays.asList(
                "talk", "tons", "fall", "tail", "gale",
                "hall", "negs", "tall", "bail", "fail"
        );

        int expected = 3;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testTransformationWithCycles() {

        String beginWord = "aaa";
        String endWord = "bbb";

        List<String> wordList = Arrays.asList(
                "aab", "abb", "bbb", "aba", "baa"
        );

        int expected = 4;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    void testBeginWordNotInDictionary() {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        int expected = 5;

        assertEquals(expected,
                solution.ladderLength(beginWord, endWord, wordList));
    }
}