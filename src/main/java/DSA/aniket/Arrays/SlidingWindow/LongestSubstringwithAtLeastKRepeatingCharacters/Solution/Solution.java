package DSA.aniket.Arrays.SlidingWindow.LongestSubstringwithAtLeastKRepeatingCharacters.Solution;

import DSA.aniket.Arrays.SlidingWindow.LongestSubstringwithAtLeastKRepeatingCharacters.LongestSubstringwithAtLeastKRepeatingCharacters;

public class Solution implements LongestSubstringwithAtLeastKRepeatingCharacters {

    @Override
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            int xUniqueKRep = longestXUniqueAndKRepeating(s, k, i);
            ans = Math.max(ans, xUniqueKRep);
        }
        return ans;
    }

    public int longestXUniqueAndKRepeating(String s, int k, int x) {
        int countUnique = 0;
        int countKRepeating = 0;
        int sp = 0;
        int ep = 0;
        int maxLength = 0;
        int[] freq = new int[123];
        while (ep < s.length()) {
            //introduce a new member to the freq array
            char ch = s.charAt(ep);
            freq[ch]++;

            if (freq[ch] == 1) countUnique++;
            if (freq[ch] == k) countKRepeating++;

            /**
             * check if it is invalid
             */

            while (countUnique > x) {
                char del = s.charAt(sp);
                freq[del]--;
                if (freq[del] == 0) countUnique--;
                if (freq[del] == k - 1) countKRepeating--;
                sp++;
            }

            /**
             * here window will be valid here
             * either we not have exactly x unique character or all the character are not repeating k times
             */

            if (countUnique == x && countKRepeating == x) {
                maxLength = Math.max(maxLength, ep - sp + 1);
            }

            /**Expand Your Window*/
            ep++;
        }

        return maxLength;
    }
}