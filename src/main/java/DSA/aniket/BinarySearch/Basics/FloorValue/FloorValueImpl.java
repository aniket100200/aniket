package DSA.aniket.BinarySearch.Basics.FloorValue;

public class FloorValueImpl implements FloorValue {

    @Override
    public int findFloorValue(int[] arr, int target) {
        int n = arr.length;

        int li = 0, hi = n - 1;

        int pans = -1;

        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (arr[mid] == target) return target;
            else if (arr[mid] < target) {
                pans = arr[mid];
                li = mid + 1;
            } else
                hi = mid - 1;
        }

        return pans;
    }
}