package DSA.aniket.Stack.TrappingRainWater.Soutions.OptimalApproach;

public class Solution {
  public int trap(int[] height) {
    // let's use two pointer approach
    int leftBoundary = height[0];
    int n = height.length;
    int rightBoundary = height[n - 1];
    int left = 1;
    int right = n - 2;
    int total = 0;
    while (left <= right) {
      if (leftBoundary <= rightBoundary) {
        // the you can solve the left one you can fill your left bucket
        if (height[left] > leftBoundary) {
          // so the current element will become the leftBoundary
          leftBoundary = height[left];
        } else {
          // you can calculate the answer
          int heightOfMine = height[left];
          int heightOfWaterAboveMe = leftBoundary - heightOfMine;
          total += heightOfWaterAboveMe;
        }
        left++;
      } else {
        // right boundary is less than left boundary..
        // it means we can calculate the answer if rightBoundary is greater than us
        if (rightBoundary > height[right]) {
          int heightOfMine = height[right];
          int heightOfWaterAboveMe = rightBoundary - heightOfMine;
          total += heightOfWaterAboveMe;

        } else {
          rightBoundary = height[right];
        }

        right--;
      }
    }

    return total;
  }
}
