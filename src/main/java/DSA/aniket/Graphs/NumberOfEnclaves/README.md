# Number of Enclaves

**Difficulty:** Medium  
**Topics:** Array, Depth-First Search, Breadth-First Search, Matrix, Union Find

## Problem Description

You are given an `m x n` binary matrix `grid`, where `0` represents a sea cell and `1` represents a land cell.

A **move** consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the
boundary of the `grid`.

Return the number of land cells in `grid` for which we cannot walk off the boundary of the grid in any number of
moves. (In other words, count the number of land cells that are completely trapped by water).

---

## Input / Output Format

**Input Format:**

* A 2D integer array `grid` containing `0`s and `1`s.

**Output Format:**

* Return a single integer representing the count of isolated land cells.

---

## Examples

### Example 1

**Input:**

```text
grid = [
  [0, 0, 0, 0],
  [1, 0, 1, 0],
  [0, 1, 1, 0],
  [0, 0, 0, 0]
]
```

**Output**

```text
3
```