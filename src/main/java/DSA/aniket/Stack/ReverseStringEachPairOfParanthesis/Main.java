package DSA.aniket.Stack.ReverseStringEachPairOfParanthesis;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s) {
    // your code here
    Stack<Character> st = new Stack<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == ')') {
        Queue<Character> que = new ArrayDeque<>();
        while (!st.isEmpty() && st.peek() != '(') {
          que.add(st.pop());
        }
        st.pop();

        while (que.size() > 0) st.push(que.poll());

      } else {
        st.push(ch);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : st) sb.append(ch);

    return sb.toString();
  }
}
