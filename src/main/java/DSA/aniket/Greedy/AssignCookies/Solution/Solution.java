package DSA.aniket.Greedy.AssignCookies.Solution;

import DSA.aniket.Greedy.AssignCookies.AssignCookies;

import java.util.Arrays;

public class Solution implements AssignCookies {

    /**
     * @param g
     * @param s
     * @return
     */
    @Override
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        int count = 0;
        while (r < m) {
            if (l < n) {
                if (s[r] >= g[l]) {
                    r++;
                    l++;
                    count++;
                } else {
                    r++;
                }
            } else {
                r++;
            }
        }
        return count;
    }
}