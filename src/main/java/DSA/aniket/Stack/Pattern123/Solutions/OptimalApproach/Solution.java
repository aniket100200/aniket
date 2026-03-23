package DSA.aniket.Stack.Pattern123.Solutions.OptimalApproach;

import DSA.aniket.Stack.Pattern123.Pattern123;
import java.util.Stack;

public class Solution implements Pattern123 {

  @Override
  public boolean find132pattern(int[] nums) {
    // we'll use stack to compare the values
    int n = nums.length;
    int[] prevMin = new int[n];
    int min = nums[0];
    for (int i = 0; i < n; i++) {
      prevMin[i] = min;
      min = Math.min(min, nums[i]);
    }

    Stack<Integer> st = new Stack<>();
    // you would have found the minimum value left
    // let's go in reverse order
    for (int i = n - 1; i >= 0; i--) {
      int ele = nums[i];
      int minToLeft = prevMin[i];
      if (minToLeft < ele) {
        // means you satisfy your first condition
        // now from stack try to remove all the elements which are lesser than the minToLeft
        while (st.size() > 0 && minToLeft >= st.peek()) st.pop();

        if (st.size() > 0 && ele > st.peek()) return true; // you satisfy all the conditions
      }

      st.push(nums[i]);
    }

    return false;
  }
}
