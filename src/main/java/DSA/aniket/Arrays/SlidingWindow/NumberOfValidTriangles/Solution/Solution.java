package DSA.aniket.Arrays.SlidingWindow.NumberOfValidTriangles.Solution;

import DSA.aniket.Arrays.SlidingWindow.NumberOfValidTriangles.NumberOfValidTriangles;

import java.util.Arrays;

public class Solution implements NumberOfValidTriangles {

    @Override
    public int validTriangles(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] <= arr[i]) {
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}