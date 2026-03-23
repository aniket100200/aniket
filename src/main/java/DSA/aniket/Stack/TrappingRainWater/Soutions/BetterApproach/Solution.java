package DSA.aniket.Stack.TrappingRainWater.Soutions.BetterApproach;

import java.util.Stack;

public class Solution {
  public int trap(int[] height) {
    // will be using power of monotonic stack
    Stack<Integer> st = new Stack<>();
    int n = height.length;
    int total = 0;

    // we are finding the element next greater element to right index wise
    // stack will be sorted in descending order
    for (int i = 0; i < n; i++) {
      int ele = height[i];
      while (st.size() > 0 && ele >= height[st.peek()]) {
        int rightBoundary = ele;
        int heightOfTheColumn = height[st.pop()];

        if (st.size() > 0) {
          int leftBoundary = height[st.peek()];
          int width = i - st.peek() - 1;
          int minColumn = Math.min(leftBoundary, rightBoundary);

          int waterAboveMe = minColumn - heightOfTheColumn;
          total += (width * waterAboveMe);
        }
      }

      st.push(i);
    }

    return total;
  }
}
