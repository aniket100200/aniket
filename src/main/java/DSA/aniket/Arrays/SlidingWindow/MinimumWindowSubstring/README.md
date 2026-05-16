# Minimum Window Substring

**Difficulty:** Hard  
**Topics:** String, Hash Table, Sliding Window

## Problem Description

Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window substring** of `s` such
that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the
empty string `""`.

The test cases will be generated such that the answer is **unique**.

A **substring** is a contiguous sequence of characters within the string.

---

## Input / Output Format

**Input Format:**

* The first line contains the string `s`.
* The second line contains the string `t`.

**Output Format:**

* Return a single string representing the minimum window substring. If no valid window exists, return an empty string
  `""`.

---

## Examples

### Example 1

**Input:**

```text
ADOBECODEBANC
ABC
```

**Output**

```text
BANC
```