package DSA.aniket.Stack.Subarray_SUM_MINIMUM;

import java.util.*;

class Solution {
  final long mod = 1000000007;

  public long minSubarraySum(int n, int a[]) {
    // write code here
    // let's use the monotonic stack

    Stack<Integer> st = new Stack<>();
    long ans = 0;
    for (int i = 0; i < n; i++) {
      // I've to find the next smaller element to left and right
      // to calculate noOfSubarray where that perticular element is minimum
      // noOfSubarraysWhereElementAtIdxWill be mininmum is = (idx-lb)*(rb-idx);

      int ele = a[i];
      while (st.size() > 0 && ele < a[st.peek()]) {
        // got the right boundry
        int idx = st.pop();
        int rb = i;
        int lb = -1;
        if (st.size() > 0) lb = st.peek();

        int noOfSubarray = (idx - lb) * (rb - idx);
        ans = (ans % mod + (noOfSubarray % mod * a[idx] % mod) % mod) % mod;
      }

      // current element will also looks for next smaller element
      st.push(i);
    }

    // there will be some elements who didn't found their next smallest element so for them
    // rb will n
    while (st.size() > 0) {
      int idx = st.pop();
      int rb = n;
      int lb = -1;
      if (st.size() > 0) lb = st.peek();

      int noOfSubArrays = (idx - lb) * (rb - idx);
      ans = (ans % mod + (noOfSubArrays % mod * a[idx] % mod) % mod) % mod;
    }

    return ans % mod;
  }
}

public class Main {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    Solution Obj = new Solution();
    System.out.println(Obj.minSubarraySum(n, a));
  }
}
