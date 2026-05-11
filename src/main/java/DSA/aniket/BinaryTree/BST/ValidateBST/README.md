# Validate Binary Search Tree

**Difficulty:** Medium  
**Topics:** Tree, Depth-First Search, Binary Search Tree (BST), Binary Tree

## Problem Description

Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).

A **valid BST** is defined as follows:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right subtrees must also be binary search trees.

---

## Examples

### Example 1:

**Input:** `root = [2,1,3]`  
**Output:** `true`  
**Explanation:**

```text
    2
   / \
  1   3