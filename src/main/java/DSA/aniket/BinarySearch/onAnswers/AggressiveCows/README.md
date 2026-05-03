# Aggressive Cows

**Difficulty:** Medium  
**Topics:** Binary Search, Greedy Algorithm, Sorting

## Problem Statement

You are given an array with unique elements of `stalls[]`, which denote the positions of stalls. You are also given an
integer `k` which denotes the number of aggressive cows.

The task is to assign `stalls` to `k` cows such that the **minimum distance** between any two of them is the **maximum**
possible.

## Examples

**Example 1:**
> **Input:** `stalls[] = [1, 2, 4, 8, 9]`, `k = 3`  
> **Output:** `3`  
> **Explanation:** The first cow can be placed at `stalls[0]`, the second cow at `stalls[2]`, and the third cow at
`stalls[3]`. The minimum distance between cows in this case is `3`, which is the largest among all possible ways.

**Example 2:**
> **Input:** `stalls[] = [10, 1, 2, 7, 5]`, `k = 3`  
> **Output:** `4`  
> **Explanation:** The first cow can be placed at `stalls[0]`, the second cow at `stalls[1]`, and the third cow at
`stalls[4]`. The minimum distance between cows in this case is `4`, which is the largest among all possible ways.

**Example 3:**
> **Input:** `stalls[] = [2, 12, 11, 3, 26, 7]`, `k = 5`  
> **Output:** `1`  
> **Explanation:** There are 6 stalls and only 5 cows. The minimum distance between cows in this case is `1`, which is
> the largest among all possible ways.

## Constraints

* `2 <= stalls.size() <= 10^6`
* `0 <= stalls[i] <= 10^8`
* `2 <= k <= stalls.size()`