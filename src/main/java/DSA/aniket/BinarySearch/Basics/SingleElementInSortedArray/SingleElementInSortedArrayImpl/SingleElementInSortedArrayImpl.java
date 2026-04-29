package DSA.aniket.BinarySearch.Basics.SingleElementInSortedArray.SingleElementInSortedArrayImpl;

import DSA.aniket.BinarySearch.Basics.SingleElementInSortedArray.SingleElementInSortedArray;

public class SingleElementInSortedArrayImpl implements SingleElementInSortedArray {

    @Override
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        if (nums[0] != nums[1]) return nums[0]; // if first element
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1]; //if last element is single
        int low = 1, high = n - 2;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid % 2 == 0 && nums[mid + 1] == nums[mid]) || (mid % 2 == 1 && nums[mid - 1] == nums[mid])) {
                low = mid + 1;
            } else high = mid - 1;

        }
        return -1;
    }
}