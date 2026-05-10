# Construct Binary Tree from Preorder and Inorder Traversal

**Difficulty:** Medium  
**Topics:** Array, Hash Table, Divide and Conquer, Tree, Binary Tree

## Problem Description

Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and
`inorder` is the inorder traversal of the same tree, construct and return *the binary tree*.

---

## Examples

### Example 1:

**Input:** `preorder = [3,9,20,15,7]`, `inorder = [9,3,15,20,7]`  
**Output:** `[3,9,20,null,null,15,7]` *(Level-order representation)*  
**Explanation:**
The reconstructed tree has 3 as the root.
Its left child is 9.
Its right child is 20 (with left child 15 and right child 7).

### Example 2:

**Input:** `preorder = [-1]`, `inorder = [-1]`  
**Output:** `[-1]`

---

## Constraints

* `1 <= preorder.length <= 3000`
* `inorder.length == preorder.length`
* `-3000 <= preorder[i], inorder[i] <= 3000`
* `preorder` and `inorder` consist of **unique** values.
* Each value of `inorder` also appears in `preorder`.
* `preorder` is **guaranteed** to be the preorder traversal of the tree.
* `inorder` is **guaranteed** to be the inorder traversal of the tree.

---

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution