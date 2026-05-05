# K-th Element of Two Sorted Arrays

**Difficulty:** `Medium` | **Topics:** `Array`, `Binary Search`, `Divide and Conquer`

## Problem Statement

Given two sorted arrays `a[]` and `b[]` and an element `k`, find the element that would be at the $k$-th position of the
final combined sorted array.

### Examples

* **Example 1:**
    * **Input:** `a[] = [2, 3, 6, 7, 9]`, `b[] = [1, 4, 8, 10]`, `k = 5`
    * **Output:** `6`
    * **Explanation:** The final combined sorted array would be `[1, 2, 3, 4, 6, 7, 8, 9, 10]`. The 5th element is 6.

* **Example 2:**
    * **Input:** `a[] = [1, 4, 8, 10, 12]`, `b[] = [5, 7, 11, 15, 17]`, `k = 6`
    * **Output:** `10`
    * **Explanation:** Combined sorted array is `[1, 4, 5, 7, 8, 10, 11, 12, 15, 17]`. The 6th element is 10.

---

## 🚀 Optimal Approach: Binary Search on Partitions

To achieve $O(\log(\min(m, n)))$ time complexity, we apply the same partition logic used in finding the median of two
sorted arrays. Instead of partitioning to find the exact middle, we partition such that exactly $k$ elements are on the
left side of the cut.

### Core Concept

Assume `a` is the smaller array. We want to pick $x$ elements from `a` and $y$ elements from `b` such that $x + y = k$.
If we make a cut at index `cut1` in array `a`, then `cut2` in array `b` must be `k - cut1`.

### The Boundary Trap (Crucial Difference from Median)

Unlike the median problem, $k$ can be larger than the size of one of the arrays, or very small. Therefore, our binary
search bounds for `cut1` must be carefully defined:

* **Minimum elements from `a` (`low`):** $\max(0, k - \text{length}(b))$. If $k$ is greater than the total elements in
  `b`, we *must* pick at least the difference from `a`.
* **Maximum elements from `a` (`high`):** $\min(k, \text{length}(a))$. We cannot pick more than $k$ elements, nor can we
  pick more elements than `a` actually contains.

### Algorithm

1. Ensure `a` is the smaller array to minimize the search space. If not, swap the arrays and try again.
2. Set `low = Math.max(0, k - b.length)` and `high = Math.min(k, a.length)`.
3. Perform Binary Search:
    * `cut1 = (low + high) / 2`
    * `cut2 = k - cut1`
4. Calculate boundaries: `l1`, `r1`, `l2`, `r2` (handling edge cases with `-infinity` and `+infinity`).
5. **Check validity:**
    * If `l1 <= r2` and `l2 <= r1`: Valid partition! The $k$-th element is $\max(l1, l2)$.
    * If `l1 > r2`: We took too many elements from `a`. Move `high = cut1 - 1`.
    * Else: We took too few elements from `a`. Move `low = cut1 + 1`.

### Complexity Analysis

* **Time Complexity:** $O(\log(\min(m, n)))$
* **Space Complexity:** $O(1)$