package DSA.aniket.BinarySearch.Basics.FindPeakElement.ArrayHashOnePeak;

import DSA.aniket.BinarySearch.Basics.FindPeakElement.FindPeakElement;

public class ArrayHashOnePeak implements FindPeakElement {

    @Override
    public int findPeakElement(int[] arr) {
        //cases
        int n = arr.length;
        if (n == 1) return 0;

        //case 1: If first element is peak element  10 9 8 7
        if (arr[0] > arr[1]) return 0;


        //case 2: If last element is peak element 1 2 3 4 5
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        //else your element will be lie in between

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else {
                //shrink the space
                if (arr[mid] > arr[mid - 1]) {
                    //it means you are on the left side
                    //your answer must lie on the right side..
                    low = mid + 1;
                } else if (arr[mid] > arr[mid + 1]) {
                    //you are on right side
                    high = mid - 1;

                }
            }
        }

        return -1;
    }
}