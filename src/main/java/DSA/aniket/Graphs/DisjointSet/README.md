# Union By Rank (Disjoint Set Union)

## Metadata

- **Difficulty:** Easy
- **Topics:** Graph, Disjoint Set Union (DSU), Union-Find, Union By Rank, Path Compression

---

## Theory

### What is Disjoint Set Union (DSU)?

Disjoint Set Union (DSU), also known as Union-Find, is a data structure used to efficiently maintain a collection of
disjoint (non-overlapping) sets.

It supports two primary operations:

1. **Find(U)**
    - Determines the representative (ultimate parent) of the set containing `U`.

2. **Union(U, V)**
    - Merges the sets containing `U` and `V`.

DSU is widely used in:

- Kruskal's Minimum Spanning Tree Algorithm
- Detecting cycles in an undirected graph
- Dynamic Connectivity Problems
- Network Connectivity Problems
- Connected Components

---

### Why Union By Rank?

A naive union operation may create very deep trees.

Example:

```text
1 <- 2 <- 3 <- 4 <- 5 <- 6
```

Finding the ultimate parent of node `6` would require traversing all previous nodes.

To avoid this, we use **Union By Rank**.

The rank represents an estimate of the tree height.

During union:

- Attach the tree with smaller rank under the tree with larger rank.
- If both ranks are equal:
    - Attach either tree under the other.
    - Increase the rank of the new parent by 1.

This keeps trees shallow.

---

### Path Compression

While performing `findParent(node)`:

```java
return parent[node]=

findParent(parent[node]);
```

we directly connect every visited node to the ultimate parent.

This drastically reduces future lookup times.

---

### Time Complexity

With:

- Union By Rank
- Path Compression

The amortized complexity becomes:

```text
O(α(N))
```

where:

```text
α(N)
```

is the Inverse Ackermann Function.

For all practical values of `N`, this behaves almost like:

```text
O(1)
```

---

## Problem Description

Implement a Disjoint Set Union (DSU) data structure using:

- Union By Rank
- Path Compression

Support the following operations:

- `findParent(node)`
- `unionByRank(u, v)`

The structure should efficiently maintain multiple disjoint sets and merge them whenever required.

---

## Input / Output Format

### Input

- Integer `n`
    - Number of nodes.

- Operations:
    - `unionByRank(u, v)`
    - `findParent(node)`

### Output

- No explicit return value for union operations.
- `findParent(node)` returns the ultimate parent of the node.

### Notes

- Nodes are numbered from `0` to `n`.
- Initially every node belongs to its own set.
- Path Compression should be used.

---

## Examples

### Example 1

Input

```text
n = 7

union(1,2)
union(2,3)

find(1)
find(3)
```

Output

```text
1
1
```

Explanation

```text
1,2,3 belong to the same set.

Ultimate parent = 1
```

---

### Example 2

Input

```text
n = 7

union(4,5)
union(6,7)
union(5,6)

find(4)
find(7)
```

Output

```text
4
4
```

Explanation

```text
All nodes become part of one set.
```

---

### Example 3

Input

```text
n = 5

find(3)
```

Output

```text
3
```

Explanation

```text
No union operation has occurred.
Every node is its own parent.
```

---

## Constraints

- `1 <= n <= 10^5`
- Up to `10^5` union/find operations
- Nodes are indexed from `0` to `n`
- Path Compression must be used
- Union operation uses Rank

---

## Algorithm

### Initialization

```java
for(int i = 0;
i <=n;i++){
parent[i]=i;
rank[i]=0;
        }
```

### Find Parent

```java
int findParent(int node) {
    if (parent[node] == node)
        return node;

    return parent[node] =
            findParent(parent[node]);
}
```

### Union By Rank

```java
void unionByRank(int u, int v) {

    int pu = findParent(u);
    int pv = findParent(v);

    if (pu == pv)
        return;

    if (rank[pu] < rank[pv]) {
        parent[pu] = pv;
    } else if (rank[pv] < rank[pu]) {
        parent[pv] = pu;
    } else {
        parent[pv] = pu;
        rank[pu]++;
    }
}
```

---

## Complexity Analysis

### Time Complexity

| Operation | Complexity |
|-----------|------------|
| Find      | O(α(N))    |
| Union     | O(α(N))    |

### Space Complexity

```text
O(N)
```

for storing:

- parent array
- rank array