package DSA.aniket.BinarySearch.Basics.upperBound;

public class Solution implements UpperBound {
    public static void main(String[] args) {
        System.out.println("Running upperBound...");
    }

    /**
     *
     * @param arr where arr[index] > tar
     * @param tar
     * @return
     */
    @Override
    public int upperBound(int[] arr, int tar) {
        int n = arr.length;
        int li = 0, hi = n - 1;
        int pans = n;

        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (arr[mid] > tar) {
                pans = mid;
                hi = mid - 1;
            } else li = mid + 1;
        }

        return pans;
    }
}
