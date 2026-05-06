# Points to remember

- In will traverse on row and column

# Time Complexity O(N*M)

- as we are are traversing over rows and columns.

# Space Complexity O(1)

- as we are not using any extra space.

# Solution

```java
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == target) return true;
        }
    }
    return false;
}
```