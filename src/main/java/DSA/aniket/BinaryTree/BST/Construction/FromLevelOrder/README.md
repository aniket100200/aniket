# Construct BST from Level Order Traversal

**Difficulty:** Medium  
**Topics:** Tree, Binary Search Tree (BST), Queue, Breadth-First Search (BFS)

## Problem Description

Given an array of integers representing the **Level Order Traversal** of a Binary Search Tree (BST), construct the BST
and return its root node.

A **Binary Search Tree** is a binary tree where for every node:

* Any descendant of `Node.left` has a value strictly less than `Node.val`.
* Any descendant of `Node.right` has a value strictly greater than `Node.val`.

*Note: The array contains unique values and represents a valid level order traversal of a BST.*

---

## Examples

### Example 1

**Input:** `arr = [7, 4, 12, 3, 6, 8, 1, 5, 10]`  
**Output:** `[7, 4, 12, 3, 6, 8, null, 1, null, 5, null, null, 10]` *(Tree structure)*  
**Explanation:**
The Binary Search Tree constructed from the level order traversal is:

```text
            7
          /   \
         4     12
        / \   / 
       3   6 8   
      /   /   \
     1   5    10
     
```

---

# Points to remember

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution