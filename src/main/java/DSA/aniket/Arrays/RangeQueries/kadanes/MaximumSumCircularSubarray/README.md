# Maximum Sum Circular Array

**Difficulty:** Medium  
**Topics:** Arrays, Dynamic Programming, Queue

## Problem Description

You are given a **circular array** `arr` of size `n`. Your task is to find the maximum possible sum of a **non-empty**
subarray of `arr`.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of
`arr[i]` is `arr[(i + 1) % n]`, and the previous element of `arr[i]` is `arr[(i - 1 + n) % n]`.

A subarray may only include each element of the fixed buffer `arr` at most once. (Formally, for a subarray
`arr[i], arr[i + 1], ..., arr[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`.)

---

## Input / Output Format

**Input Format:**

* The first line contains an integer `n`, which is the size of `arr`.
* The second line contains `n` space-separated integers representing the elements of `arr`.

**Output Format:**

* Return a single integer denoting the maximum possible sum of a non-empty subarray.

---

## Examples

### Example 1

**Input:**

```text
4
1 -2 3 -2
```
