package DSA.aniket.Hashing.LongestSubArrayWithEquqalFrequecies;

import java.util.*;

public class Solution implements LongestSubArrayWithEquqalFrequecies {

  @Override
  public int longestSubarray(int[] arr) {
    int n = arr.length;
    Map<String, Integer> map = new HashMap<>();
    map.put("0#0", -1);
    int count0 = 0;
    int count1 = 0;
    int count2 = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) count0++;
      else if (arr[i] == 1) count1++;
      else count2++;

      String key = (count2 - count1) + "#" + (count1 - count0);
      if (map.containsKey(key)) {
        int dist = i - map.get(key);
        if (dist > ans) ans = dist;
      }

      if (!map.containsKey(key)) map.put(key, i);
    }

    return ans;
  }
}
