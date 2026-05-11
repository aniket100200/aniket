# Delete Node in a BST

**Difficulty:** Medium  
**Topics:** Tree, Binary Search Tree (BST), Recursion

## Problem Description

Given a root node reference of a BST and a key, delete the node with the given `key` in the BST. Return the **root node
reference** (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1. Search for a node to remove.
2. If the node is found, delete the node.

When deleting a node, there are **three possible situations** to handle:

1. **Node is a leaf:** Simply remove it from the tree.
2. **Node has one child:** Replace the node with its child.
3. **Node has two children:** Find the inorder successor (the smallest node in the right subtree) or the inorder
   predecessor (the largest node in the left subtree), replace the node's value with it, and delete the
   successor/predecessor node.

---

## Examples

### Example 1:

**Input:** `root = [5,3,6,2,4,null,7]`, `key = 3`  
**Output:** `[5,4,6,2,null,null,7]`  
**Explanation:**
Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is `[5,4,6,2,null,null,7]` (using inorder predecessor). Another valid answer is
`[5,2,6,null,4,null,7]` (using inorder successor).
Both configurations represent valid Binary Search Trees after removing `3`.

### Example 2:

**Input:** `root = [5,3,6,2,4,null,7]`, `key = 0`  
**Output:** `[5,3,6,2,4,null,7]`  
**Explanation:** The tree does not contain a node with value = 0, so the tree is returned unchanged.

### Example 3:

**Input:** `root = []`, `key = 0`  
**Output:** `[]`

---

## Constraints

* The number of nodes in the tree is in the range `[0, 10^4]`.
* `-10^5 <= Node.val <= 10^5`
* Each node has a **unique** value.
* `root` is a valid binary search tree.
* `-10^5 <= key <= 10^5`