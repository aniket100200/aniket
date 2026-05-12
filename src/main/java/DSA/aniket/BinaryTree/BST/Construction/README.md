# Convert Sorted Array to Binary Search Tree

**Difficulty:** Easy  
**Topics:** Array, Divide and Conquer, Tree, Binary Search Tree (BST), Binary Tree

## Problem Description

Given an integer array `nums` where the elements are sorted in **strictly increasing order** (representing the inorder
traversal of a BST), convert it to a **height-balanced** binary search tree.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by
more than one.

---

## Examples

### Example 1:

**Input:** `nums = [-10, -3, 0, 5, 9]`  
**Output:** `[0, -3, 9, -10, null, 5]`  
**Explanation:**

```text
      0
     / \
   -3   9
   /   /
 -10  5
 ```

---

### Constraints

- 1 <= nums.length <= 10^4

- -10^4 <= nums[i] <= 10^4

- nums is sorted in a strictly increasing order.