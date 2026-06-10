# Articulation Point

## Metadata

- **Difficulty:** Hard
- **Topics:** Graphs, DFS, Tarjan's Algorithm, Articulation Points, Connected Components
- **Companies:** Amazon, Microsoft, Adobe, Google

---

## Problem Description

Given an undirected connected graph with `V` vertices and an adjacency list `adj`, find all the Articulation Points (Cut
Vertices) in the graph.

An Articulation Point is a vertex whose removal (along with all its incident edges) increases the number of connected
components in the graph.

Return all articulation points in sorted order.

If no articulation point exists, return:

```text
[-1]
```

---

## Input / Output Format

### Input

- `int V` → Number of vertices.
- `ArrayList<ArrayList<Integer>> adj`
    - `adj.get(u)` contains all vertices connected to `u`.

### Output

- `ArrayList<Integer>`
- All articulation points in ascending order.
- Return `[-1]` if none exist.

### Notes

- Graph is undirected.
- Graph may be disconnected.
- Output should be sorted.

---

## Examples

### Example 1

**Input**

```text
V = 5

0 -- 1
|
2

1 -- 3 -- 4
```

**Output**

```text
[1,3]
```

**Explanation**

Removing:

```text
1
```

disconnects node 3 and 4.

Removing:

```text
3
```

disconnects node 4.

---

### Example 2

**Input**

```text
V = 3

0 -- 1
 \  /
  2
```

**Output**

```text
[-1]
```

**Explanation**

Graph forms a cycle.

No articulation point exists.

---

### Example 3

**Input**

```text
V = 4

0 -- 1 -- 2 -- 3
```

**Output**

```text
[1,2]
```

---

## Constraints

- `1 <= V <= 10^4`
- `0 <= E <= 10^5`
- Expected Time Complexity: **O(V + E)**
- Expected Auxiliary Space: **O(V)**

---

## Approach (Tarjan's Algorithm)

### Core Idea

For every node maintain:

```text
tin[node]
```

Time of insertion in DFS.

and

```text
low[node]
```

Lowest reachable ancestor through DFS tree or back edge.

---

### Articulation Point Conditions

For a non-root node:

```text
if(low[child] >= tin[node])
```

then:

```text
node
```

is an articulation point.

Why?

Because child's subtree cannot reach any ancestor of node.

Removing node disconnects the subtree.

---

### Root Node Special Case

Root becomes an articulation point only when:

```text
children > 1
```

in DFS tree.

---

## Time Complexity

```text
O(V + E)
```

## Space Complexity

```text
O(V)
```

---