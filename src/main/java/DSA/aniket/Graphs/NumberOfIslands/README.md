# Find the Number of Islands using Disjoint Set

**Difficulty:** Medium  
**Topics:** Graph, Union Find (Disjoint Set), Matrix

## Problem Description

Given an `n x m` grid of `'W'` (Water) and `'L'` (Land), the task is to count the number of islands. An island is a
group of adjacent `'L'` cells connected **horizontally, vertically, or diagonally**, and it is surrounded by water or
the grid boundary.

The goal is to determine how many distinct islands exist in the grid using the Disjoint Set (Union-Find) algorithm.

---

## Input / Output Format

**Input Format:**

* An `n x m` 2D character array `grid` where each cell contains either `'L'` or `'W'`.

**Output Format:**

* Return a single integer representing the total number of islands.

---

## Examples

### Example 1

**Input:**

```text
grid = [
  ['L', 'L', 'W', 'W', 'W'],
  ['W', 'L', 'W', 'W', 'L'],
  ['L', 'W', 'W', 'L', 'L'],
  ['W', 'W', 'W', 'W', 'W'],
  ['L', 'W', 'L', 'L', 'W']
]
```
