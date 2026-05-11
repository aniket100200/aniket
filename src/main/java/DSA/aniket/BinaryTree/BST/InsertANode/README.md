# Insert a Node in a BST

**Difficulty:** Medium  
**Max Score:** 40  
**Companies:** Microsoft, Accolite, Amazon, PayTM, Samsung  
**Topics:** Trees, Binary Search Tree (BST)

## Problem Description

You are given the `root` node of a binary search tree (BST) and a value `key` to insert into the tree. Return the `root`
node of the BST after the insertion.

The tree is constructed by sequentially inserting the given nodes into an initially empty BST. After inserting the new
`key`, you must output the **Preorder traversal** of the updated tree.

**Notes:**

* There are no duplicate values present in the BST.
* It is guaranteed that the new value does not exist in the original BST.

---

## Examples

### Example 1

**Input:**

```text
6
2 81 87 90 42 41 
44
```

**Output**

```text
2 81 42 41 44 87 90
```