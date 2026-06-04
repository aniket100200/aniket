# Number of Islands II

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Disjoint Set Union (DSU), Union-Find, Dynamic Connectivity

---

## Problem Description

You are given an initially empty `n × m` grid where every cell contains water (`0`).

A list of operations is provided where each operation converts a water cell into land (`1`).

After each operation, determine the number of islands present in the grid.

An island is formed by connecting adjacent land cells horizontally or vertically (4-directionally).

Return an array where the `i-th` element represents the number of islands after performing the `i-th` operation.

---

## Input / Output Format

### Input

- `int n` → Number of rows.
- `int m` → Number of columns.
- `int[][] operators`
    - `operators[i][0]` = row index
    - `operators[i][1]` = column index

### Output

- Return `List<Integer>`
- The `i-th` value represents the number of islands after the `i-th` operation.

### Notes

- Initially all cells contain water.
- Multiple operations may target the same cell.
- Cells are connected only in four directions:
    - Up
    - Down
    - Left
    - Right

---

## Examples

### Example 1

**Input**

```text
n = 4
m = 5

operators =
[
 [1,1],
 [0,1],
 [3,3],
 [3,4]
]
```

**Output**

```text
[1,1,2,2]
```

**Explanation**

Operation 1:

```text
00000
01000
00000
00000
```

Islands = 1

Operation 2:

```text
01000
01000
00000
00000
```

Islands = 1

Operation 3:

```text
01000
01000
00000
00010
```

Islands = 2

Operation 4:

```text
01000
01000
00000
00011
```

Islands = 2

---

### Example 2

**Input**

```text
n = 4
m = 5

operators =
[
 [0,0],
 [1,1],
 [2,2],
 [3,3]
]
```

**Output**

```text
[1,2,3,4]
```

**Explanation**

Each newly added land is isolated from previous lands.

---

### Example 3

**Input**

```text
n = 3
m = 3

operators =
[
 [0,0],
 [0,1],
 [1,2],
 [2,1],
 [1,1]
]
```

**Output**

```text
[1,1,2,3,1]
```

**Explanation**

The last operation connects multiple islands into one.

---

## Constraints

- `1 <= n, m <= 100`
- `1 <= operators.length <= 1000`
- `0 <= row < n`
- `0 <= col < m`
- Expected Time Complexity: **O(k × α(n × m))**
- Expected Auxiliary Space: **O(n × m)**

---

## Approach (Disjoint Set Union)

### Key Observation

When a land cell is added:

1. Assume it forms a new island.
2. Check its 4 neighboring cells.
3. If a neighboring cell is already land:
    - Merge both components using DSU.
    - Reduce island count if a union occurs.

### Why DSU?

DSU efficiently maintains connected components dynamically.

- Find Parent → Nearly O(1)
- Union By Size → Nearly O(1)

This allows us to process each operation efficiently.

### Time Complexity

```text
O(k × α(n × m))
```

### Space Complexity

```text
O(n × m)
```

---