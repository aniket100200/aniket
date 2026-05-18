# Number of Provinces

**Difficulty:** Medium  
**Topics:** Graph, Depth-First Search, Breadth-First Search, Union Find

## Problem Description

There are `n` cities. Some of them are connected, while some are not. If city `a` is connected directly with city `b`,
and city `b` is connected directly with city `c`, then city `a` is connected indirectly with city `c`.

A **province** is a group of directly or indirectly connected cities and no other cities outside of the group. (In graph
theory, this is known as a connected component).

You are given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` if the $i^{th}$ city and the $j^{th}$ city
are directly connected, and `isConnected[i][j] = 0` otherwise.

Return the total number of **provinces**.

---

## Input / Output Format

**Input Format:**

* A 2D integer array `isConnected` representing the adjacency matrix of the cities.

**Output Format:**

* Return an integer representing the total number of provinces.

---

## Examples

### Example 1

**Input:**

```text
isConnected = [
  [1, 1, 0],
  [1, 1, 0],
  [0, 0, 1]
]
```

**Output**

```text
2
```