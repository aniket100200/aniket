# Construct BST From Preorder Traversal

**Difficulty:** Medium  
**Max Score:** 40  
**Companies:** Flipkart, Amazon, LinkedIn  
**Topics:** Tree, Binary Search Tree (BST), Recursion, Stack

## Problem Description

You are given an array `preOrder` consisting of the Preorder Traversal of a valid Binary Search Tree. Your task is to
create the unique Binary Search Tree and return the head (root) node of the tree.

A **Binary Search Tree** is a binary tree where for every node:

* Any descendant of `Node.left` has a value strictly less than `Node.val`.
* Any descendant of `Node.right` has a value strictly greater than `Node.val`.

*Note: You just need to complete the `createTree` function and return the head node of the generated tree. The driver
code handles the printing in the specified output format.*

---

## Input / Output Format

**Input Format:**

* First line contains an integer `n` denoting the number of nodes in the BST.
* Second line contains `n` space-separated integers denoting the Preorder traversal of the tree.

**Output Format:**

* For each node in the array, the driver code prints a line in the following format:
  `Node.left.val->Node.val<-Node.right.val`
* If any node is `null`, it prints `.`

---

## Examples

### Example 1

**Input:**

```text
6
3 2 1 6 5 7
```

---

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution