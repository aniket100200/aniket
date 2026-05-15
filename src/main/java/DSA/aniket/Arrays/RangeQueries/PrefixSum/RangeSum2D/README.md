# Range Sum Query 2D - Immutable

**Difficulty:** Medium  
**Topics:** Array, Design, Matrix, Prefix Sum

## Problem Description

Given a 2D matrix `matrix`, handle multiple queries of the following type:
Calculate the **sum** of the elements of `matrix` inside the rectangle defined by its **upper left corner**
`(row1, col1)` and **lower right corner** `(row2, col2)`.

Implement the `NumMatrix` class:

* `NumMatrix(int[][] matrix)` Initializes the object with the integer matrix `matrix`.
* `int sumRegion(int row1, int col1, int row2, int col2)` Returns the sum of the elements of `matrix` inside the
  rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.

**Note:** You must design an algorithm where `sumRegion` works in **O(1)** time complexity.

---

## Examples

### Example 1:

**Input:**

```text
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
```

```
int[][] matrix = {
{3, 0, 1, 4, 2},
{5, 6, 3, 2, 1},
{1, 2, 0, 1, 5},
{4, 1, 0, 1, 7},
{1, 0, 3, 0, 5}
};
```

NumMatrix numMatrix = new NumMatrix(matrix);

// return 8 (sum of rectangle from (2,1) to (4,3))
numMatrix.sumRegion(2, 1, 4, 3);

// return 11 (sum of rectangle from (1,1) to (2,2))
numMatrix.sumRegion(1, 1, 2, 2);

// return 12 (sum of rectangle from (1,2) to (2,4))
numMatrix.sumRegion(1, 2, 2, 4);