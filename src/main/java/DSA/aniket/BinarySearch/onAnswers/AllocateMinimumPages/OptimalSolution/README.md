# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution

```java
class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        //answer Does Exists
        long low = arr[0];
        long high = 0;

        /**
         * low is pointing to the position of lowest possible answer
         * and we watned to maximise it
         * and high is pointing to highest not possible answer
         * due to opposite polarity high will hold the answer at last
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

    int getStudentCount(long maximumPagesAStudentCanHold, int[] books) {
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
```