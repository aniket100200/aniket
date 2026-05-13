# Range Sum Query

**Difficulty:** Easy  
**Max Score:** 30  
**Topics:** Array, Prefix Sum, Design

## Problem Description

Given an integer array `nums`, handle multiple queries of the following type:
Calculate the **sum** of the elements of `nums` between indices `left` and `right` inclusive where `left <= right`.

Implement the `NumArray` class:

* `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
* `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right`
  inclusive (i.e. `nums[left] + nums[left + 1] + ... + nums[right]`).

---

## Input / Output Format

**Input Format:**

* The first line contains an integer `n` denoting the size of the array.
* The second line contains `n` space-separated integers that denote the array.
* The third line contains an integer `m` which is the number of queries to calculate the range sum.
* The next `m` lines contain 2 integers each, which denote `left` and `right`.

**Output Format:**

* For each query, output the sum of the specified range.

---

## Examples

### Example 1

**Input:**

```text
6
-2 0 3 -5 2 -1
3
0 2 
2 5
0 5