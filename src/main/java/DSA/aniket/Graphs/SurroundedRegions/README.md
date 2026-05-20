# Surrounded Regions

**Difficulty:** Medium  
**Topics:** Array, Depth-First Search, Breadth-First Search, Union Find, Matrix

## Problem Description

Given an `m x n` matrix `board` containing `'X'` and `'O'`, capture all regions that are 4-directionally surrounded by
`'X'`.

A region is **captured** by flipping all `'O'`s into `'X'`s in that surrounded region.

**Note:**
An `'O'` should not be flipped if:

- It is on the border of the board.
- It is adjacent to an `'O'` that should not be flipped.
- In other words, any `'O'` that is connected (directly or indirectly) to the border is safe and will not be captured.

---

## Input / Output Format

**Input Format:**

* A 2D character array `board` containing `'X'` and `'O'`.

**Output Format:**

* Modify the `board` **in-place**. Do not return anything.

---

## Examples

### Example 1

**Input:**

```text
board = [
  ["X", "X", "X", "X"],
  ["X", "O", "O", "X"],
  ["X", "X", "O", "X"],
  ["X", "O", "X", "X"]
]
```

**Output**

```text
[
  ["X", "X", "X", "X"],
  ["X", "X", "X", "X"],
  ["X", "X", "X", "X"],
  ["X", "O", "X", "X"]
]
```