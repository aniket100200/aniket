### Points to Remember

- As `Dijkstra's Algorithm` fails for negative weights cycles.
- This Algorithm is only works for Directed Graphs.
- for undirected graphs to work You need to convert
- `undirected graph to Directed Graph`
- It helps to Detect `Negative Cycles`.

### Question

# Bellman-Ford Algorithm

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Shortest Path, Bellman-Ford, Dynamic Programming

---

# Problem Description

Given a weighted directed graph with `V` vertices and an edge list `edges[][]`, find the shortest distance from a source
vertex `src` to all other vertices using the **Bellman-Ford Algorithm**.

The graph may contain negative edge weights.

If the graph contains a **negative weight cycle reachable from the source**, return:

```text
[-1]
```

Otherwise, return an array where:

```text
distance[i]
```

represents the shortest distance from the source vertex to vertex `i`.

---

# Input / Output Format

## Input

- `int V`
    - Number of vertices.

- `int[][] edges`
    - Each edge is represented as:

```text
[u, v, wt]
```

where:

- `u` = source vertex
- `v` = destination vertex
- `wt` = edge weight

- `int src`
    - Source vertex.

## Output

- Return an integer array of size `V`.
- `distance[i]` represents the shortest distance from `src` to `i`.
- Return:

```text
[-1]
```

if a negative cycle is reachable from the source.

## Important Notes

- Graph is directed.
- Negative edge weights are allowed.
- Negative weight cycles must be detected.

---

# Examples

## Example 1

### Input

```text
V = 5

edges =
[
 [0,1,5],
 [1,2,-2],
 [1,5,1],
 [2,4,3],
 [3,2,6],
 [3,4,-2]
]

src = 0
```

### Output

```text
[0,5,3,100000000,6]
```

### Explanation

Bellman-Ford computes the shortest distance from node 0 to every node.

---

## Example 2

### Input

```text
V = 3

edges =
[
 [0,1,1],
 [1,2,-1],
 [2,0,-1]
]

src = 0
```

### Output

```text
[-1]
```

### Explanation

A negative cycle exists:

```text
0 → 1 → 2 → 0
```

---

## Example 3

### Input

```text
V = 4

edges =
[
 [0,1,4],
 [0,2,5],
 [1,2,-3],
 [2,3,4]
]

src = 0
```

### Output

```text
[0,4,1,5]
```

---

# Constraints

- `1 <= V <= 500`
- `1 <= edges.length <= 5000`
- `-10^4 <= wt <= 10^4`
- `0 <= src < V`
- Graph may contain negative weights.
- Graph may contain disconnected vertices.

---

# Solution Approach

## Bellman-Ford Algorithm

Bellman-Ford works by repeatedly relaxing every edge.

### Step 1

Initialize:

```text
dist[src] = 0
dist[others] = INF
```

---

### Step 2

Relax all edges exactly:

```text
V - 1
```

times.

For every edge:

```text
u → v (wt)
```

perform:

```text
if dist[u] + wt < dist[v]
    dist[v] = dist[u] + wt
```

---

### Step 3

Run one additional iteration.

If any edge can still be relaxed:

```text
dist[u] + wt < dist[v]
```

then a negative cycle exists.

Return:

```text
[-1]
```

---

# Time Complexity

```text
O(V × E)
```

Where:

- `V` = number of vertices
- `E` = number of edges

---

# Space Complexity

```text
O(V)
```