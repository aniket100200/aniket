# 1192. Critical Connections in a Network

## Metadata

- **Difficulty:** Hard
- **Topics:** Graphs, DFS, Tarjan's Algorithm, Bridges, Graph Connectivity
- **LeetCode:** 1192

---

## Problem Description

There are `n` servers numbered from `0` to `n - 1` connected by undirected server-to-server connections.

You are given:

- `int n` → number of servers.
- `List<List<Integer>> connections` where:

```text
connections[i] = [a, b]
```

indicates a bidirectional connection between servers `a` and `b`.

A **critical connection** is an edge that, if removed, makes some server unable to reach some other server.

Return all critical connections in the network.

You may return the answer in any order.

---

## Input / Output Format

### Input

- `int n`
- `List<List<Integer>> connections`

### Output

- `List<List<Integer>>`
- Each list contains one critical connection.

### Notes

- Graph is undirected.
- There are no duplicate edges.
- The graph may contain cycles.
- Output order does not matter.

---

## Examples

### Example 1

**Input**

```text
n = 4

connections =
[
 [0,1],
 [1,2],
 [2,0],
 [1,3]
]
```

**Output**

```text
[
 [1,3]
]
```

**Explanation**

```text
0 --- 1 --- 3
 \   /
  \ /
   2
```

Removing edge:

```text
1 - 3
```

disconnects node 3.

Hence it is a bridge.

---

### Example 2

**Input**

```text
n = 2

connections =
[
 [0,1]
]
```

**Output**

```text
[
 [0,1]
]
```

---

### Example 3

**Input**

```text
n = 5

connections =
[
 [0,1],
 [1,2],
 [2,0],
 [1,3],
 [3,4]
]
```

**Output**

```text
[
 [3,4],
 [1,3]
]
```

---

## Constraints

- `2 <= n <= 10^5`
- `n - 1 <= connections.length <= 10^5`
- `0 <= ai, bi < n`
- `ai != bi`
- No duplicate edges.
- Expected Time Complexity: **O(V + E)**
- Expected Auxiliary Space: **O(V + E)**

---

## Approach (Tarjan's Bridge Algorithm)

### Core Idea

For every node maintain:

```text
tin[node]
```

Time when node is first visited.

and

```text
low[node]
```

Earliest reachable ancestor through DFS tree or back edge.

---

### Bridge Condition

For an edge:

```text
node ---- child
```

after DFS:

```text
if(low[child] > tin[node])
```

then:

```text
(node, child)
```

is a critical connection (bridge).

Why?

Because child's subtree cannot reach node or any ancestor of node using a back edge.

Removing this edge disconnects the graph.

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