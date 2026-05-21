# Topological Sort

**Difficulty:** Medium  
**Topics:** Graph, Depth-First Search, Breadth-First Search (Kahn's Algorithm), Topological Sort

## Problem Description

Given a **Directed Acyclic Graph (DAG)** with `V` vertices and `E` edges, find a Topological Sorting of that graph.

A **Topological Sort** is a linear ordering of vertices such that for every directed edge $u \rightarrow v$, vertex $u$
comes before vertex $v$ in the ordering.

*(Note: Topological sorting is only possible for graphs that do not contain cycles. Also, a single graph can have
multiple valid topological sorts).*

---

## Input / Output Format

**Input Format:**

* An integer `V` representing the number of vertices.
* An array of lists `adj` representing the adjacency list of the directed graph.

**Output Format:**

* Return an array of integers representing one valid topological sort.

---

## Examples

### Example 1

**Input:**

```text
V = 4, E = 4
adj = [[1, 2], [3], [3], []]
```

**Output**

```text
[0, 1, 2, 3]  OR  [0, 2, 1, 3]
```

### Example 2

**Input**

```text
V = 6, E = 6
adj = [[], [], [3], [1], [0, 1], [0, 2]]
```

**Output**

```text
[5, 4, 2, 3, 1, 0]
```

### Constraints

- 1 <= V, E <= 10^4

- 0 <= adj[i][j] < V

- The graph is guaranteed to be a Directed Acyclic Graph `(DAG)`.