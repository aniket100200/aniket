# Path With Minimum Effort

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Dijkstra's Algorithm, Matrix, Priority Queue, BFS

---

# Problem Description

You are given a 2D grid `heights` where:

- `heights[row][col]` represents the height of a cell.

You are situated at the top-left cell `(0,0)` and want to travel to the bottom-right cell `(n-1,m-1)`.

You can move in four directions:

- Up
- Down
- Left
- Right

The **effort** of a path is defined as:

```text
Maximum absolute difference in heights between two consecutive cells.
```

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

---

# Input / Output Format

## Input

- `int[][] heights`
    - Matrix representing heights of cells.

## Output

- `int`
    - Minimum effort required.

## Important Notes

- You may move only in four directions.
- Effort is determined by the maximum edge cost in the chosen path.
- The goal is to minimize this maximum effort.

---

# Examples

## Example 1

### Input

```text
heights = [
  [1,2,2],
  [3,8,2],
  [5,3,5]
]
```

### Output

```text
2
```

### Explanation

Path:

```text
1 → 3 → 5 → 3 → 5
```

Maximum absolute difference:

```text
max(|1-3|, |3-5|, |5-3|, |3-5|) = 2
```

---

## Example 2

### Input

```text
heights = [
  [1,2,3],
  [3,8,4],
  [5,3,5]
]
```

### Output

```text
1
```

### Explanation

A path exists where the maximum effort is `1`.

---

## Example 3

### Input

```text
heights = [
  [1,2,1,1,1],
  [1,2,1,2,1],
  [1,2,1,2,1],
  [1,2,1,2,1],
  [1,1,1,2,1]
]
```

### Output

```text
0
```

### Explanation

A path exists where adjacent differences are always `0`.

---

# Constraints

- `1 <= rows, cols <= 100`
- `1 <= heights[i][j] <= 10^6`

---

# Solution Approach

## Modified Dijkstra’s Algorithm

Instead of minimizing:

- total distance

we minimize:

- maximum edge effort along the path.

### Key Idea

For every move:

```text
newEffort =
max(currentEffort,
abs(height difference))
```

Use a min-heap to always process the path with minimum current effort.

---

# Time Complexity

```text
O((n * m) log(n * m))
```

---

# Space Complexity

```text
O(n * m)
```

---