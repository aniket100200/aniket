# Points to remember

- It will be solved using

# Time Complexity O(log(N+M))

- as we are doing binary search to find the row where the targe is present
- it take log(N)
- and binary search to find the the target in the row take log(M)
- overall Time Complexity will be `log(N+M)`
- as log(a) * log(b) = log(a+b)

# Space Complexity O(1)

- as we are not using any exta space.

# Solution

```java
 public boolean searchMatrix(int[][] matrix, int target) {
    //search first in which row it lies
    int low = 0, high = matrix.length - 1;
    int lastColumn = matrix[0].length - 1;
    while (low <= high) {
        int midRow = (low + high) / 2;

        if (target >= matrix[midRow][0] && target <= matrix[midRow][lastColumn]) {
            int li = 0, hi = matrix[midRow].length - 1;

            while (li <= hi) {
                int midColumn = (li + hi) >> 1;
                if (matrix[midRow][midColumn] == target) return true;
                else if (matrix[midRow][midColumn] < target) li = midColumn + 1;
                else hi = midColumn - 1;
            }
            return false;
        } else if (matrix[midRow][0] < target) low = midRow + 1;
        else high = midRow - 1;
    }
    return false;
}
```