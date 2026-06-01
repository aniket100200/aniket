# Find the City With the Smallest Number of Neighbors at a Threshold Distance

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Floyd-Warshall Algorithm, Shortest Path, Matrix, Greedy

## Problem Description

There are `n` cities numbered from `0` to `n - 1`.

You are given:

- An integer `n` representing the number of cities.
- A list of edges where `edges[i] = [fromi, toi, weighti]` represents a bidirectional weighted edge between cities
  `fromi` and `toi`.
- An integer `distanceThreshold`.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most
`distanceThreshold`.

If there are multiple such cities, return the city with the greatest index.

The Floyd-Warshall algorithm can be used to compute the shortest distance between every pair of cities before counting
the reachable neighbors.

---

## Input / Output Format

### Input

- `int n`
    - Number of cities.
- `int[][] edges`
    - Each element is of the form `[u, v, weight]`.
- `int distanceThreshold`
    - Maximum allowed shortest-path distance.

### Output

- Return an integer representing the city that has the smallest number of reachable neighbors within the threshold
  distance.
- If multiple cities have the same count, return the city with the largest index.

### Notes

- The graph is undirected.
- A city is considered reachable from itself.
- Floyd-Warshall computes all-pairs shortest paths in `O(n³)` time.

---

## Examples

### Example 1

Input

```text
n = 4

edges = [
 [0,1,3],
 [1,2,1],
 [1,3,4],
 [2,3,1]
]

distanceThreshold = 4
```

Output

```text
3
```

Explanation

```text
City 0 can reach: 0,1,2
City 1 can reach: 0,1,2,3
City 2 can reach: 0,1,2,3
City 3 can reach: 1,2,3

Cities 0 and 3 can reach 3 cities each.
Return the larger index => 3.
```

---

### Example 2

Input

```text
n = 5

edges = [
 [0,1,2],
 [0,4,8],
 [1,2,3],
 [1,4,2],
 [2,3,1],
 [3,4,1]
]

distanceThreshold = 2
```

Output

```text
0
```

Explanation

```text
City 0 has the minimum number of reachable cities within threshold distance.
```

---

### Example 3

Input

```text
n = 2

edges = [
 [0,1,5]
]

distanceThreshold = 3
```

Output

```text
1
```

Explanation

```text
Neither city can reach the other within threshold distance.

Both have the same count, so return the larger index.
```

---

## Constraints

- `2 <= n <= 100`
- `1 <= edges.length <= n * (n - 1) / 2`
- `0 <= ui < vi < n`
- `1 <= weighti <= 10^4`
- `1 <= distanceThreshold <= 10^4`
- All `(ui, vi)` pairs are distinct.
- Time Complexity: **O(n³)**
- Space Complexity: **O(n²)**