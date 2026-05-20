# Detect cycle in an undirected graph

**Difficulty:** Medium  
**Topics:** Graph, Depth-First Search, Breadth-First Search

## Problem Description

Given an undirected graph with `V` vertices and `E` edges, return `true` if it contains a cycle, otherwise return
`false`.

The graph is represented by an adjacency list `adj`, where `adj[i]` contains a list of all vertices adjacent to vertex
`i`.

*(Note: The graph may be disconnected, meaning you must check all components of the graph for a cycle).*

---

## Input / Output Format

**Input Format:**

* An integer `V` representing the number of vertices.
* An array of lists `adj` representing the adjacency list of the graph.

**Output Format:**

* Return a boolean: `true` if there is a cycle, `false` otherwise.

---

## Examples

### Example 1

**Input:**

```text
V = 5, E = 5
adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]]
```

```text
true
```

### Example 2

**Input:**

```text
V = 4, E = 3
adj = [[1], [0, 2], [1, 3], [2]]
```

**Output**

```text
false
```