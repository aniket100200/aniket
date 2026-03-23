# 🪟 Sliding Window Maximum

> Find the maximum value in a sliding window of size `k` as it moves from left to right across an array.

![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red)
![Topic: Sliding Window](https://img.shields.io/badge/Topic-Sliding%20Window-blue)
![Topic: Deque](https://img.shields.io/badge/Topic-Deque-purple)
![Topic: Arrays](https://img.shields.io/badge/Topic-Arrays-brightgreen)

## 📝 Problem Statement

You are given an array of integers `nums`. There is a sliding window of size `k` which is moving from the very left of
the array to the very right. You can only see the `k` numbers currently in the window. Each time, the sliding window
moves right by exactly one position.

**Objective:** Return an array containing the maximum value of each sliding window.

> **Note:** You only need to complete the given function `SlidingWindowMaximum` which receives the input array, `n` (
> size of array), and `k` (window size) as parameters.

---

## 📥 Input & Output Format

### Input

* **Line 1:** Two space-separated integers `N` and `K`, denoting the number of elements and the window size.
* **Line 2:** `N` space-separated integers denoting the elements of the array.

### Output

* An array (or printed space-separated list) of the maximum values from each window.

---

## 💡 Examples

### Example 1

**Input:**

```text
1 1
1
```

**Output**

```
1
```

## Example 2

### Input

```
8 3
1 3 -1 -3 5 3 6 7
```

### Output

```text
3 3 5 5 6 7
```

### Explanation

Given an array of size `8` and a window size `3`, we slide the window across the array and take the maximum value in
each window.

| Window      | Maximum |
|-------------|---------|
| [1, 3, -1]  | 3       |
| [3, -1, -3] | 3       |
| [-1, -3, 5] | 5       |
| [-3, 5, 3]  | 5       |
| [5, 3, 6]   | 6       |
| [3, 6, 7]   | 7       |

### Final Output

```text
3 3 5 5 6 7
```

[Brutz Force Approach](../SlidingWindowMaximum/Solutions/BrutzForce/README.md)<br/>
[Better Approach](../SlidingWindowMaximum/Solutions/BetterApproach/README.md)<br/>
[Optimal Approach](../SlidingWindowMaximum/Solutions/OptimalApproach/README.md)


