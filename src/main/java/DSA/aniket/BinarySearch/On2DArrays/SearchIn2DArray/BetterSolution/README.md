# Points to remember

- We'll be traversing over the row and as every row is sorted we'll appy binary search over there.

# Time Complexity O(N*log(M))

- as we are traversing and applying Binary Search
- for traversing N rows and for each row binary search of log(M)

# Space Complexity O(N)

- as we are

# Solution

```java
 public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length;
    for (int i = 0; i < n; i++) {
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;

            if (matrix[i][mid] == target) return true;
            else if (matrix[i][mid] < target) low = mid + 1;
            else high = mid - 1;
        }
    }
    return false;
}
```