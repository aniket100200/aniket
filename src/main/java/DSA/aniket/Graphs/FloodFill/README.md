# Flood Fill

**Difficulty:** Easy  
**Topics:** Array, Depth-First Search, Breadth-First Search, Matrix

## Problem Description

An image is represented by an `m x n` integer grid `image` where `image[i][j]` represents the pixel value of the image.

You are also given three integers `sr`, `sc`, and `color`. You should perform a **flood fill** on the image starting
from the pixel `image[sr][sc]`.

To perform a flood fill, consider the starting pixel, plus any pixels connected **4-directionally** to the starting
pixel of the **same color** as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with
the same color), and so on. Replace the color of all of the aforementioned pixels with `color`.

Return the modified image after performing the flood fill.

---

## Input / Output Format

**Input Format:**

* A 2D integer array `image`.
* An integer `sr` representing the starting row.
* An integer `sc` representing the starting column.
* An integer `color` representing the new color to apply.

**Output Format:**

* Return the modified 2D integer array `image`.

---

## Examples

### Example 1

**Input:**

```text
image = [
  [1, 1, 1],
  [1, 1, 0],
  [1, 0, 1]
]
sr = 1, sc = 1, color = 2
```

**Output**

```text
[
  [2, 2, 2],
  [2, 2, 0],
  [2, 0, 1]
]
```