package DSA.aniket.Queue.SlidingWindowMaximum.Solutions.OptimalApproach;

import DSA.aniket.Queue.SlidingWindowMaximum.SlidingWindowMaximum;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution implements SlidingWindowMaximum {

  @Override
  public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
    Deque<Integer> dq = new ArrayDeque<>(); // I'm using it like a stack
    // as we are calculating the next greater element withing the window.
    // my window size will K
    // we are using the power of monotonic Stack
    // we are using Deque as stack with addLast() and RemoveLast() operations
    int[] ans = new int[n - k + 1];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      // I'll have to remove the scrap
      while (dq.size() > 0 && i - dq.getFirst() >= k) dq.removeFirst();
      // as we are looking for next greater element in the stack
      int ele = nums[i];
      while (dq.size() > 0 && ele > nums[dq.getLast()])
        dq.removeLast(); // as they are smaller than me means they are useless
      dq.addLast(i);
      // now when to start calculating answers..
      if (i >= k - 1) {
        ans[idx++] = nums[dq.getFirst()];
      }
    }

    return ans;
  }
}
