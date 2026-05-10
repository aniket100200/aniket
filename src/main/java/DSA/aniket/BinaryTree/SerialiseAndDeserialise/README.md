# Serialize and Deserialize Binary Tree

**Difficulty:** Hard  
**Topics:** Tree, Depth-First Search, Breadth-First Search, Design, String, Binary Tree

## Problem Description

Serialization is the process of translating a data structure or object state into a format that can be stored (for
example, in a file or memory buffer) or transmitted across a network connection link to be reconstructed later in the
same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a
string and this string can be deserialized to the original tree structure.

---

## Examples

### Example 1:

**Input:** `root = [1,2,3,null,null,4,5]`  
**Output:** `[1,2,3,null,null,4,5]`  
**Explanation:** The tree is serialized to a string, and when deserialized, it perfectly recreates the original tree
structure.

### Example 2:

**Input:** `root = []`  
**Output:** `[]`

---

## Constraints

* The number of nodes in the tree is in the range `[0, 10^4]`.
* `-1000 <= Node.val <= 1000`

---