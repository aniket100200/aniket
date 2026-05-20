# Distance of Nearest Cell Having 1

**Difficulty:** Medium  
**Topics:** Graph, Breadth-First Search, Matrix

## Problem Description

Given a binary grid of `n x m` consisting of `0`s and `1`s. Find the distance of the nearest `1` in the grid for each
cell.

The distance is calculated as **Manhattan Distance**, where the distance between two points `(x1, y1)` and `(x2, y2)` is
`|x1 - x2| + |y1 - y2|`.
*(In simpler terms, you can only move horizontally or vertically, and each move counts as 1 step).*

---

## Input / Output Format

**Input Format:**

* A 2D integer array `grid` containing only `0`s and `1`s.

**Output Format:**

* Return a 2D integer array of the same dimensions where each cell contains the minimum distance to the nearest `1`.

---

## Examples

### Example 1

**Input:**

```text
grid = [
  [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0]
]
```

**Output**

```text
[
  [2, 1, 2],
  [1, 0, 1],
  [2, 1, 2]
]
```

### Example 2

**Input**

```text
grid = [
  [0, 1, 1],
  [1, 1, 0],
  [1, 0, 1]
]
```

**Output**

```text
[
  [1, 0, 0],
  [0, 0, 1],
  [0, 1, 0]
]
```