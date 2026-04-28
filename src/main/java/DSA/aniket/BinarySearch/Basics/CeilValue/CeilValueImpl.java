package DSA.aniket.BinarySearch.Basics.CeilValue;

public class CeilValueImpl implements CeilValue {

    @Override
    public int findCeil(int[] arr, int target) {
        int n = arr.length;
        int li = 0, hi = n - 1;
        int pans = -1;

        while (li <= hi) {

            int mid = li + (hi - li) / 2;

            if (arr[mid] >= target) {
                pans = arr[mid];
                hi = mid - 1;
            } else li = mid + 1;

        }
        return pans;
    }
}