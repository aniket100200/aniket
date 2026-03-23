package DSA.aniket.Stack.ReverseInteger;

import java.util.*;

class Solution {
  public int reverse(int x) {

    long ans = 0;
    while (x != 0) {
      ans = ans * 10 + x % 10;
      x /= 10;
    }

    if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;

    return (int) ans;
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    Solution obj = new Solution();
    System.out.println(obj.reverse(x));
  }
}
