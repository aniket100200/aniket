package DSA.aniket.Stack.LargestAreaHistogram;

import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine().trim());
    String inputLine[] = br.readLine().trim().split(" ");
    long[] arr = new long[(int) n];
    for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
    System.out.println(new Solution().maximumArea(arr, n));
  }
}

class Solution {
  public static long maximumArea(long hist[], long n) {
    // If I'm able to find the next smaller elment to right and left
    // with height and width I can find the Area for perticular height in the histogram

    // let's do it using monotonic stack
    Stack<Integer> st = new Stack<>();
    // will look for the next smaller element in the right

    long ans = 0; // area never be negative

    for (int i = 0; i < hist.length; i++) {
      long ele = hist[i];
      // so in the stack elements will be there in asceding order increasing order
      while (st.size() > 0 && ele < hist[st.peek()]) {
        int idx = st.pop();
        // for this index
        int rb = i;
        int lb = -1;
        if (st.size() > 0) lb = st.peek();

        int width = rb - lb - 1;
        long height = hist[idx];
        long area = (long) width * height;
        ans = Math.max(area, ans);
      }

      // I'll be looking for the smaller element for it'sself as well
      st.push(i);
    }

    // here means were not able to find the smaller elment
    // elment in the stack are sorted in asceding order from bottom to top.

    while (st.size() > 0) {
      int idx = st.pop();
      int rb = hist.length;
      int lb = -1;
      if (st.size() > 0) lb = st.peek();

      int width = rb - lb - 1;
      long height = hist[idx];
      long area = (long) width * height;
      ans = Math.max(area, ans);
    }

    return ans;
  }
}
