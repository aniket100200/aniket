# Number of Valid Triangles

**Difficulty:** Medium  
**Topics:** Array, Two Pointers, Sorting, Greedy

## Problem Description

You are given an array `arr` of length `n`. Print the number of triplets chosen from the array that can make triangles
if we take them as the side lengths of a triangle.

**Triangle Inequality Theorem:**
Three side lengths $a, b,$ and $c$ can form a valid triangle if and only if the sum of any two sides is strictly greater
than the third side:

* $a + b > c$
* $a + c > b$
* $b + c > a$

*(Hint: If you sort the array so that $a \le b \le c$, you only need to verify that $a + b > c$.)*

---

## Input / Output Format

**Input Format:**

* The first line contains an integer `n`, representing the length of the array.
* The second line contains `n` space-separated integers representing the elements of the array `arr`.

**Output Format:**

* Print a single integer representing the number of valid triplets that can form a triangle.

---

## Examples

### Example 1

**Input:**

```text
4
2 2 3 4