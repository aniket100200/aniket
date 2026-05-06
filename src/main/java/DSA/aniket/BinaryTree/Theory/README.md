# Binary Tree Terminologies and Types

![Binary Tree Example](img.png)

---

## Terminologies of a Binary Tree

### Root Node

- The root is the topmost node in the tree and does not have a parent.

### Child Node

- A node that descends from another node (its parent) is known as a child node.

### Leaf Node

- A node that does not have any children is called a leaf node.

### Subtree

- A subtree is a portion of a tree that consists of a specific node and all of its descendants.

### Sibling Nodes

- Nodes that share the exact same parent are known as siblings.

### Degree

- The number of children a specific node has is known as its degree.
- In a binary tree, the degree of a node can only be `0`, `1`, or `2`.

### Height of a Binary Tree

- The distance between the root node and the deepest leaf node, measured in the number of edges, is known as the height
  of the binary tree.

---

## Types of Binary Trees

### Perfect Binary Tree

- A binary tree where all interior nodes have two children and all leaf nodes are at the same level.
- Every level is completely filled. The number of nodes at any level `h` is strictly `2^h`.
- ![Perfect Binary Tree](img_2.png)

### Full Binary Tree

- A binary tree where every node has either zero or exactly two child nodes. No node has only one child.
- ![Full Binary Tree](img_3.png)

### Complete Binary Tree

- A binary tree where every level is completely filled, except possibly the very last level.
- All nodes in the last level are pushed as far left as possible.
- ![Complete Binary Tree](img_4.png)

### Balanced Binary Tree

- A binary tree where, for every single node, the height difference between its left subtree and its right subtree is
  not more than 1.
- Formula: `|h1 - h2| <= 1`
    - `h1` = height of the left subtree
    - `h2` = height of the right subtree
- ![Balanced Binary Tree](img_5.png)

### Skewed Tree

- A tree where every node has only one child.
- If all nodes only have left children, it is a **Left-Skewed Tree**. If all nodes only have right children, it is a *
  *Right-Skewed Tree**.
- ![Skewed Tree](img_6.png)