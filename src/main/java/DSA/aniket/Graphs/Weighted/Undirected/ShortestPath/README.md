# Shortest Path in Undirected Graph

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, BFS, Shortest Path, Queue, Adjacency List

---

# Problem Description

Given an undirected graph with `V` vertices numbered from `0` to `V - 1` and a list of edges, find the shortest distance
from a given source vertex to all other vertices.

The graph is unweighted, which means every edge has equal weight (`1`).

If a vertex is unreachable from the source, return `-1` for that vertex.

---

# Input / Output Format

## Input

- `int V` → Number of vertices
- `int[][] edges` → Array of undirected edges where each edge is represented as `[u, v]`
- `int src` → Source vertex

## Output

- `int[]` → Array where:
    - `result[i]` represents the shortest distance from `src` to vertex `i`
    - `-1` indicates the vertex is unreachable

## Notes

- The graph is undirected.
- All edges have equal weight (`1`).
- Use Breadth-First Search (BFS) for optimal traversal.

---

# Examples

## Example 1

### Input

```text
V = 5
edges = [[0,1],[0,2],[1,3],[2,4]]
src = 0