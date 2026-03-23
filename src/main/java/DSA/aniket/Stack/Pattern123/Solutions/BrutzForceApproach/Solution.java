package DSA.aniket.Stack.Pattern123.Solutions.BrutzForceApproach;

import DSA.aniket.Stack.Pattern123.Pattern123;

public class Solution implements Pattern123 {

  @Override
  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    // will generate subsequences
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (nums[i] < nums[j] && nums[k] < nums[j] && nums[i] < nums[k]) return true;
        }
      }
    }

    return false;
  }
}
