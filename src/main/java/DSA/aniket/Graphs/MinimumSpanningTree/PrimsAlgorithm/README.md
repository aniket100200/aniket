# Prim's Algorithm

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Greedy, Minimum Spanning Tree (MST), Priority Queue, Heap

## Problem Description

Given a connected, undirected, weighted graph with `V` vertices and `E` edges, find the sum of the weights of the edges
in its Minimum Spanning Tree (MST).

A Minimum Spanning Tree is a subset of edges that:

- Connects all vertices in the graph.
- Contains exactly `V - 1` edges.
- Does not contain any cycle.
- Has the minimum possible total edge weight.

Prim's Algorithm constructs the MST by starting from an arbitrary vertex and repeatedly adding the minimum-weight edge
that connects a visited vertex to an unvisited vertex.

---

## Input / Output Format

### Input

- `int V`
    - Number of vertices.
- `int[][] edges`
    - Each edge is represented as:
        - `edges[i][0] = u`
        - `edges[i][1] = v`
        - `edges[i][2] = weight`

### Output

- Return an integer representing the total weight of the Minimum Spanning Tree.

### Notes

- The graph is undirected.
- The graph is connected.
- Multiple valid MSTs may exist, but all have the same minimum total weight.
- Prim's Algorithm uses a Min Heap (Priority Queue) for efficient edge selection.

---

## Examples

### Example 1

Input

```text
V = 3

edges = [
 [0,1,5],
 [1,2,3],
 [0,2,1]
]
```

Output

```text
4
```

Explanation

```text
Choose edges:
0 - 2 (1)
2 - 1 (3)

Total MST Weight = 1 + 3 = 4
```

---

### Example 2

Input

```text
V = 5

edges = [
 [0,1,2],
 [0,3,6],
 [1,2,3],
 [1,3,8],
 [1,4,5],
 [2,4,7],
 [3,4,9]
]
```

Output

```text
16
```

Explanation

```text
One possible MST:

0 - 1 (2)
1 - 2 (3)
1 - 4 (5)
0 - 3 (6)

Total Weight = 16
```

---

### Example 3

Input

```text
V = 1

edges = []
```

Output

```text
0
```

Explanation

```text
A single vertex requires no edges.
```

---

## Constraints

- `1 <= V <= 10^4`
- `0 <= E <= 10^5`
- `0 <= u, v < V`
- `1 <= weight <= 10^6`
- Graph is connected.
- Time Complexity: **O(E log V)**
- Space Complexity: **O(V + E)**