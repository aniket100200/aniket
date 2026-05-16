# Minimum Length of String After Deleting Similar Ends

**Difficulty:** Medium  
**Topics:** Two Pointers, String

## Problem Description

Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`. You are asked to apply the following algorithm
on the string any number of times:

1. Pick a non-empty prefix from the string `s` where all the characters in the prefix are equal.
2. Pick a non-empty suffix from the string `s` where all the characters in this suffix are equal.
3. The prefix and the suffix should not intersect at any index.
4. The characters from the prefix and suffix must be the same.
5. Delete both the prefix and the suffix.

Your task is to return the **minimum length** of `s` after performing the above operation any number of times (possibly
zero times).

---

## Input / Output Format

**Input Format:**

* The first line consists of a single string `s`.

**Output Format:**

* Return the minimum integer value representing the length of `s` after performing the operations.

---

## Examples

### Example 1

**Input:**

```text
ca
```

**Output**

```text
2
```