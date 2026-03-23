package DSA.aniket.Hashing.MinimumWindowSubstring;

import java.util.*;

public class Solution implements MinimumWindowSubstring {
  @Override
  public String minWindow(String s, String t) {
    // write code here
    // you have to find the String t in the s
    Map<Character, Integer> sMap = new HashMap<>();

    Map<Character, Integer> tMap = new HashMap<>();

    for (char ch : t.toCharArray()) {
      tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
    }

    int dmcnt = t.length();
    int mcnt = 0;

    int inc = -1;
    int exc = -1;

    String ans = "";

    int n = s.length();
    while (true) {

      boolean toBreak = true;
      while (inc + 1 < n && mcnt < dmcnt) {
        toBreak = false;
        inc++;
        char ch = s.charAt(inc);
        // I'll put the char in the Map
        sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        if (tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)) {
          mcnt++;
        }
      }

      while (exc < inc && mcnt == dmcnt) {
        toBreak = false;
        // will try to exclude the element as I wanted the minimum substring
        // before excluding
        // let's calculate the answer
        String pans = s.substring(exc + 1, inc + 1);
        if (ans.length() == 0 || pans.length() < ans.length()) {
          ans = pans;
        }

        exc++;
        char ch = s.charAt(exc);
        sMap.put(ch, sMap.get(ch) - 1);
        if (tMap.containsKey(ch) && tMap.get(ch) > sMap.get(ch)) {
          // you have excluded important character..
          mcnt--;
        }

        if (sMap.get(ch) == 0) sMap.remove(ch);
      }

      if (toBreak) break;
    }

    return ans;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s, t;
    s = sc.next();
    t = sc.next();
    Solution Obj = new Solution();
    System.out.println(Obj.minWindow(s, t));
  }
}
