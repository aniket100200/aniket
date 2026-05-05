# Median of Two Sorted Arrays

**Difficulty:** `Hard` | **Topics:** `Array`, `Binary Search`, `Divide and Conquer`

## Problem Statement

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted
arrays.

The overall run time complexity must be **$O(\log(m+n))$**.

### Examples

* **Example 1:**
    * **Input:** `nums1 = [1,3]`, `nums2 = [2]`
    * **Output:** `2.00000`
    * **Explanation:** merged array = `[1,2,3]` and median is 2.

* **Example 2:**
    * **Input:** `nums1 = [1,2]`, `nums2 = [3,4]`
    * **Output:** `2.50000`
    * **Explanation:** merged array = `[1,2,3,4]` and median is `(2 + 3) / 2 = 2.5`.

---

[//]: # ()

[//]: # (## 🚀 Optimal Approach: Binary Search on Partitions)

[//]: # ()

[//]: # (To achieve $O&#40;\log&#40;m+n&#41;&#41;$ complexity, we cannot iterate through the arrays. Instead, we perform a binary search on the *)

[//]: # (*smaller array** to find the correct partition &#40;or "cut"&#41;.)

[//]: # ()

[//]: # (### Core Concept)

[//]: # ()

[//]: # (The median divides a dataset into two equal halves. If we make a random cut in `nums1` and a corresponding cut in)

[//]: # (`nums2`, we partition both arrays into a combined Left Half and a combined Right Half.)

[//]: # ()

[//]: # (For the partition to be perfectly balanced around the median, two conditions must be met:)

[//]: # ()

[//]: # (1. **Length Condition:** `Left_Part_Length == Right_Part_Length` &#40;or `Left + 1` if the total length is odd&#41;.)

[//]: # (2. **Cross-Boundary Condition:** Every element on the Left must be less than or equal to every element on the Right.)

[//]: # (    * `maxLeft1 <= minRight2`)

[//]: # (    * `maxLeft2 <= minRight1`)

[//]: # ()

[//]: # (### Algorithm)

[//]: # ()

[//]: # (1. Ensure `nums1` is the smaller array to minimize the binary search space. If not, swap them.)

[//]: # (2. Initialize binary search pointers for `nums1`: `low = 0`, `high = nums1.length`.)

[//]: # (3. Calculate partitions:)

[//]: # (    * `partition1 = &#40;low + high&#41; / 2`)

[//]: # (    * `partition2 = &#40;m + n + 1&#41; / 2 - partition1`)

[//]: # (4. Find the 4 boundary elements: `maxLeft1`, `minRight1`, `maxLeft2`, `minRight2` &#40;use `-infinity` and `infinity` for)

[//]: # (   edge cases&#41;.)

[//]: # (5. **Check conditions:**)

[//]: # (    * If `maxLeft1 <= minRight2` and `maxLeft2 <= minRight1`: We found the perfect cut!)

[//]: # (        * If total length is even: `&#40;max&#40;maxLeft1, maxLeft2&#41; + min&#40;minRight1, minRight2&#41;&#41; / 2.0`)

[//]: # (        * If total length is odd: `max&#40;maxLeft1, maxLeft2&#41;`)

[//]: # (    * If `maxLeft1 > minRight2`: We are too far right in `nums1`. Move `high = partition1 - 1`.)

[//]: # (    * Else: We are too far left. Move `low = partition1 + 1`.)

[//]: # ()

[//]: # (### Complexity Analysis)

[//]: # ()

[//]: # (* **Time Complexity:** $O&#40;\log&#40;\min&#40;m, n&#41;&#41;&#41;$ because we only perform binary search on the smaller array.)

[//]: # (* **Space Complexity:** $O&#40;1&#41;$ as we only use a few integer variables for pointers and boundaries.)