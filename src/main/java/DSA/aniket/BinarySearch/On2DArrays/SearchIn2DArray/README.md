# 74. Search a 2D Matrix

**Difficulty:** `Medium` | **Topics:** `Array`, `Binary Search`, `Matrix`

## Problem Statement

You are given an `m x n` integer matrix `matrix` with the following two properties:

1. Each row is sorted in non-decreasing order.
2. The first integer of each row is greater than the last integer of the previous row.

Given an integer `target`, return `true` if `target` is in `matrix` or `false` otherwise.

You must write a solution in **$O(\log(m \times n))$** time complexity.

### Examples

* **Example 1:**
    * **Input:** `matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]`, `target = 3`
    * **Output:** `true`

* **Example 2:**
    * **Input:** `matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]`, `target = 13`
    * **Output:** `false`

---

## 🚀 Optimal Approach: 1D Virtual Binary Search

Because the last element of a row is strictly smaller than the first element of the next row, if we were to lay all the
rows out end-to-end, they would form a single, perfectly sorted 1D array of length $m \times n$.

To achieve $O(\log(m \times n))$ time complexity, we perform a standard binary search on this "virtual" 1D array.

### Core Concept: Index Mapping

We don't actually need to create a 1D array (which would take $O(m \times n)$ space). Instead, we map the 1D index back
to the 2D matrix coordinates on the fly.
Let `n` be the number of columns.
For any 1D index `i`:

* **Row Index:** `i / n` (Integer division)
* **Col Index:** `i % n` (Modulo operator)

### Algorithm

1. Check for empty edge cases (if matrix length is 0 or columns length is 0).
2. Set up pointers for the virtual 1D array:
    * `low = 0`
    * `high = (m * n) - 1`
3. While `low <= high`:
    * Calculate `mid = low + (high - low) / 2`.
    * Convert `mid` to 2D coordinates: `row = mid / n`, `col = mid % n`.
    * Extract the matrix value: `midValue = matrix[row][col]`.
    * If `midValue == target`, return `true`.
    * If `midValue < target`, move search right: `low = mid + 1`.
    * Else move search left: `high = mid - 1`.
4. If the loop completes without finding the target, return `false`.

### Complexity Analysis

* **Time Complexity:** $O(\log(m \times n))$ because we are performing binary search over the total number of elements.
* **Space Complexity:** $O(1)$ since we are only using a few integer variables for pointers.