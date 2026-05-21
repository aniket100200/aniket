# Bipartite Graph

**Difficulty:** Medium  
**Topics:** Graph, Breadth-First Search, Depth-First Search

## Problem Description

Given an adjacency list `adj` representing an undirected graph with `V` vertices, return `true` if the graph is *
*Bipartite**, and `false` otherwise.

A graph is bipartite if the nodes can be partitioned into two independent sets $A$ and $B$ such that every edge in the
graph connects a node in set $A$ and a node in set $B$.

Equivalently, a bipartite graph is a graph that can be colored with exactly two colors such that no two adjacent
vertices share the same color. (A graph with an odd-length cycle can *never* be bipartite).

---

## Input / Output Format

**Input Format:**

* An integer `V` representing the number of vertices.
* An array of lists `adj` representing the adjacency list of the undirected graph.

**Output Format:**

* Return a boolean: `true` if the graph is bipartite, `false` otherwise.

---

## Examples

### Example 1

**Input:**

```text
V = 4
adj = [[1, 3], [0, 2], [1, 3], [0, 2]]
```

**Output**

```text
true
```

#### Points To remember

- Every Linear Graph with No Cycle is Always Bipartite
- and A Graph with a Even cycle length is Also Bipartite.
- Any Graph with Odd cycle length is Non-Bipartite.