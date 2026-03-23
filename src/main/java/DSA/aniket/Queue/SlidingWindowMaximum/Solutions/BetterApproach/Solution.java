package DSA.aniket.Queue.SlidingWindowMaximum.Solutions.BetterApproach;

import DSA.aniket.Queue.SlidingWindowMaximum.SlidingWindowMaximum;
import java.util.Stack;

public class Solution implements SlidingWindowMaximum {

  @Override
  public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
    // there will n-k+1 subarrays..
    int[] ans = new int[n - k + 1];
    // we'll use Stack approach
    // we'll calculate the ngeri element
    int[] ngeri = nextGreaterElement(nums, n);
    // as there will be total n-k+1 windows
    int j = 0;
    for (int i = 0; i < ans.length; i++) {
      if (j < i) j = i;
      while (ngeri[j] < i + k) j = ngeri[j];

      ans[i] = nums[j];
    }

    return ans;
  }

  public int[] nextGreaterElement(int[] arr, int n) {
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int ele = arr[i];
      while (st.size() > 0 && ele > arr[st.peek()]) {
        ans[st.pop()] = i;
      }
      st.push(i);
    }

    while (st.size() > 0) {
      ans[st.pop()] = n;
    }

    return ans;
  }
}
