package DSA.aniket.TwoPointers.TwoSum.onSortedArray;

import DSA.aniket.TwoPointers.TwoSum.TwoSum;

public class OnSortedArray implements TwoSum {

    @Override
    public int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                return new int[]{left + 1, right + 1};
            }

            if (arr[left] + arr[right] > target) right--;
            else left++;
        }
        return new int[]{-1, -1};
    }
}