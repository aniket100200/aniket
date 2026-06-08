# Kosaraju's Algorithm

## Metadata

- **Difficulty:** Hard
- **Topics:** Graphs, Strongly Connected Components (SCC), DFS, Topological Ordering
- **Companies:** Frequently Asked in Amazon, Microsoft, Adobe, Google

---

## Problem Description

Given a directed graph with `V` vertices and an adjacency list `adj`, determine the number of **Strongly Connected
Components (SCCs)** using **Kosaraju's Algorithm**.

A Strongly Connected Component (SCC) is a maximal group of vertices such that every vertex is reachable from every other
vertex in the group.

Return the total number of strongly connected components in the graph.

---

## Input / Output Format

### Input

- `int V` → Number of vertices.
- `ArrayList<ArrayList<Integer>> adj`
    - `adj.get(u)` contains all vertices reachable from vertex `u`.

### Output

- Return an integer representing the number of Strongly Connected Components.

### Notes

- The graph is directed.
- A single isolated node is considered an SCC.
- Kosaraju's Algorithm uses two DFS traversals.

---

## Examples

### Example 1

**Input**

```text
V = 5

0 → 2
2 → 1
1 → 0
0 → 3
3 → 4
```

**Output**

```text
3
```

**Explanation**

SCCs:

```text
{0,1,2}
{3}
{4}
```

---

### Example 2

**Input**

```text
V = 3

0 → 1
1 → 2
2 → 0
```

**Output**

```text
1
```

**Explanation**

All vertices are mutually reachable.

---

### Example 3

**Input**

```text
V = 4

0 → 1
1 → 2
2 → 3
```

**Output**

```text
4
```

**Explanation**

Every node forms its own SCC.

---

## Constraints

- `1 <= V <= 10^4`
- `0 <= E <= 10^5`
- Graph may be disconnected.
- Expected Time Complexity: **O(V + E)**
- Expected Auxiliary Space: **O(V + E)**

---

## Kosaraju's Algorithm

### Step 1: Topological Order DFS

Perform DFS and push nodes into a stack after visiting all neighbors.

This gives nodes ordered by finishing time.

### Step 2: Reverse the Graph

Reverse every edge:

```text
u → v

becomes

v → u
```

### Step 3: DFS on Reversed Graph

Pop nodes from stack.

For every unvisited node:

- Run DFS on reversed graph.
- Mark all reachable nodes.

Each DFS traversal represents one SCC.

### Why Does This Work?

The node with the highest finishing time always belongs to a source SCC in the reversed graph.

Processing nodes in decreasing finish time guarantees one SCC is fully explored before another.

---

## Time Complexity

```text
O(V + E)
```

## Space Complexity

```text
O(V + E)
```

---