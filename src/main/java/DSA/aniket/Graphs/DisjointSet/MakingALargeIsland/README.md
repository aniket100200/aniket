# Making A Large Island

## Metadata

- **Difficulty:** Hard
- **Topics:** Graphs, DFS, Disjoint Set Union (DSU), Matrix, Connected Components

---

## Problem Description

You are given an `n x n` binary matrix `grid` consisting of only `0`s and `1`s.

You may change **at most one `0` into a `1`**.

Return the size of the largest island possible after performing this operation.

An island is a group of connected `1`s connected horizontally or vertically.

If the grid already consists entirely of `1`s, return the size of the whole grid.

---

## Input / Output Format

### Input

- `int[][] grid`
    - `0` represents water.
    - `1` represents land.

### Output

- Return an integer representing the largest island size obtainable by converting at most one `0` into `1`.

### Notes

- Only one water cell may be converted.
- Connectivity is 4-directional.
- If there are no water cells, return `n × n`.

---

## Examples

### Example 1

**Input**

```text
grid =
[
 [1,0],
 [0,1]
]
```

**Output**

```text
3
```

**Explanation**

Convert either water cell.

```text
[
 [1,1],
 [0,1]
]
```

Largest island size becomes 3.

---

### Example 2

**Input**

```text
grid =
[
 [1,1],
 [1,0]
]
```

**Output**

```text
4
```

**Explanation**

Convert the bottom-right water cell.

Entire grid becomes one island.

---

### Example 3

**Input**

```text
grid =
[
 [1,1],
 [1,1]
]
```

**Output**

```text
4
```

**Explanation**

Grid already contains one island occupying all cells.

---

## Constraints

- `1 <= n <= 500`
- `grid.length == n`
- `grid[i].length == n`
- `grid[i][j] ∈ {0,1}`
- Expected Time Complexity: **O(n² × α(n²))**
- Expected Auxiliary Space: **O(n²)**

---

## Approach (DSU)

### Observation

If we flip a `0` to `1`:

- It can connect up to 4 neighboring islands.
- We need the sum of all distinct neighboring island sizes + 1.

### Steps

1. Build DSU for all existing land cells.
2. Store size of every connected component.
3. For each `0`:
    - Collect unique neighboring island parents.
    - Sum their sizes.
    - Add 1 for the flipped cell.
4. Track the maximum answer.
5. Handle the special case when the grid already contains only `1`s.

### Time Complexity

```text
O(n² × α(n²))
```

### Space Complexity

```text
O(n²)
```

---