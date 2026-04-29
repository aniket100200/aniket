package DSA.aniket.BinarySearch.Basics.RotationCount.SolutionWithFindindMinimumInRotatedSortedArray;

import DSA.aniket.BinarySearch.Basics.RotationCount.RotationCount;


public class SolutionWithFindindMinimumInRotatedSortedArray implements RotationCount {

    @Override
    public int findKRotation(int[] arr) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            //you'll have search for sorted region always

            if (arr[low] <= arr[mid]) {
                //left half is sorted..
                if (arr[low] < min) {
                    min = arr[low];
                    minIndex = low;
                }

                //you can search in unexplored region

                low = mid + 1;
            } else {
//                arr[mid]  <= arr [high]

                if (arr[mid] < min) {
                    min = arr[mid];
                    minIndex = mid;
                }

                high = mid - 1;
            }
        }
        return minIndex;
    }
}