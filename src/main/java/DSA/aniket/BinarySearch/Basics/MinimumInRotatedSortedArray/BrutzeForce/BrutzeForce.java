package DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray.BrutzeForce;

import DSA.aniket.BinarySearch.Basics.MinimumInRotatedSortedArray.MinimumInRotatedSortedArray;

public class BrutzeForce implements MinimumInRotatedSortedArray {

    @Override
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0, high = n - 1;
        //minimum will be there in the array

        int min = Integer.MAX_VALUE;

        //you need to look for sorted region
        while (low <= high) {
            int mid = low + (high - low) / 2;

            //you have to look for sorted region..

            if (nums[low] <= nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) {
                //left region is sorte

                min = Math.min(nums[low], min);
                //I'll go right I'll be greedy  to find element in right half because it's not sorted so our small element may lie on the right side..
                low = mid + 1;
            } else {
                //right region is sorted..
                min = Math.min(nums[mid], min);

                high = mid - 1;

            }


        }
        return min;
    }
}