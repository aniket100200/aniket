package DSA.aniket.Stack.TrappingRainWater.Soutions.BrutzForce;

public class Solution {
  public int TappingWater(int[] arr, int n) {
    // Write code here and print output
    // If I'm able to find the next and previous greater element
    // then I can decide how much unit of water can be store above me
    int[] prevGreater = new int[n];
    int[] nextGreater = new int[n];
    // you need at least three elements
    int prevMax = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      prevGreater[i] = prevMax;
      prevMax = Math.max(prevMax, arr[i]);
    }

    // You'll have the elements with their previous greater element on left
    // now find on the right side as well
    int ngri = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      nextGreater[i] = ngri;
      ngri = Math.max(arr[i], ngri);
    }

    // now you have the right boundary and left boundary so you can calculate the
    // water above you
    int total = 0;
    for (int i = 1; i < n - 1; i++) {
      int left = prevGreater[i];
      int right = nextGreater[i];
      int min = Math.min(left, right); // till both of these
      if (min > arr[i]) {
        // then I can store some water above me
        int amountOfWaterAboveMe = min - arr[i];
        total += amountOfWaterAboveMe;
      }
    }

    return total;
  }
}
