# Minimum Number of Operations to Make Network Connected

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Depth First Search (DFS), Breadth First Search (BFS), Disjoint Set Union (DSU), Connected
  Components

---

## Problem Description

There are `n` computers numbered from `0` to `n - 1` connected by a network of cables.

You are given a 2D integer array `connections` where `connections[i] = [a, b]` represents a direct connection between
computers `a` and `b`.

Any cable can be removed between two directly connected computers and placed between any pair of disconnected computers.

Return the minimum number of operations required to make all computers connected.

If it is impossible to connect all computers, return `-1`.

### Key Observation

To connect `n` computers into a single network, at least `n - 1` cables are required.

- If `connections.length < n - 1`, it is impossible to connect all computers.
- Otherwise:
    - Find the number of connected components.
    - If there are `k` connected components, we need exactly `k - 1` operations to connect them.

---

## Input / Output Format

### Input

- `int n` → Number of computers.
- `int[][] connections` → Network connections where:
    - `connections[i][0]` = first computer
    - `connections[i][1]` = second computer

### Output

- Return the minimum number of operations required to connect all computers.
- Return `-1` if it is impossible.

### Notes

- Connections are undirected.
- There are no duplicate connections.
- Computers are labeled from `0` to `n - 1`.

---

## Examples

### Example 1

**Input**

```text
n = 4

connections =
[
 [0,1],
 [0,2],
 [1,2]
]
```

**Output**

```text
1
```

**Explanation**

Computer 3 is disconnected.

Remove the extra cable between 1 and 2 and connect computer 3.

Only 1 operation is required.

---

### Example 2

**Input**

```text
n = 6

connections =
[
 [0,1],
 [0,2],
 [0,3],
 [1,2],
 [1,3]
]
```

**Output**

```text
2
```

**Explanation**

There are 3 connected components:

- {0,1,2,3}
- {4}
- {5}

Operations needed = 3 - 1 = 2.

---

### Example 3

**Input**

```text
n = 6

connections =
[
 [0,1],
 [0,2],
 [0,3],
 [1,2]
]
```

**Output**

```text
-1
```

**Explanation**

Only 4 cables exist.

At least 5 cables are required to connect 6 computers.

Hence it is impossible.

---

## Constraints

- `1 <= n <= 10^5`
- `0 <= connections.length <= 10^5`
- `connections[i].length == 2`
- `0 <= a, b < n`
- `a != b`
- No duplicate connections.
- Expected Time Complexity: **O(E α(N))**
- Expected Auxiliary Space: **O(N)**

---