package DSA.aniket.Stack.InfixEvaluationAndConversion;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob = new Solution();
    ob.evaluate(exp);
  }
}

class Solution {
  public int getPrecedance(char ch) {
    if (ch == '*' || ch == '/') return 2;
    if (ch == '+' || ch == '-') return 1;

    return 0;
  }

  public void evaluate(String exp) {
    // Write code here
    Stack<Integer> opd = new Stack<>();
    Stack<Character> opr = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<String> pre = new Stack<>();
    for (char ch : exp.toCharArray()) {
      if (Character.isDigit(ch)) {
        opd.push(ch - '0');
        post.push("" + ch);
        pre.push(ch + "");
      } else if (ch == '(') {
        opr.push(ch);
      } else if (ch == ')') {
        // I've to solve the elements present in the opd and operator stack
        while (opr.size() > 0 && opr.peek() != '(') {
          char operator = opr.pop();
          int b = opd.pop();
          int a = opd.pop();

          opd.push(solve(a, operator, b, pre, post));
        }

        opr.pop();
      } else {
        // It'll be operator for sure.. -+/*
        // you'll need  precedance here for each

        if (opr.size() > 0 && opr.peek() != '(' && getPrecedance(ch) <= getPrecedance(opr.peek())) {
          char operator = opr.pop();
          int b = opd.pop();
          int a = opd.pop();
          opd.push(solve(a, operator, b, pre, post));
        }
        opr.push(ch);
      }
    }

    while (opr.size() > 0) {
      // here you won't find any other
      char operator = opr.pop();
      int b = opd.pop();
      int a = opd.pop();
      opd.push(solve(a, operator, b, pre, post));
    }

    System.out.println(opd.pop());
    System.out.println(post.pop());
    System.out.println(pre.pop());
  }

  public int solve(int a, char opr, int b, Stack<String> pre, Stack<String> post) {
    {
      String s2 = pre.pop();
      String s1 = pre.pop();
      pre.push(opr + s1 + s2);
    }

    {
      String s2 = post.pop();
      String s1 = post.pop();
      post.push(s1 + s2 + opr);
    }

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
