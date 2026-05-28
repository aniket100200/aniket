# Print the Shortest Path in Weighted Undirected Graph

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Dijkstra's Algorithm, Shortest Path, Priority Queue, Greedy

---

# Problem Description

Given a weighted undirected graph with `n` vertices numbered from `1` to `n` and a list of weighted edges, find the
shortest path from vertex `1` to vertex `n`.

Return the path as a list of vertices representing the shortest route.

If no path exists, return a list containing only `-1`.

The graph is undirected, meaning every edge can be traversed in both directions.

---

# Input / Output Format

## Input

- `int n`
    - Number of vertices.
- `int m`
    - Number of edges.
- `int[][] edges`
    - Each edge contains:
        - `u` → source vertex
        - `v` → destination vertex
        - `wt` → edge weight

## Output

- `List<Integer>`
    - Shortest path from node `1` to node `n`.
    - Return `[-1]` if no valid path exists.

## Important Notes

- Graph is undirected.
- Edge weights are positive.
- If multiple shortest paths exist, returning any one is acceptable.

---

# Examples

## Example 1

### Input

```text
n = 5
m = 6

edges = [
  [1,2,2],
  [2,5,5],
  [2,3,4],
  [1,4,1],
  [4,3,3],
  [3,5,1]
]
```

### Output

```text
[1,4,3,5]
```

### Explanation

Shortest distance from `1` to `5`:

```text
1 → 4 → 3 → 5
```

Total weight:

```text
1 + 3 + 1 = 5
```

---

## Example 2

### Input

```text
n = 4
m = 2

edges = [
  [1,2,1],
  [3,4,2]
]
```

### Output

```text
[-1]
```

### Explanation

Node `4` is unreachable from node `1`.

---

## Example 3

### Input

```text
n = 3
m = 3

edges = [
  [1,2,1],
  [2,3,1],
  [1,3,5]
]
```

### Output

```text
[1,2,3]
```

### Explanation

Shortest route:

```text
1 → 2 → 3
```

Total weight = `2`.

---

# Constraints

- `1 <= n <= 10^5`
- `1 <= m <= 2 * 10^5`
- `1 <= wt <= 10^5`
- Graph is connected or disconnected.
- No self-loops.

---

# Solution Approach

## Dijkstra + Parent Tracking

We use Dijkstra’s Algorithm to compute the shortest distance from source node `1` to all other nodes.

Additionally:

- Maintain a `parent[]` array.
- Whenever a shorter path is found:
    - update parent of the node.

After Dijkstra completes:

- Backtrack from node `n`
- Reconstruct the shortest path.

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