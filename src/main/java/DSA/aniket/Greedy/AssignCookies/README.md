# Assign Cookies

**Difficulty:** Easy  
**Topics:** Array, Two Pointers, Greedy, Sorting

## Problem Description

Assume you are an awesome parent and want to give your children some cookies. However, you should give each child at
most one cookie.

Each child $i$ has a greed factor $g[i]$, which is the minimum size of a cookie that the child will be content with.
Each cookie $j$ has a size $s[j]$. If $s[j] \ge g[i]$, we can assign the cookie $j$ to the child $i$, and the child $i$
will be content. Your goal is to maximize the number of your content children and output the maximum number.

## Input / Output Format

* **Input Parameters:** * An integer array `g` representing the greed factor of each child.
    * An integer array `s` representing the size of each cookie.
* **Output Format:** * An integer representing the maximum number of content children.
* **Important Notes:**
    * You cannot combine two small cookies to satisfy one child's large greed factor.
    * Each child can receive at most one cookie.

## Examples

### Example 1

**Input:**

```text
g = [1, 2, 3]
s = [1, 1]