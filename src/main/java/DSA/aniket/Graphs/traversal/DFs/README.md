# DFS of Graph

**Difficulty:** Easy / Medium  
**Topics:** Graph, Depth-First Search, Recursion

## Problem Description

Given a connected undirected graph represented by an adjacency list `adj`, which is an array of lists where `adj[i]`
contains a list of all vertices adjacent to vertex `i`.

Your task is to return a list containing the **Depth-First Traversal (DFS)** of the graph starting from vertex `0`.

**Note:**

* The traversal should start from vertex `0`.
* The vertices in the adjacency list are usually visited in the order they appear in the list.
* You need to handle cycles in the graph by keeping track of visited vertices to avoid infinite recursion.

---

## Input / Output Format

**Input Format:**

* The first line contains two integers `V` (number of vertices) and `E` (number of edges).
* The next `E` lines contain two integers `u` and `v` representing an edge between vertex `u` and vertex `v`.
  *(Note: In the code, the input is typically passed directly as the number of vertices `V` and the adjacency
  list `adj`).*

**Output Format:**

* Return a list of integers representing the DFS traversal from vertex `0`.

---

## Examples

### Example 1

**Input:**

```text
V = 5, E = 4
adj = [[1, 2, 3], [], [4], [], []]
```

**Output**

```text
[0, 1, 2, 4, 3]
```

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution