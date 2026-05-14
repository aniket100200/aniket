[//]: # (It's the Question From Competative Programming)

# Max Sum of Rectangle No Larger Than K

**Difficulty:** Hard  
**Topics:** Array, Binary Search, Matrix, Prefix Sum, Ordered Set

## Problem Description

Given an `m x n` matrix `matrix` and an integer `k`, return the **max sum** of a rectangle in the matrix such that its
sum is no larger than `k`.

It is guaranteed that there will be a rectangle with a sum no larger than `k`.

---

## Input / Output Format

**Input Format:**

* The first line contains `m` and `n` representing the dimensions of the matrix.
* The next `m` lines contain `n` space-separated integers representing the matrix elements.
* The last line contains an integer `k`.

**Output Format:**

* Return a single integer representing the max sum of a rectangle in the matrix such that its sum is `<= k`.

---

## Examples

### Example 1

**Input:**

```text
2 3
1 0 1
0 -2 3
2
```