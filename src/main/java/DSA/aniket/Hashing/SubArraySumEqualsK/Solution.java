package DSA.aniket.Hashing.SubArraySumEqualsK;

import java.io.*;
import java.util.*;

public class Solution {
  public int subarraySum(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      int key = sum - k;
      if (map.containsKey(key)) {
        ans = ans + map.get(key);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return ans;
  }
}

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int N = Integer.parseInt(br.readLine().trim());
    String[] arr_Arr = br.readLine().split(" ");
    int[] Arr = new int[N];
    for (int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++) {
      Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
    }
    int K = Integer.parseInt(br.readLine().trim());

    int out_ = new Solution().subarraySum(Arr, K);
    System.out.println(out_);

    wr.close();
    br.close();
  }
}
