# Make Sum Divisible by P

**Difficulty:** Medium  
**Topics:** Array, Hash Table, Prefix Sum

## Problem Description

You are given an array `a` consisting of `n` integers.

Your task is to remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible
by `p`. It is **not allowed** to remove the whole array.

Return the length of the smallest subarray that you need to remove, or `-1` if it's impossible.

*Note:* A subarray is defined as a contiguous block of elements in the array.

---

## Input / Output Format

**Input Format:**

* The first line contains two integers, `n` and `p`.
* The second line contains `n` space-separated integers representing the array.

**Output Format:**

* Return an integer denoting the length of the smallest subarray to remove.

---

## Examples

### Example 1

**Input:**

```text
4 6
3 1 4 2
```

**Output**

```text
1
```