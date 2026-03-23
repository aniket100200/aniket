package DSA.aniket.Stack.CelebrityProblem;

import java.io.*;
import java.util.*;

class Main {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M[][] = new int[N][N];
    for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) M[i][j] = sc.nextInt();
    System.out.println(new Solution().findCelebrity(M, N));
  }
}

class Solution {
  int findCelebrity(int M[][], int n) {
    // compare between two two only you'll left with the one person at last who
    // is potential celebrity
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) st.push(i);

    while (st.size() > 1) {
      int a = st.pop();
      int b = st.pop();

      // let's check
      if (M[a][b] == 1) {
        // this means a knows b means a is not celebrity
        st.push(b);
      } else {
        // as don't know b so b is not celebrity
        st.push(a);
      }
    }

    // you'll only left with one element let's check if everyone knows him
    // and he don't know anyone.

    int pc = st.pop();

    // let's check if he don't know anyone
    for (int i = 0; i < n; i++) {
      if (pc == i) continue;
      if (M[pc][i] == 1) return -1;
      if (M[i][pc] == 0) return -1;
    }

    return pc;
  }
}
