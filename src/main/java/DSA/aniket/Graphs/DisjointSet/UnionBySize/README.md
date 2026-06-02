# Union By Size (Disjoint Set Union)

## Metadata

- **Difficulty:** Easy
- **Topics:** Graph, Disjoint Set Union (DSU), Union-Find, Union By Size, Path Compression

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

DSU is extensively used in:

- Kruskal's Minimum Spanning Tree Algorithm
- Finding Connected Components
- Dynamic Connectivity Problems
- Network Connectivity
- Cycle Detection in Undirected Graphs

---

### What is Union By Size?

In a naive union operation, one tree can become extremely deep.

Example:

```text
1 <- 2 <- 3 <- 4 <- 5 <- 6
```

A deep tree makes the `find()` operation expensive.

To prevent this, Union By Size always attaches the smaller set to the larger set.

Each component maintains:

```java
size[parent]
```

which represents the number of nodes in that component.

During union:

- Find the ultimate parents of both nodes.
- Compare component sizes.
- Attach the smaller component under the larger component.
- Update the size of the new parent.

This keeps the tree balanced and improves performance.

---

### Path Compression

Whenever we perform:

```java
findParent(node)
```

we compress the path:

```java
return parent[node]=

findParent(parent[node]);
```

This makes all traversed nodes directly point to the ultimate parent.

Example:

Before Compression:

```text
1 <- 2 <- 3 <- 4
```

After calling:

```java
findParent(4)
```

The structure becomes:

```text
    1
  / | \
 2  3  4
```

Future operations become significantly faster.

---

### Why Union By Size Works?

Suppose:

```text
Component A = 100 nodes
Component B = 2 nodes
```

Attaching A under B would unnecessarily increase the tree height.

Instead:

```text
Attach B under A
```

The tree remains shallow.

This guarantees near-constant-time operations when combined with Path Compression.

---

## Problem Description

Implement a Disjoint Set Union (DSU) data structure using:

- Union By Size
- Path Compression

Support the following operations:

- `findParent(node)`
- `unionBySize(u, v)`

The data structure should efficiently maintain multiple disjoint sets and merge them when required.

---

## Input / Output Format

### Input

- Integer `n`
    - Number of nodes.

- Operations:
    - `unionBySize(u, v)`
    - `findParent(node)`

### Output

- No explicit output for union operations.
- `findParent(node)` returns the ultimate parent of the node.

### Notes

- Nodes are numbered from `0` to `n`.
- Initially each node forms its own set.
- Path Compression must be used.

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
Nodes 1,2,3 belong to the same component.
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
All nodes belong to the same component.
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
No union operation occurred.
Each node is its own parent.
```

---

## Constraints

- `1 <= n <= 10^5`
- Up to `10^5` union/find operations
- Nodes are indexed from `0` to `n`
- Path Compression must be used
- Union operation uses Size

---

## Algorithm

### Initialization

```java
for(int i = 0;
i <=n;i++){
parent[i]=i;
size[i]=1;
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

### Union By Size

```java
void unionBySize(int u, int v) {

    int pu = findParent(u);
    int pv = findParent(v);

    if (pu == pv)
        return;

    if (size[pu] < size[pv]) {
        parent[pu] = pv;
        size[pv] += size[pu];
    } else {
        parent[pv] = pu;
        size[pu] += size[pv];
    }
}
```

---

## Complexity Analysis

### Time Complexity

With Path Compression + Union By Size:

```text
O(α(N))
```

where α(N) is the Inverse Ackermann Function.

For practical purposes:

```text
Nearly O(1)
```

for both Find and Union operations.

| Operation | Complexity |
|-----------|------------|
| Find      | O(α(N))    |
| Union     | O(α(N))    |

---

### Space Complexity

```text
O(N)
```

for storing:

- parent array
- size array

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution