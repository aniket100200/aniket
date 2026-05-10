# Children Sum in a Binary Tree

**Difficulty:** Medium  
**Accuracy:** 51.58%  
**Topics:** Tree, Binary Tree, Depth-First Search (DFS)

## Problem Description

Given the `root` of a binary tree, determine whether the tree satisfies the **Children Sum Property**.

In this property, each non-leaf node must have a value equal to the **sum** of its **left** and **right** children's
values.

* A `NULL` child is considered to have a value of `0`.
* All leaf nodes are considered valid by default.

Return `true` if every node in the tree satisfies this condition, otherwise return `false`.

---

## Examples

### Example 1:

**Input:** `root = [35, 20, 15, 15, 5, 10, 5]`  
**Output:** `true`  
**Explanation:**
Every non-leaf node is the sum of its left and right children:

* Root (35) = Left (20) + Right (15)
* Node (20) = Left (15) + Right (5)
* Node (15) = Left (10) + Right (5)
  The tree satisfies the condition.

### Example 2:

**Input:** `root = [1, 4, 3, 5]`  
**Output:** `false`  
**Explanation:**
The root node has a value of 1. Its children are 4 and 3.
Since 4 + 3 = 7, which is not equal to 1, this tree does not satisfy the given condition.

---

## Constraints

* `1 <= number of nodes <= 10^5`
* `0 <= node->data <= 10^5`

---