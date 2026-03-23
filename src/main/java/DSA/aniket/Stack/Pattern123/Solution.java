package DSA.aniket.Stack.Pattern123;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    Pattern123 Obj = new DSA.aniket.Stack.Pattern123.Solutions.OptimalApproach.Solution();
    boolean result = Obj.find132pattern(arr);
    if (result) System.out.println("true");
    else System.out.println("false");
    sc.close();
  }
}
