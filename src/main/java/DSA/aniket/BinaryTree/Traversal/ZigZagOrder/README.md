# Binary Tree Zigzag Level Order Traversal

**Difficulty:** `Medium` | **Topics:** `Tree`, `Breadth-First Search (BFS)`, `Queue`

## Problem Statement

Given the `root` of a binary tree, return *the zigzag level order traversal of its nodes' values*. (i.e., from left to
right, then right to left for the next level and alternate between).

### Examples

* **Example 1:**
    * **Input:** `root = [3,9,20,null,null,15,7]`
      ```text
          3
         / \
        9  20
          /  \
         15   7
      ```
    * **Output:** `[[3], [20, 9], [15, 7]]`
    * **Explanation:**
        * Level 0 (L to R): `[3]`
        * Level 1 (R to L): `[20, 9]`
        * Level 2 (L to R): `[15, 7]`

* **Example 2:**
    * **Input:** `root = [1]`
    * **Output:** `[[1]]`

* **Example 3:**
    * **Input:** `root = []`
    * **Output:** `[]`

---