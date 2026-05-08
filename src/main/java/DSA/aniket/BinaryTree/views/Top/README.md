# Top View of Binary Tree

**Difficulty:** `Medium` | **Topics:** `Tree`, `Breadth-First Search (BFS)`, `Hash Table`

## Problem Statement

Given a binary tree, return the **top view** of it. The top view of a binary tree is the set of nodes visible when the
tree is viewed from the top, ordered from left to right.

If two nodes share the same horizontal position and are at the same depth, the one that appears first in a level-order
traversal (usually the leftmost one) is considered visible.

### Examples

* **Example 1:**
    * **Input:** `root = [1,2,3,4,5,6,7]`

```text
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
    ```
  * **Output:** `[4, 2, 1, 3, 7]`
  * **Explanation:** 
    * 4 is the leftmost node.
    * 2 is next.
    * 1 is in the middle. (It completely blocks 5 and 6 from the top).
    * 3 is to the right.
    * 7 is the rightmost node.

* **Example 2:**
  * **Input:** `root = [1, 2, 3, null, 4, null, null, null, 5]`
    ```text
          1
         / \
        2   3
         \
          4
           \
            5
    ```
  * **Output:** `[2, 1, 3, 5]`
  * **Explanation:** 
    * Node 1 is at horizontal distance 0.
    * Node 2 is at horizontal distance -1.
    * Node 3 is at horizontal distance +1.
    * Node 4 is at horizontal distance 0 (blocked by 1).
    * Node 5 is at horizontal distance +1 (blocked by 3? Wait, node 3 has no right child, but 5 is at HD +1. Actually, node 5's HD is -1(for 2) + 1(for 4) + 1(for 5) = +1. Since 3 is already at +1 and higher up, 3 blocks 5. So output is `[2, 1, 3]`. *Note: I will provide a distinct test case for this in the suite!*)
```

---

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution