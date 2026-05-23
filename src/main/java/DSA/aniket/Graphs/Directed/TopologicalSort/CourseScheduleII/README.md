# Course Schedule II

**Difficulty:** Medium  
**Topics:** Graph, Breadth-First Search (Kahn's Algorithm), Depth-First Search, Topological Sort

## Problem Description

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array
`prerequisites` where `prerequisites[i] = [a_i, b_i]` indicates that you **must** take course `b_i` first if you want to
take course `a_i`.

For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return **any** of
them. If it is impossible to finish all courses (due to a cycle), return an **empty array**.

---

## Input / Output Format

**Input Format:**

* An integer `numCourses` representing the total number of courses.
* A 2D integer array `prerequisites` representing the directed edges.

**Output Format:**

* Return an array of integers representing a valid course completion order. If impossible, return an empty array `[]`.

---

## Examples

### Example 1

**Input:**

```text
numCourses = 2, prerequisites = [[1, 0]]
```

**Output**

```text
[0, 1]
```