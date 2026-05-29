# Shortest Distance in Binary Maze

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, BFS, Matrix, Shortest Path, Queue

---

# Problem Description

Given a binary matrix `grid` of size `n x m`, where:

- `1` represents a traversable cell
- `0` represents a blocked cell

Find the shortest distance from a source cell to a destination cell.

You may move in four directions:

- Up
- Down
- Left
- Right

Return the minimum number of steps required to reach the destination.

If the destination cannot be reached, return `-1`.

---

# Input / Output Format

## Input

- `int[][] grid`
    - Binary matrix representing the maze.
- `int[] source`
    - Starting cell coordinates `[row, col]`
- `int[] destination`
    - Target cell coordinates `[row, col]`

## Output

- `int`
    - Minimum distance from source to destination.

## Important Notes

- You can only move through cells containing `1`.
- Source and destination are valid cells inside the matrix.
- If source equals destination, return `0`.

---

# Examples

## Example 1

### Input

```text
grid = [
  [1,1,1,1],
  [1,1,0,1],
  [1,1,1,1],
  [0,1,0,1]
]

source = [0,0]
destination = [3,3]
```

### Output

```text
6
```

### Explanation

One shortest path:

```text
(0,0) → (1,0) → (2,0) → (2,1)
→ (2,2) → (2,3) → (3,3)
```

---

## Example 2

### Input

```text
grid = [
  [1,0,0],
  [1,1,0],
  [0,1,1]
]

source = [0,0]
destination = [2,2]
```

### Output

```text
4
```

### Explanation

Shortest valid path length is `4`.

---

## Example 3

### Input

```text
grid = [
  [1,0],
  [0,1]
]

source = [0,0]
destination = [1,1]
```

### Output

```text
-1
```

### Explanation

Destination cannot be reached.

---

# Constraints

- `1 <= n, m <= 500`
- `grid[i][j]` is either `0` or `1`
- `source.length == 2`
- `destination.length == 2`

---

# Solution Approach

## Breadth First Search (BFS)

Since every move costs exactly `1`,
BFS guarantees the shortest path in an unweighted graph.

### Steps

1. Start BFS from source cell.
2. Explore all 4 directions.
3. Track distance for every cell.
4. Return distance when destination is reached.

If BFS ends without reaching destination:

- return `-1`.

---

# Time Complexity

```text
O(n * m)
```

---

# Space Complexity

```text
O(n * m)
```

---