# Dijkstra's Algorithm

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Shortest Path, Priority Queue, Greedy Algorithm

---

# Problem Description

Given a weighted graph with `V` vertices and a source vertex `src`, find the shortest distance from the source vertex to
all other vertices using Dijkstra's Algorithm.

The graph is represented using an adjacency list where each edge contains:

- destination vertex
- edge weight

Return an array where:

- `result[i]` represents the shortest distance from `src` to vertex `i`.

If a node is unreachable, its distance remains very large (`Integer.MAX_VALUE`).

---

# Input / Output Format

## Input

- `int V`
    - Number of vertices.
- `ArrayList<ArrayList<ArrayList<Integer>>> adj`
    - Adjacency list representation of the graph.
    - Each entry contains:
        - destination vertex
        - edge weight
- `int src`
    - Source vertex.

## Output

- `int[]`
    - Shortest distance array from source to every vertex.

## Important Notes

- Graph may be directed or undirected.
- Edge weights are non-negative.
- Dijkstra’s Algorithm does not work for negative edge weights.

---

# Examples

## Example 1

### Input

```text
V = 3

adj = [
  [[1,1],[2,6]],
  [[2,3],[0,1]],
  [[1,3],[0,6]]
]

src = 2
```

### Output

```text
[4,3,0]
```

### Explanation

Shortest distances from node `2`:

- To `0` → 4
- To `1` → 3
- To `2` → 0

---

## Example 2

### Input

```text
V = 5

adj = [
  [[1,2],[2,4]],
  [[2,1],[3,7]],
  [[4,3]],
  [[4,1]],
  []
]

src = 0
```

### Output

```text
[0,2,3,9,6]
```

### Explanation

Shortest paths:

- 0 → 1 = 2
- 0 → 2 = 3
- 0 → 3 = 9
- 0 → 4 = 6

---

## Example 3

### Input

```text
V = 4

adj = [
  [[1,5]],
  [],
  [[3,2]],
  []
]

src = 0
```

### Output

```text
[0,5,2147483647,2147483647]
```

### Explanation

Vertices `2` and `3` are unreachable from source `0`.

---

# Constraints

- `1 <= V <= 10^5`
- `0 <= E <= 10^5`
- `0 <= weight <= 10^5`
- Graph contains non-negative weights only.

---

# Solution Approach

## Priority Queue (Min Heap)

Dijkstra’s Algorithm uses a greedy strategy:

1. Start from the source node.
2. Always process the node with the minimum current distance.
3. Relax all neighboring edges.
4. Update shortest distances if a shorter path is found.

A min-heap (PriorityQueue) ensures efficient retrieval of the minimum-distance node.

---

# Time Complexity

```text
O((V + E) log V)
```

---

# Space Complexity

```text
O(V + E)
```

---

### Points to Remember

- Dijstra's Algorithm is not applicable for negative weighted graphs.
- always remember maintaining `minimum Heap`.