package DSA.aniket.Stack.TrappingRainWater;

import DSA.aniket.Stack.TrappingRainWater.Soutions.OptimalApproach.Solution;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    /*
    BrutzForce approach
     */
    DSA.aniket.Stack.TrappingRainWater.Soutions.BrutzForce.Solution solution =
        new DSA.aniket.Stack.TrappingRainWater.Soutions.BrutzForce.Solution();
    System.out.println("Brutz Force-->" + solution.TappingWater(arr, n));

    /*
       Better Approach
    */

    DSA.aniket.Stack.TrappingRainWater.Soutions.BetterApproach.Solution obj2 =
        new DSA.aniket.Stack.TrappingRainWater.Soutions.BetterApproach.Solution();
    System.out.println("Better-->" + obj2.trap(arr));

    /*
        Optimal Approach
    */
    Solution Obj = new Solution();
    System.out.println("Optimal-->" + Obj.trap(arr));

    sc.close();
  }
}
