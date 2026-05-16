package DSA.aniket.Arrays.SlidingWindow.MinimumWindowSubstring.Solution;


import DSA.aniket.Arrays.SlidingWindow.MinimumWindowSubstring.MinimumWindowSubstring;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class Solution implements MinimumWindowSubstring {

    @Override
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        if (s.length() < t.length()) return "";

        int[] sMap = new int[60];
        int[] tMap = new int[60];
        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i) - 'A']++;
        }

        int sp = -1, ep = -1;
        String ans = "";

        while (true) {

            boolean isFirst = false, isSecond = false;
            while (ep + 1 < s.length() && !isValidSubstring(sMap, tMap)) {
                ep++;
                char ch = s.charAt(ep);
                sMap[ch - 'A']++;
                isFirst = true;
            }

            while (sp + 1 <= ep && isValidSubstring(sMap, tMap)) {
                sp++;
                String pans = s.substring(sp, ep + 1);

                if (ans.isBlank() || ans.length() > pans.length()) {
                    ans = pans;
                }

                char ch = s.charAt(sp);

                sMap[ch - 'A']--;
                isSecond = true;
            }

            if (!isFirst && !isSecond) break;


        }

        return ans;
    }

    public boolean isValidSubstring(int[] sMap, int[] tMap) {
        for (int i = 0; i < 60; i++) {
            if (tMap[i] == 0) continue;

            if (tMap[i] > sMap[i]) return false;
        }
        return true;
    }
}