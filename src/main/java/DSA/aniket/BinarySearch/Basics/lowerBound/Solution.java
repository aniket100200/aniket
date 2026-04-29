package DSA.aniket.BinarySearch.Basics.lowerBound;

public class Solution implements LowerBound {
    @Override
    public int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int li = 0, hi = n - 1;

        int pans = n;

        while (li <= hi) {

            int mid = li + (hi - li) / 2;

            if (arr[mid] >= target) {
                //this will be your pans;
                pans = mid;
                //you'll be moving left as you wanted to find lower bound
                hi = mid - 1;

            } else li = mid + 1;
        }

        return pans;
    }
}
