## Points To remember

- MultiSource Shortest Path.
- Detects Negative Cycle

# Floyd Warshall Algorithm

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Dynamic Programming, Shortest Path, All-Pairs Shortest Path

## Problem Description

The Floyd Warshall Algorithm is used to find the shortest distances between every pair of vertices in a weighted graph.

Given an `N x N` adjacency matrix `matrix`, where:

- `matrix[i][j]` represents the weight of the edge from vertex `i` to vertex `j`
- `matrix[i][j] = -1` indicates that there is no direct edge between the vertices
- `matrix[i][i] = 0`

Modify the matrix such that each cell contains the shortest distance between the corresponding pair of vertices.

If a vertex remains unreachable from another vertex, keep its value as `-1`.

The algorithm works for both directed and undirected graphs and efficiently computes all-pairs shortest paths using
dynamic programming.

---

## Input / Output Format

### Input

- `int[][] matrix`
    - An adjacency matrix representing the graph.
    - `matrix[i][j]` is the edge weight from vertex `i` to vertex `j`.
    - `-1` indicates no direct edge.

### Output

- Modify the input matrix in-place.
- After execution:
    - `matrix[i][j]` contains the shortest distance from vertex `i` to vertex `j`.
    - Unreachable vertices remain `-1`.

### Notes

- The graph may be directed.
- Self-distance is always `0`.
- The algorithm computes shortest paths between all pairs of vertices.

---

## Examples

### Example 1

Input

```text
matrix = [
 [0, 2, -1, -1],
 [1, 0, 3, -1],
 [-1, -1, 0, 4],
 [-1, -1, -1, 0]
]
```

Output

```text
[
 [0, 2, 5, 9],
 [1, 0, 3, 7],
 [-1, -1, 0, 4],
 [-1, -1, -1, 0]
]
```

Explanation

- 0 → 2 is reached through 1.
- 0 → 3 is reached through 1 and 2.
- 1 → 3 is reached through 2.

---

### Example 2

Input

```text
matrix = [
 [0, 5, -1],
 [-1, 0, 2],
 [1, -1, 0]
]
```

Output

```text
[
 [0, 5, 7],
 [3, 0, 2],
 [1, 6, 0]
]
```

Explanation

- Every vertex becomes reachable from every other vertex through intermediate vertices.

---

### Example 3

Input

```text
matrix = [
 [0, -1],
 [-1, 0]
]
```

Output

```text
[
 [0, -1],
 [-1, 0]
]
```

Explanation

- No path exists between the two vertices.

---

## Constraints

- `1 <= N <= 100`
- `matrix.length == matrix[0].length`
- `matrix[i][i] = 0`
- `matrix[i][j] = -1` or a non-negative edge weight
- Time Complexity: **O(N³)**
- Space Complexity: **O(1)** (excluding input matrix)