# Recover Binary Search Tree

**Difficulty:** Hard  
**Topics:** Tree, Depth-First Search, Binary Search Tree (BST), Binary Tree

## Problem Description

You are given the `root` of a binary search tree (BST), where the values of **exactly two nodes** of the tree were
swapped by mistake.

Your task is to recover the tree by swapping these two values back without changing the structure of the tree.

**Note:** You are **not allowed to use extra space**. (An `O(1)` space solution is expected, implying techniques like
Morris Traversal, though `O(H)` recursion stack space is often accepted depending on the judge).

---

## Input / Output Format

**Input Format:**

* The first line contains an integer `n` denoting the number of inputs in the serialized array.
* The second line contains `n` space-separated integers denoting the **Preorder traversal** of the tree. A `-1`
  indicates a `null` node.

**Output Format:**

* For each non-null node in the recovered tree, print a line in the following format:
  `Node.left.val -> Node.val <- Node.right.val`
* If any child is `null`, print `.`.
  *(Note: The driver code handles the tree parsing and output generation. You just need to complete the recovery
  logic).*

---

## Examples

### Example 1

**Input:**

```text
9
4 2 3 -1 -1 -1 5 -1 -1
```