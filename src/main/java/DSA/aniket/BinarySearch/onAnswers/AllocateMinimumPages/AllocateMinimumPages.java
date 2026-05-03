package DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages;

public interface AllocateMinimumPages {
    int findPages(int[] arr, int k);

    default int getStudentCount(long maximumPagesAStudentCanHold, int[] books) {
        int studentCount = 1;
        int pageAllocatedToCurrentStudent = 0;

        for (int pages : books) {
            if (pageAllocatedToCurrentStudent + pages <= maximumPagesAStudentCanHold) {
                pageAllocatedToCurrentStudent += pages;
            } else {
                studentCount++;
                pageAllocatedToCurrentStudent = pages;
            }
        }

        return studentCount;

    }
}