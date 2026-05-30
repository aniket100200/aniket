# Number of Ways to Arrive at Destination

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, Dijkstra's Algorithm, Shortest Path, Dynamic Programming, Priority Queue

---

# Problem Description

You are in a city consisting of `n` intersections numbered from `0` to `n - 1`.

You are given a 2D integer array `roads` where:

```text
roads[i] = [u, v, time]
```

indicates that there is a bidirectional road between intersections `u` and `v` taking `time` minutes to travel.

Your task is to determine the number of different ways to travel from intersection `0` to intersection `n - 1` in the
minimum possible time.

Since the answer can be very large, return it modulo:

```text
1,000,000,007
```

---

# Input / Output Format

## Input

- `int n`
    - Number of intersections.

- `int[][] roads`
    - Each road contains:
        - `u` → source intersection
        - `v` → destination intersection
        - `time` → travel time

## Output

- Return the number of shortest paths from node `0` to node `n - 1`.
- Return the answer modulo `1,000,000,007`.

## Important Notes

- Roads are bidirectional.
- Multiple shortest paths may exist.
- Use modulo `1,000,000,007` to avoid overflow.

---

# Examples

## Example 1

### Input

```text
n = 7

roads =
[
 [0,6,7],
 [0,1,2],
 [1,2,3],
 [1,3,3],
 [6,3,3],
 [3,5,1],
 [6,5,1],
 [2,5,1],
 [0,4,5],
 [4,6,2]
]
```

### Output

```text
4
```

### Explanation

The minimum time from node `0` to node `6` is `7`.

There are 4 different shortest paths achieving this minimum time.

---

## Example 2

### Input

```text
n = 2

roads =
[
 [1,0,10]
]
```

### Output

```text
1
```

### Explanation

There is exactly one path from node `0` to node `1`.

---

## Example 3

### Input

```text
n = 4

roads =
[
 [0,1,1],
 [1,3,1],
 [0,2,1],
 [2,3,1]
]
```

### Output

```text
2
```

### Explanation

Two shortest paths exist:

```text
0 → 1 → 3
0 → 2 → 3
```

Both have total cost 2.

---

# Constraints

- `1 <= n <= 200`
- `n - 1 <= roads.length <= n * (n - 1) / 2`
- `0 <= u, v < n`
- `1 <= time <= 10^9`
- Graph is connected.
- Answer should be returned modulo `1,000,000,007`.

---

# Solution Approach

## Dijkstra + Path Counting

We use Dijkstra's Algorithm to find shortest distances.

Additionally:

- `dist[i]` stores shortest distance to node `i`
- `ways[i]` stores number of shortest paths to node `i`

### Relaxation Rules

#### Better Distance Found

```text
newDist < dist[adjNode]
```

Update:

```text
dist[adjNode] = newDist
ways[adjNode] = ways[node]
```

---

#### Another Shortest Path Found

```text
newDist == dist[adjNode]
```

Update:

```text
ways[adjNode] += ways[node]
```

Apply modulo:

```text
1,000,000,007
```

---

# Time Complexity

```text
O((V + E) log V)
```

Where:

- `V` = number of nodes
- `E` = number of roads

---

# Space Complexity

```text
O(V + E)
```