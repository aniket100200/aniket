# 2643. Row With Maximum Ones

**Difficulty:** `Easy` | **Topics:** `Array`, `Matrix`

## Problem Statement

#### Note: Every Row is Sorted

Given a `m x n` binary matrix `mat`, find the **0-indexed** position of the row that contains the **maximum** count of
ones, and the number of ones in that row.

In case there are multiple rows that have the maximum count of ones, the row with the **smallest row number** should be
selected.

Return an array containing the index of the row, and the number of ones in it.

### Examples

* **Example 1:**
    * **Input:** `mat = [[0,1],[0,1]]`
    * **Output:** `[0,1]`
    * **Explanation:** Both rows have the same number of 1's (1). We return the index of the smaller row, 0.

* **Example 2:**
    * **Input:** `mat = [[0,0,0],[0,1,1]]`
    * **Output:** `[1,2]`
    * **Explanation:** The row indexed 1 has the maximum count of ones (2).

* **Example 3:**
    * **Input:** `mat = [[0,0],[1,1],[0,0]]`
    * **Output:** `[1,2]`
    * **Explanation:** The row indexed 1 has the maximum count of ones (2).

---

## 🚀 Optimal Approach: Matrix Traversal

Since the rows are not guaranteed to be sorted, we cannot use binary search. The most efficient way to solve this is to
simply iterate through the matrix row by row, count the number of $1$s, and update our maximums.

### Algorithm

1. Initialize two variables: `maxOnes = 0` and `maxRowIndex = 0`.
2. Iterate through each row `i` from $0$ to $m-1$.
3. For each row, count the number of $1$s.
4. If the current row's count of $1$s is strictly greater than `maxOnes` (`count > maxOnes`):
    * Update `maxOnes = count`.
    * Update `maxRowIndex = i`.
    * *Note: Because we only update on strictly greater (`>`), if a subsequent row has the same number of $1$s, the
      smaller index is naturally preserved.*
5. Return `[maxRowIndex, maxOnes]`.

### Complexity Analysis

* **Time Complexity:** $O(m \times n)$ where $m$ is the number of rows and $n$ is the number of columns. We must visit
  every element in the matrix once.
* **Space Complexity:** $O(1)$ as we are only using a few variables to keep track of the counts and indices, excluding
  the 2-element array returned.