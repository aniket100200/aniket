# Kruskal's Algorithm

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Minimum Spanning Tree (MST), Greedy, Disjoint Set Union (DSU), Union-Find

---

## Problem Description

Given a connected, weighted, undirected graph with `V` vertices and a list of weighted edges, find the weight of the *
*Minimum Spanning Tree (MST)** using **Kruskal's Algorithm**.

A Minimum Spanning Tree is a subset of the graph's edges that:

- Connects all vertices.
- Contains no cycles.
- Has the minimum possible total edge weight.

Kruskal's Algorithm works by:

1. Sorting all edges by weight.
2. Iterating through the sorted edges.
3. Adding an edge if it does not form a cycle.
4. Using a Disjoint Set Union (Union-Find) data structure to efficiently detect cycles.

Return the total weight of the Minimum Spanning Tree.

---

## Input / Output Format

### Input

- `int V` → Number of vertices.
- `int[][] edges` → Array of edges where:
    - `edges[i][0]` = source vertex
    - `edges[i][1]` = destination vertex
    - `edges[i][2]` = edge weight

### Output

- Return an integer representing the total weight of the Minimum Spanning Tree.

### Notes

- The graph is undirected.
- The graph is connected.
- There may be multiple valid MSTs with the same minimum weight.
- Self-loops should be ignored automatically by cycle detection.

---

## Examples

### Example 1

**Input**

```text
V = 3

edges =
[
 [0,1,5],
 [1,2,3],
 [0,2,1]
]
```

**Output**

```text
4
```

**Explanation**

Choose edges:

- (0,2) → 1
- (1,2) → 3

Total MST Weight = 1 + 3 = 4

---

### Example 2

**Input**

```text
V = 4

edges =
[
 [0,1,10],
 [0,2,6],
 [0,3,5],
 [1,3,15],
 [2,3,4]
]
```

**Output**

```text
19
```

**Explanation**

Choose edges:

- (2,3) → 4
- (0,3) → 5
- (0,1) → 10

Total MST Weight = 19

---

### Example 3

**Input**

```text
V = 5

edges =
[
 [0,1,2],
 [0,3,6],
 [1,2,3],
 [1,3,8],
 [1,4,5],
 [2,4,7]
]
```

**Output**

```text
16
```

**Explanation**

MST Edges:

- (0,1) → 2
- (1,2) → 3
- (1,4) → 5
- (0,3) → 6

Total Weight = 16

---

## Constraints

- `1 ≤ V ≤ 10^5`
- `V - 1 ≤ edges.length ≤ 2 × 10^5`
- `0 ≤ u, v < V`
- `1 ≤ weight ≤ 10^9`
- Graph is connected.
- Graph is undirected.
- Expected Time Complexity: **O(E log E)**
- Expected Auxiliary Space: **O(V)**

---