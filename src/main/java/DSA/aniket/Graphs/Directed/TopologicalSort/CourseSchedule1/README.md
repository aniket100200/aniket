# Course Schedule I

**Difficulty:** Medium  
**Topics:** Graph, Breadth-First Search (Kahn's Algorithm), Depth-First Search, Topological Sort

## Problem Description

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array
`prerequisites` where `prerequisites[i] = [a_i, b_i]` indicates that you **must** take course `b_i` first if you want to
take course `a_i`.

For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

---

## Input / Output Format

**Input Format:**

* An integer `numCourses` representing the total number of courses.
* A 2D integer array `prerequisites` representing the directed edges.

**Output Format:**

* Return a boolean: `true` if all courses can be finished, `false` otherwise.

---

## Examples

### Example 1

**Input:**

```text
numCourses = 2, prerequisites = [[1, 0]]
```

**Output**

```text
true
```
