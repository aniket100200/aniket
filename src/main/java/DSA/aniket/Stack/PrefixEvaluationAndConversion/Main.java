package DSA.aniket.Stack.PrefixEvaluationAndConversion;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    valueOfExpression(str);
  }

  public static void valueOfExpression(String str) {
    // your code here
    // always go from the number sides
    Stack<Character> opr = new Stack<>();
    Stack<Integer> opd = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<String> post = new Stack<>();

    int n = str.length();

    for (int i = n - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)) {
        opd.push(ch - '0');
        in.push("" + ch + "");
        post.push("" + ch);
      } else {
        // if it's Character then resolve in
        int a = opd.pop();
        int b = opd.pop();
        opd.push(solve(a, b, ch, in, post));
      }
    }

    System.out.println(opd.pop());
    System.out.println(in.pop());
    System.out.println(post.pop());
  }

  public static int solve(int a, int b, char opr, Stack<String> in, Stack<String> post) {

    // handle for infix
    String first = in.pop();
    String last = in.pop();
    in.push("(" + first + opr + last + ")");

    // handle for postfix
    first = post.pop();
    last = post.pop();

    post.push(first + last + opr);

    switch (opr) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
      default:
        return -1;
    }
  }
}
