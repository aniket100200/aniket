# Lowest Common Ancestor of a Binary Search Tree

**Difficulty:** Medium  
**Topics:** Tree, Depth-First Search, Binary Search Tree (BST), Binary Tree

## Problem Description

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes `p` and `q` as
the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself)."

---

## Examples

### Example 1:

**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 8`  
**Output:** `6`  
**Explanation:** The LCA of nodes 2 and 8 is 6.

### Example 2:

**Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 4`  
**Output:** `2`  
**Explanation:** The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA
definition.

### Example 3:

**Input:** `root = [2,1]`, `p = 2`, `q = 1`  
**Output:** `2`

---

## Constraints

* The number of nodes in the tree is in the range `[2, 10^5]`.
* `-10^9 <= Node.val <= 10^9`
* All `Node.val` are **unique**.
* `p != q`
* `p` and `q` will exist in the BST.

---

## Test Cases

Here are standard and edge-case test cases to validate your solution:

**Test Case 1: Standard LCA (Example 1)**

* **Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 8`
* **Expected:** Node with value `6`.

**Test Case 2: LCA is one of the nodes (Example 2)**

* **Input:** `root = [6,2,8,0,4,7,9,null,null,3,5]`, `p = 2`, `q = 4`
* **Expected:** Node with value `2`.

**Test Case 3: Two nodes only (Example 3)**

* **Input:** `root = [2,1]`, `p = 2`, `q = 1`
* **Expected:** Node with value `2`.

**Test Case 4: Left-skewed tree**

* **Input:** `root = [4, 3, 2, 1]`, `p = 1`, `q = 3`
* **Expected:** Node with value `3`.

**Test Case 5: Deep common ancestor**

* **Input:** `root = [10, 5, 15, 3, 7, null, null, null, null, 6, 8]`, `p = 6`, `q = 8`
* **Expected:** Node with value `7`.