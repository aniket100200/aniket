# Points to remember

- on the same path node has to be visited Again

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

---

# Question

# Detect cycle in a directed graph

**Difficulty:** Medium  
**Topics:** Graph, Depth-First Search, Breadth-First Search, Topological Sort

## Problem Description

Given a Directed Graph with `V` vertices and `E` edges, check whether it contains any cycle or not. Return `true` if a
cycle exists, otherwise return `false`.

The graph is represented by an adjacency list `adj`, where `adj[i]` contains a list of all vertices that vertex `i` is
directed towards.

---

## Input / Output Format

**Input Format:**

* An integer `V` representing the number of vertices.
* An array of lists `adj` representing the adjacency list of the directed graph.

**Output Format:**

* Return a boolean: `true` if there is a cycle, `false` otherwise.

---

## Examples

### Example 1

**Input:**

```text
V = 4, E = 4
adj = [[1], [2], [3], [1]]
```

**Output**

```text
true
```