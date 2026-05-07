# Left View of Binary Tree

**Difficulty:** `Easy` | **Topics:** `Tree`, `Depth-First Search`, `Breadth-First Search`

## Problem Statement

Given a binary tree, return an array containing the values of the nodes you can see when the tree is viewed from the *
*left side**.

Imagine you are standing on the left side of the tree; you will only be able to see the first node present at each
level.

### Examples

* **Example 1:**
    * **Input:** `root = [1,2,3,4,5]`
      ```text
              1
            /   \
           2     3
          / \
         4   5
      ```
    * **Output:** `[1, 2, 4]`

* **Example 2:**
    * **Input:** `root = [1,null,3,null,4]`
      ```text
          1
           \
            3
             \
              4
      ```
    * **Output:** `[1, 3, 4]`
    * **Explanation:** Even though 3 and 4 are right children, because there are no left children blocking them at those
      levels, they are visible from the left side!

* **Example 3:**
    * **Input:** `root = []`
    * **Output:** `[]`

---

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution