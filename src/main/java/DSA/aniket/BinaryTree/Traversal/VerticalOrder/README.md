# Vertical Order Traversal of a Binary Tree

**Difficulty:** `Hard` | **Topics:** `Tree`, `Depth-First Search (DFS)`, `Breadth-First Search (BFS)`, `Hash Table`,
`Sorting`

## Problem Statement

Given the `root` of a binary tree, calculate the **vertical order traversal** of the binary tree.

For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and
`(row + 1, col + 1)` respectively. The root of the tree is at `(0, 0)`.

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from
the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In
such a case, **sort these nodes by their values**.

### Examples

* **Example 1:**
    * **Input:** `root = [3,9,20,null,null,15,7]`
      ```text
            3 (0,0)
           / \
          /   \

(-1,1) 9 20 (1,1)
/  \
(0,2) 15 7 (2,2)

```
* **Output:** `[[9], [3, 15], [20], [7]]`
* **Explanation:**
    * Column -1: Only node 9 is in this column.
    * Column 0: Nodes 3 and 15 are in this column. 3 is higher than 15, so it comes first.
    * Column 1: Only node 20 is in this column.
    * Column 2: Only node 7 is in this column.

* **Example 2:**
    * **Input:** `root = [1,2,3,4,5,6,7]`
      ```text
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
      ```
    * **Output:** `[[4], [2], [1, 5, 6], [3], [7]]`
    * **Explanation:**
        * Nodes 5 and 6 are at the exact same position `(row = 2, col = 0)`.
        * Because they share the exact same coordinates, they must be sorted by value (`5` comes before `6`).

---
```

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution