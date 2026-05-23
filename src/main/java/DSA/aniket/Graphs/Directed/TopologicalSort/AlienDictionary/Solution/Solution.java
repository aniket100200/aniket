package DSA.aniket.Graphs.Directed.TopologicalSort.AlienDictionary.Solution;

import DSA.aniket.Graphs.Directed.TopologicalSort.AlienDictionary.AlienDictionary;

import java.util.*;

public class Solution implements AlienDictionary {
    @Override
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!map.containsKey(ch)) map.put(ch, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            boolean isInvalid = createAdj(words[i - 1], words[i], map);
            if (isInvalid) return "";
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> pathVisited = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for (char ch : map.keySet()) {
            if (!visited.contains(ch)) {
                boolean isCyclic = dfs(ch, map, visited, pathVisited, st);
                if (isCyclic) return "";


            }
        }

        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) sb.append(st.pop());

        return sb.toString();
    }

    boolean dfs(char node, Map<Character, Set<Character>> map, Set<Character> visited, Set<Character> pathVisited, Stack<Character> st) {
        visited.add(node);
        pathVisited.add(node);
        for (char neighbour : map.get(node)) {
            if (pathVisited.contains(neighbour)) return true;

            if (!visited.contains(neighbour)) {
                boolean isCyclic = dfs(neighbour, map, visited, pathVisited, st);
                if (isCyclic) return true;
            }
        }
        pathVisited.remove(node);
        st.push(node);

        return false;
    }

    public boolean createAdj(String s1, String s2, Map<Character, Set<Character>> map) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            char ch = s1.charAt(i);
            var ct = s2.charAt(i);
            if (ch != ct) {
                map.get(ch).add(ct);
                return false;
            }
        }

        if (s1.length() > s2.length()) return true;


        return false;


    }
}