package DSA.aniket.Stack.SmallestNumberFollowingPattern;

import java.io.*;
import java.util.*;

class Solution {
  public String smallestNumber(String str) {
    // write code here
    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (char ch : str.toCharArray()) {
      if (ch == 'd') {
        st.push(count++);
      } else {
        st.push(count++);
        // as soon as you got 'i' you can reverse the numbers and append it so reversing thing stack
        // will do
        while (!st.isEmpty()) {
          sb.append(st.pop());
        }
      }
    }

    st.push(count);
    while (!st.isEmpty()) {
      sb.append(st.pop());
    }

    return sb.toString();
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}
