# Binary Tree Postorder Traversal

**Difficulty:** `Easy` | **Topics:** `Tree`, `Depth-First Search`, `Binary Tree`

## Problem Statement

Given the `root` of a binary tree, return *the postorder traversal of its nodes' values*.

**Postorder Traversal Strategy:**

1. Traverse the **Left** subtree.
2. Traverse the **Right** subtree.
3. Visit the **Root** node.

### Examples

* **Example 1:**
    * **Input:** `root = [1,null,2,3]`
      ```text
        1
         \
          2
         /
        3
      ```
    * **Output:** `[3, 2, 1]`

* **Example 2:**
    * **Input:** `root = []`
    * **Output:** `[]`

* **Example 3:**
    * **Input:** `root = [1]`
    * **Output:** `[1]`

* **Example 4:**
    * **Input:** `root = [1,2,3,4,5,null,8,null,null,6,7,9]`
      ```text
              1
            /   \
           2     3
          / \     \
         4   5     8
            / \   /
           6   7 9
      ```
    * **Output:** `[4, 6, 7, 5, 2, 9, 8, 3, 1]`

---

## Constraints:

* The number of nodes in the tree is in the range `[0, 100]`.
* `-100 <= Node.val <= 100`

## Follow up:

Recursive solution is trivial, could you do it iteratively using a Stack?