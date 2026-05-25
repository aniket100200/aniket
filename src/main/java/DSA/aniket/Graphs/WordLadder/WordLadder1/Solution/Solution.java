package DSA.aniket.Graphs.WordLadder.WordLadder1.Solution;

import DSA.aniket.Graphs.WordLadder.WordLadder1.Pair;
import DSA.aniket.Graphs.WordLadder.WordLadder1.WordLadder1;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution implements WordLadder1 {

    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> que = new ArrayDeque<>();
        que.add(new Pair<>(beginWord, 1));
        Set<String> set = wordList.stream().collect(Collectors.toSet());
        set.remove(beginWord);
        while (que.size() > 0) {
            Pair<String, Integer> p1 = que.poll();
            String word = p1.getT();
            int steps = p1.getV();
            if (endWord.equals(word)) return steps;
            for (int i = 0; i < word.length(); i++) {
                char original = word.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) continue;
                    char[] repacedCharacterArray = word.toCharArray();
                    repacedCharacterArray[i] = ch;
                    String replaceWord = new String(repacedCharacterArray);
                    if (set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        que.add(new Pair<>(replaceWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}