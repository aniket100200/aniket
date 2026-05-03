package DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages.AllocateMinimumPages;

public class OptimalSolution implements AllocateMinimumPages {

    @Override
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        //answer Does Exists
        long low = arr[0];
        long high = 0;

        /**
         * low is pointing to the Not possible answer
         * and we watned to minimize it
         *  and high is pointing to highest possible answer
         * due to opposite polarity low will hold the answer at last
         */
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }
        //let's apply binary Search

        while (low <= high) {
            long mid = low + (high - low) / 2;
            int studentCount = getStudentCount(mid, arr);
            if (studentCount > k) low = mid + 1;
            else high = mid - 1;
        }

        return (int) low;
    }
}