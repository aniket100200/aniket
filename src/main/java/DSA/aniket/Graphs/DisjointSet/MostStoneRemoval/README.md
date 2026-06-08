# Most Stones Removed with Same Row or Column

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Disjoint Set Union (DSU), Union-Find, Connected Components

---

## Problem Description

On a 2D plane, we place `n` stones at integer coordinate points.

A stone can be removed if there exists another stone in the same row or the same column that has not been removed.

Given an array `stones` where:

```text
stones[i] = [xi, yi]
```

represents the coordinates of the `i-th` stone.

Return the maximum number of stones that can be removed.

---

## Input / Output Format

### Input

- `int[][] stones`
    - `stones[i][0]` = row coordinate
    - `stones[i][1]` = column coordinate

### Output

- Return an integer representing the maximum number of stones that can be removed.

### Notes

- A stone can be removed if another stone exists in the same row or column.
- The final remaining stones equal the number of connected components.
- Answer = Total Stones − Number of Connected Components.

---

## Examples

### Example 1

**Input**

```text
stones =
[
 [0,0],
 [0,1],
 [1,0],
 [1,2],
 [2,1],
 [2,2]
]
```

**Output**

```text
5
```

**Explanation**

All stones belong to one connected component.

```text
6 - 1 = 5
```

stones can be removed.

---

### Example 2

**Input**

```text
stones =
[
 [0,0],
 [0,2],
 [1,1],
 [2,0],
 [2,2]
]
```

**Output**

```text
3
```

**Explanation**

There are 2 connected components.

```text
5 - 2 = 3
```

---

### Example 3

**Input**

```text
stones =
[
 [0,0]
]
```

**Output**

```text
0
```

**Explanation**

No stone can be removed.

---

## Constraints

- `1 <= stones.length <= 1000`
- `0 <= xi, yi <= 10000`
- No two stones are at the same position.
- Expected Time Complexity: **O(N × α(N))**
- Expected Auxiliary Space: **O(N)**

---

## Approach (DSU)

### Key Observation

If two stones share:

- Same row
- Same column

then they belong to the same connected component.

For every connected component:

```text
componentSize - 1
```

stones can be removed.

Therefore:

```text
Answer = Total Stones - NumberOfConnectedComponents
```

### DSU Strategy

Treat:

```text
Row Node = row
Column Node = col + maxRow + 1
```

For every stone:

```text
union(rowNode, colNode)
```

Count unique DSU parents among used nodes.

### Time Complexity

```text
O(N × α(N))
```

### Space Complexity

```text
O(maxRow + maxCol)
```

---