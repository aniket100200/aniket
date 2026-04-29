package DSA.aniket.BinarySearch.Basics.FirstAndLastIndex;

import java.util.Arrays;

public class FirstAndLastIndexImpl implements FirstAndLastIndex {

    public static void main(String[] args) {
        FirstAndLastIndexImpl imp = new FirstAndLastIndexImpl();
        System.out.println(Arrays.toString(imp.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    @Override
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);

        if (lb == n || nums[lb] != target) return new int[]{-1, -1};


        return new int[]{lb, upperBound(nums, n, target) - 1};
    }

    public int lowerBound(int[] arr, int n, int target) {
        int pans = n;

        int li = 0, hi = n - 1;

        while (li <= hi) {
            int mid = li + (hi - li) / 2;

            if (arr[mid] >= target) {
                //you have potential value of lowerBound
                pans = mid;
                hi = mid - 1;
            } else li = mid + 1;
        }

        return pans;
    }

    public int upperBound(int[] arr, int n, int target) {
        int pans = n;

        int li = 0, hi = n - 1;

        while (li <= hi) {
            int mid = li + (hi - li) / 2;

            if (arr[mid] > target) {
                //you have potential value of lowerBound
                pans = mid;
                hi = mid - 1;
            } else li = mid + 1;
        }

        return pans;
    }


}