# Rotation Count in a Rotated Sorted Array

Given a sorted array `arr[]` (in strictly increasing order) that has been right-rotated `k` times.

A **right rotation** means the last element is moved to the first position, and the remaining elements are shifted one
position to the right. Your task is to find the value of `k`—the number of times the array was right-rotated from its
originally sorted form.

## Key Insight

In a right-rotated sorted array, the rotation count `k` is equivalent to the **index of the minimum element**.

## Examples

### Example 1:

**Input:** `arr[] = [15, 18, 2, 3, 6, 12]`  
**Output:** `2`  
**Explanation:**

* Original sorted array = `[2, 3, 6, 12, 15, 18]`
* After 1st right rotation → `[18, 2, 3, 6, 12, 15]`
* After 2nd right rotation → `[15, 18, 2, 3, 6, 12]`  
  The minimum element is `2`, which is at index `2`.

### Example 2:

**Input:** `arr[] = [7, 9, 11, 12, 5]`  
**Output:** `4`  
**Explanation:**

* Original sorted array = `[5, 7, 9, 11, 12]`
* After 4 right rotations → `[7, 9, 11, 12, 5]`
  The minimum element is `5`, which is at index `4`.

### Example 3:

**Input:** `arr[] = [7, 9, 11, 12, 15]`  
**Output:** `0`  
**Explanation:** The array is already sorted, so `k = 0`. The minimum element is at index `0`.

## Complexity Goal

* **Time Complexity:** $O(\log n)$ using a Binary Search approach.
* **Auxiliary Space:** $O(1)$.