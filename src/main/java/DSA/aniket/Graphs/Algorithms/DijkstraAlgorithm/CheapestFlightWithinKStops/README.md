# Cheapest Flights Within K Stops

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, BFS, Shortest Path, Dynamic Programming, Queue

---

# Problem Description

There are `n` cities connected by some number of flights. You are given an array `flights` where:

- `flights[i] = [from, to, price]`

indicates that there is a flight from city `from` to city `to` with cost `price`.

You are also given three integers:

- `src` → starting city
- `dst` → destination city
- `k` → maximum number of stops allowed

Return the cheapest price from `src` to `dst` with at most `k` stops. If there is no such route, return `-1`.

A stop means an intermediate city between the source and destination.

---

# Input / Output Format

## Input

- `int n`
    - Number of cities.

- `int[][] flights`
    - Each entry contains:
        - `from`
        - `to`
        - `price`

- `int src`
    - Starting city.

- `int dst`
    - Destination city.

- `int k`
    - Maximum allowed stops.

## Output

- Return an integer representing:
    - Minimum flight cost from `src` to `dst`
    - `-1` if no valid route exists.

## Important Notes

- Cities are labeled from `0` to `n - 1`.
- At most `k` intermediate stops are allowed.
- Cycles may exist in the graph.

---

# Examples

## Example 1

### Input

```text
n = 4
flights = [[0,1,100],[1,2,100],[2,3,100],[0,3,500]]
src = 0
dst = 3
k = 1
```

### Output

```text
500
```

### Explanation

The direct flight from city `0` to `3` costs `500`.

The route `0 -> 1 -> 2 -> 3` costs `300` but uses 2 stops, which exceeds `k = 1`.

---

## Example 2

### Input

```text
n = 3
flights = [[0,1,100],[1,2,100],[0,2,500]]
src = 0
dst = 2
k = 1
```

### Output

```text
200
```

### Explanation

The path `0 -> 1 -> 2` costs `200` and uses 1 stop, which is valid.

---

## Example 3

### Input

```text
n = 3
flights = [[0,1,100],[1,2,100],[0,2,500]]
src = 0
dst = 2
k = 0
```

### Output

```text
500
```

### Explanation

No stops are allowed, so only the direct flight can be used.

---

# Constraints

- `1 <= n <= 100`
- `0 <= flights.length <= 10^4`
- `0 <= from, to < n`
- `from != to`
- `1 <= price <= 10^4`
- `0 <= k < n`
- There will not be multiple flights between the same two cities.

---

# Solution Approach

## BFS with Cost Tracking

We use a modified BFS approach:

1. Build an adjacency list from the flight data.
2. Use a queue to process:
    - current city
    - total cost
    - number of stops used
3. Maintain the minimum cost for each city.
4. Only continue traversal if:
    - stops do not exceed `k`
    - current path is cheaper than previously known paths

---

# Time Complexity

```text
O(E * K)
```

Where:

- `E` = number of flights

---

# Space Complexity

```text
O(V + E)
```

Where:

- `V` = number of cities
- `E` = number of flights