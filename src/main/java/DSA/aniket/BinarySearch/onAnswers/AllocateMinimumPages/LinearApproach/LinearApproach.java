package DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages.LinearApproach;

import DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages.AllocateMinimumPages;

public class LinearApproach implements AllocateMinimumPages {

    @Override
    public int findPages(int[] arr, int k) {

        int n = arr.length;
        if (k > n) return -1;

        /**
         * let's decide the range
         * low = if you get max -> then each student can hold at least a book as questions say's each student should have one book.
         * high= if you give all the books to one single student
         *
         */

        int minPages = arr[0];
        int maxPages = Integer.MAX_VALUE;

        for (int page : arr) {
            minPages = Math.max(page, minPages);
        }

        for (int pages = minPages; pages <= maxPages; pages++) {
            if (getStudentCount(pages, arr) == k) return pages;
        }

        return -1;
    }
}