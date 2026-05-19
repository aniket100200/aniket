# Rotting Oranges

**Difficulty:** Medium  
**Topics:** Array, Breadth-First Search, Matrix

## Problem Description

You are given an `m x n` `grid` where each cell can have one of three values:

* `0` representing an empty cell,
* `1` representing a fresh orange, or
* `2` representing a rotten orange.

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
`-1`.

---

## Input / Output Format

**Input Format:**

* A 2D integer array `grid`.

**Output Format:**

* Return a single integer representing the minimum minutes required, or `-1` if some oranges can never rot.

---

## Examples

### Example 1

**Input:**

```text
grid = [
  [2, 1, 1],
  [1, 1, 0],
  [0, 1, 1]
]
```

**Output**

```text
4
```

