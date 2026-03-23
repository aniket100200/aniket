package DSA.aniket.Queue.CircularTour;

import DSA.aniket.Queue.CircularTour.Solutions.GreedyApproach.Solution;
import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        int d[] = new int[n];
        int j=0;
        int k=0;

        for(int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(new Solution().tour(p,d));
    }
}