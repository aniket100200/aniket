package DSA.aniket.Graphs.WordLadder.WordLadder2;

import java.util.List;

public interface WordLadder2 {
    /**
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList);
}