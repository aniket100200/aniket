# BFS of Graph

**Difficulty:** Easy / Medium  
**Topics:** Graph, Breadth-First Search, Queue

## Problem Description

Given a connected undirected graph represented by an adjacency list `adj`, which is an array of lists where `adj[i]`
contains a list of all vertices adjacent to vertex `i`.

Your task is to return a list containing the **Breadth-First Traversal (BFS)** of the graph starting from vertex `0`.

**Note:**

* The traversal should start from vertex `0`.
* The vertices in the adjacency list are usually visited in the order they appear in the list.
* You need to handle cycles in the graph by keeping track of visited vertices.

---

## Input / Output Format

**Input Format:**

* The first line contains two integers `V` (number of vertices) and `E` (number of edges).
* The next `E` lines contain two integers `u` and `v` representing an edge between vertex `u` and vertex `v`.
  *(Note: In the code, the input is typically passed directly as the number of vertices `V` and the adjacency
  list `adj`).*

**Output Format:**

* Return a list of integers representing the BFS traversal from vertex `0`.

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
[0, 1, 2, 3, 4]
```

# Points to remember

- It is Breath First Search
- It is also called Level Wise Traversal.

# Time Complexity O(N) + O(E)

- as we are using a Node goes once into
- it runs on all degrees
- as Queue is running for N nodes
- overall Time complexity will be O(N) + O(E)

# Space Complexity O(N)

- as we are Using Queue and Visited Array and Answer Array
- so it will be O(3N) which is Equivalent to O(N)

# Solution
