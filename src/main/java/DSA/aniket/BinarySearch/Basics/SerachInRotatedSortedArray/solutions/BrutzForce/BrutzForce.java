package DSA.aniket.BinarySearch.Basics.SerachInRotatedSortedArray.solutions.BrutzForce;

import DSA.aniket.BinarySearch.Basics.SerachInRotatedSortedArray.SerachInRotatedSortedArray;

public class BrutzForce implements SerachInRotatedSortedArray {

    @Override
    public int search(int[] arr, int target) {
        /**
         *  Identify the Sorted Region
         */

        int n = arr.length;

        int li = 0, hi = n - 1;

        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[li] <= arr[mid])//it means left half is sorted..
            {
                if (arr[li] <= target && target <= arr[mid]) {
                    //it should lie on the left
                    hi = mid - 1;
                } else {
                    //it's present in unsorted region
                    li = mid + 1;
                }

            } else {
                //right half is sorted
                if (arr[mid] <= target && target <= arr[hi]) {
                    //it is on the right side
                    li = mid + 1;
                } else hi = mid - 1;

            }
        }
        return -1;
    }
}