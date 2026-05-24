# Shortest Path in a Directed Acyclic Graph

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Directed Acyclic Graph (DAG), Topological Sorting, Shortest Path, DFS, BFS

---

## Problem Description

Given a weighted Directed Acyclic Graph (DAG) with `N` vertices numbered from `0` to `N - 1` and `M` edges, find the
shortest distance from a source vertex `0` to all other vertices.

The graph is represented as a list of directed weighted edges where each edge is defined as:

(u, v, wt)

Meaning there is a directed edge from vertex `u` to vertex `v` with weight `wt`.

If a node is unreachable from the source vertex `0`, return `-1` for that node.

The solution should efficiently compute shortest paths using Topological Sorting.

---

## Input / Output Format

### Input

- Integer `N`
    - Number of vertices in the graph.
- Integer `M`
    - Number of directed edges.
- 2D integer array `edges`
    - Each row contains:
        - `u` → source vertex
        - `v` → destination vertex
        - `wt` → edge weight

### Output

- Integer array of size `N`
- `answer[i]` represents the shortest distance from source node `0` to node `i`
- If node `i` is unreachable, return `-1`

### Important Notes

- The graph is guaranteed to be a DAG.
- Edge weights are non-negative.
- Source node is always `0`.

---

## Examples

### Example 1

#### Input

```text
N = 6
M = 7

edges = [
  [0,1,2],
  [0,4,1],
  [4,5,4],
  [4,2,2],
  [1,2,3],
  [2,3,6],
  [5,3,1]
]
```

#### Output

```text
[0, 2, 3, 6, 1, 5]
```

#### Explanation

- Distance to node `1` = `2`
- Distance to node `4` = `1`
- Distance to node `2` = `1 + 2 = 3`
- Distance to node `5` = `1 + 4 = 5`
- Distance to node `3` = `5 + 1 = 6`

---

### Example 2

#### Input

```text
N = 4
M = 2

edges = [
  [0,1,5],
  [1,2,3]
]
```

#### Output

```text
[0, 5, 8, -1]
```

#### Explanation

- Node `3` is unreachable from source node `0`.

---

### Example 3

#### Input

```text
N = 5
M = 6

edges = [
  [0,1,1],
  [0,2,2],
  [1,3,3],
  [2,3,1],
  [3,4,2],
  [1,4,10]
]
```

#### Output

```text
[0, 1, 2, 3, 5]
```

#### Explanation

- Shortest path to node `3` is:
    - `0 -> 2 -> 3`
- Shortest path to node `4` is:
    - `0 -> 2 -> 3 -> 4`

---

## Constraints

- `1 <= N <= 10^5`
- `0 <= M <= 2 * 10^5`
- `0 <= u, v < N`
- `0 <= wt <= 10^4`
- Graph is a Directed Acyclic Graph (DAG)

---

## Approach

1. Build an adjacency list from the edge list.
2. Perform Topological Sorting using DFS.
3. Initialize distances:
    - `dist[0] = 0`
    - all others = infinity
4. Process nodes in topological order:
    - Relax all outgoing edges.
5. Replace unreachable distances with `-1`.

---

## Time Complexity

- **Topological Sort:** `O(N + M)`
- **Shortest Path Relaxation:** `O(M)`

### Overall Complexity

```text
O(N + M)
```

---

## Space Complexity

```text
O(N + M)
```

- Adjacency list
- Visited array
- Stack
- Distance array