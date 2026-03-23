# ⛽ Circular Tour (Gas Station Problem)

> An efficient algorithmic solution to find the perfect starting point for a circular truck route without running out of
> fuel.

![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-yellow)
![Topic: Greedy](https://img.shields.io/badge/Topic-Greedy-brightgreen)
![Topic: Arrays](https://img.shields.io/badge/Topic-Arrays-blue)

## 📝 Problem Statement

Suppose there is a circle containing `N` petrol pumps. You are given two sets of data:

1. The amount of petrol that every petrol pump has.
2. The distance from that petrol pump to the next petrol pump.

**Objective:** Find a starting point where the truck can complete the entire circle without exhausting its petrol in
between.

> **Note:** Assume for **1 litre** of petrol, the truck can travel **1 unit** of distance. Return `-1` if no solution
> exists.

---

## 📥 Input & Output Format

### Input

* **Line 1:** A single integer `N` denoting the number of petrol pumps.
* **Line 2:** `N` integers denoting the amount of petrol in each pump.
* **Line 3:** `N` integers denoting the distance from each pump to the next.

### Output

* Print the **index** (0-based) of the starting point.
* Print `-1` if no solution exists.

---

## 💡 Examples

### Example 1

**Input:**

```text
4
4 6 7 4
6 5 3 5
```

**Output:**

```text
1
```