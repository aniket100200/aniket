# Lowest Common Ancestor (LCA) of a Binary Tree

**Difficulty:** `Medium` | **Topics:** `Tree`, `Depth-First Search (DFS)`, `Recursion`

## Problem Statement

Given the root node of a tree, whose nodes have their values in the range of integers. You are given two nodes `x`, `y`
from the tree. You have to find the lowest common ancestor of these nodes.

The **lowest common ancestor** of two nodes `x`, `y` in a tree is defined as the lowest node that has both nodes `x` and
`y` as its descendants (where we allow a node to be a descendant of itself).

Your task is to complete the function `findLCA` which receives the root of the tree, `x`, and `y` as its parameters and
returns the LCA of these values.

*(Note: Assume all nodes have unique values, and both `x` and `y` will always exist in the tree).*

### Examples

* **Example 1:**
    * **Input:** `root = [1, 2, 3, 4, -1, 5, 6, -1, 7], x = 7, y = 5`
      ```text
            1
          /   \
        2      3
       /      / \
      4      5   6
       \
        7

- Output: `1`