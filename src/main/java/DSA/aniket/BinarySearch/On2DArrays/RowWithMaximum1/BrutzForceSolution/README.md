# Points to remember

- This is a Linear Approach
- where you traversing every row and column.
- where you count 1's in each row.

# Time Complexity O(N*M)

- as we are

# Space Complexity O(1)

- as we are not using any extra space.

# Solution

```java
 public int[] rowAndMaximumOnes(int[][] mat) {
    //traverse through all the rows..
    int row_index = 0;
    int count_1 = 0;
    for (int i = 0; i < mat.length; i++) {
        int count = 0;
        for (int j = 0; j < mat[0].length; j++) {
            count += mat[i][j];
        }

        if (count > count_1) {
            count_1 = count;
            row_index = i;
        }
    }

    return new int[]{row_index, count_1};
}
```