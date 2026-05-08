# Boundary Order Traversal of a Binary Tree

**Difficulty:** `Medium` | **Topics:** `Tree`, `Depth-First Search (DFS)`, `Divide and Conquer`

## Problem Statement

Given a binary tree, return the values of its boundary in an **anti-clockwise direction** starting from the root.

The boundary of a binary tree includes:

1. The **Root** node.
2. The **Left Boundary** (excluding leaf nodes).
3. All the **Leaf Nodes** (from left to right).
4. The **Right Boundary** (excluding leaf nodes), traversed in **reverse order** (bottom-up).

*Note: If the root doesn't have a left child or right child, then the root itself is the left or right boundary.
However, the root should not be duplicated in the output.*

### Examples

* **Example 1:**
    * **Input:** `root = [1, 2, 3, 4, 5, 6, 7, null, null, 8, 9]`
      ```text
              1
            /   \
           2     3
          / \   / \
         4   5 6   7
            / \
           8   9

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution