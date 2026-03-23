package DSA.aniket.Queue.SlidingWindowMaximum.Solutions.BrutzForce;

import DSA.aniket.Queue.SlidingWindowMaximum.SlidingWindowMaximum;

public class Solution implements SlidingWindowMaximum {
  @Override
  public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
    // generate all the subarrays of Size k
    // there will n-k+1;
    int[] ans = new int[n - k + 1];

    for (int i = 0; i <= n - k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, nums[j]);
      }
      ans[i] = max;
    }

    return ans;
  }
}
