package DSA.aniket.Graphs.WordLadder.WordLadder2.StriversSolution;

import DSA.aniket.Graphs.WordLadder.WordLadder2.WordLadder2;

import java.util.*;
import java.util.stream.Collectors;

public class StriversSolution implements WordLadder2 {

    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = wordList.stream().collect(Collectors.toSet());
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> que = new ArrayDeque<>();
        //beginning word at level 1
        List<String> first = new ArrayList<>();
        first.add(beginWord);

        que.add(first);

        while (que.size() > 0) {
            int size = que.size();
            Set<String> wordsToRemove = new HashSet<>();
            while (size-- > 0) {
                List<String> remOrder = que.remove();
                String word = remOrder.getLast();
                if (word.equals(endWord)) {
                    ans.add(remOrder);
                }
                for (int i = 0; i < word.length(); i++) {
                    char[] wordToReplace = word.toCharArray();
                    char original = wordToReplace[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        char temp = wordToReplace[i];
                        wordToReplace[i] = ch;
                        String newWord = new String(wordToReplace);
                        if (set.contains(newWord)) {
                            Set<String> set1 = remOrder.stream().collect(Collectors.toSet());
                            if (!set1.add(newWord)) continue;
                            wordsToRemove.add(newWord);
                            List<String> newOrder = new ArrayList<>(remOrder);
                            newOrder.add(newWord);
                            que.add(newOrder);
                        }
                        wordToReplace[i] = temp;
                    }

                }
            }
            for (String word : wordsToRemove) set.remove(word);
        }

        return ans;
    }

}