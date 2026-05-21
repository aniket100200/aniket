# Find Eventual Safe States

**Difficulty:** Medium  
**Topics:** Graph, Depth-First Search, Breadth-First Search, Topological Sort

## Problem Description

A directed graph of `V` vertices and `E` edges is given in the form of an adjacency list `adj`. Each node of the graph
is labeled from `0` to `V - 1`.

A node is a **terminal node** if there are no outgoing edges. A node is a **safe node** if every possible path starting
from that node leads to a terminal node (or another safe node). In simple terms, a node is safe if no path from it leads
to a cycle.

Return a list containing all the **safe nodes** of the graph. The answer should be sorted in **ascending order**.

---

## Input / Output Format

**Input Format:**

* An integer `V` representing the number of vertices.
* A list of lists `adj` representing the adjacency list of the directed graph.

**Output Format:**

* Return a list of integers containing the safe nodes in sorted ascending order.

---

## Examples

### Example 1

**Input:**

```text
V = 7
adj = [[1, 2], [2, 3], [5], [0], [5], [], []]
```

**Output**

```text
[2, 4, 5, 6]
```