# Minimum Multiplications to Reach End

## Metadata

- **Difficulty:** Medium
- **Topics:** Graph, BFS, Shortest Path, Modular Arithmetic

---

# Problem Description

Given:

- An array `arr[]` containing positive integers.
- A starting number `start`.
- A target number `end`.

In one operation, you can multiply the current number by any element of `arr[]` and take the result modulo `100000`.

Formally, if the current number is `x`, you may move to:

```text
(x * arr[i]) % 100000
```

for any valid index `i`.

Return the minimum number of multiplications required to reach `end` from `start`.

If it is impossible to reach `end`, return `-1`.

---

# Input / Output Format

## Input

- `int[] arr`
    - Array of multipliers.

- `int start`
    - Starting number.

- `int end`
    - Target number.

## Output

- Return the minimum number of multiplications needed to reach `end`.
- Return `-1` if reaching `end` is impossible.

## Important Notes

- Every generated number is taken modulo `100000`.
- The valid range of values is `[0, 99999]`.
- Each multiplication counts as one operation.

---

# Examples

## Example 1

### Input

```text
arr = [2, 5, 7]
start = 3
end = 30
```

### Output

```text
2
```

### Explanation

```text
3 → 6 (×2)
6 → 30 (×5)
```

Minimum operations = 2.

---

## Example 2

### Input

```text
arr = [3, 4, 65]
start = 7
end = 66175
```

### Output

```text
4
```

### Explanation

A sequence of four valid multiplications can reach the target.

---

## Example 3

### Input

```text
arr = [2]
start = 1
end = 3
```

### Output

```text
-1
```

### Explanation

No sequence of multiplications modulo 100000 can generate 3.

---

# Constraints

- `1 <= arr.length <= 10^4`
- `1 <= arr[i] <= 10^4`
- `0 <= start, end < 100000`
- Values are always taken modulo `100000`

---

# Solution Approach

## BFS on Numbers

Think of every number from:

```text
0 to 99999
```

as a node in a graph.

For every node `x`, edges exist to:

```text
(x * arr[i]) % 100000
```

Since every operation has equal weight (`1`), BFS guarantees that the first time we reach `end`, we have used the
minimum number of multiplications.

### Steps

1. Create a distance array of size `100000`.
2. Initialize all distances as infinity.
3. Start BFS from `start`.
4. For every multiplier:
    - Compute next state.
    - If not visited with a shorter distance:
        - Update distance.
        - Push into queue.
5. Return the distance when `end` is reached.

---

# Time Complexity

```text
O(100000 × N)
```

Where:

- `N` = arr.length

---

# Space Complexity

```text
O(100000)
```

For the distance array and BFS queue.