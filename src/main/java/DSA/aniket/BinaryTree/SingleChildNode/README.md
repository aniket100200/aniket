# Single Child Nodes

**Difficulty:** `Easy` | **Topics:** `Tree`, `Depth-First Search`, `Preorder Traversal`

## Problem Statement

Given a binary tree, traverse the tree using a preorder traversal and collect all the nodes that are the **only child**
of their parent.

*Note: The problem description mentions printing nodes that "have only one child", but the examples clarify that the
target output is the **child nodes themselves** whose parent has exactly one child.*

### Examples

* **Example 1:**
    * **Tree:**
    * ```text
      50
      25              75
      12      37      62      87
      30           70
      ```
    * **Output:** `[30, 70]`
    * **Explanation:** Only 30 and 70 have parents (37 and 62, respectively) who have exactly 1 child.

* **Example 2:**
    * **Tree:**
      ```text
                  50
          25              75
      12                62      87
                      30
      ```
    * **Output:** `[12, 30]`
    * **Explanation:** Only 12 and 30 have parents (25 and 62, respectively) who have exactly 1 child.

---

## 🚀 Optimal Approach: Preorder Traversal (DFS)

We can solve this efficiently using a standard Depth-First Search (DFS) in a preorder fashion (Root -> Left -> Right).

### Algorithm

1. Create a helper function that takes the current `node` and a `result` list.
2. **Base Case:** If the `node` is null, return.
3. **Logic:** * If the current node has a left child but no right child, add the left child's value to the result.
    * If the current node has a right child but no left child, add the right child's value to the result.
4. **Recurse:** Call the helper function on the `node.left` and then `node.right`.
5. Return the accumulated list.

### Complexity Analysis

* **Time Complexity:** $O(N)$ where $N$ is the number of nodes in the tree. We visit every node exactly once.
* **Space Complexity:** $O(H)$ where $H$ is the height of the tree, representing the call stack memory used during
  recursion. In the worst-case (a skewed tree), this is $O(N)$.