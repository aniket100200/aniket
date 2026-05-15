# Car Pooling

**Difficulty:** Medium  
**Max Score:** 30  
**Topics:** Array, Prefix Sum, Sorting, Simulation

## Problem Description

There is a car with `k` empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer `capacity` and an array `trips` where `trips[i] = [numPassengers_i, from_i, to_i]` indicates
that the $i^{th}$ trip has `numPassengers_i` passengers and the locations to pick them up and drop them off are `from_i`
and `to_i` respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return `true` if it is possible to pick up and drop off all passengers for all the given trips, or `false` otherwise.

---

## Input / Output Format

**Input Format:**

* The first line of input contains an integer `n` which represents the number of trips.
* The next `n` lines contain 3 integers representing `numPassengers`, `from` (starting point), and `to` (ending point)
  respectively.
* The final line contains an integer `k` which represents the capacity of the car.

**Output Format:**

* Print `true` or `false` indicating whether it is possible to pick up and drop off all the passengers without exceeding
  the car's capacity at any point.

---

## Examples

### Example 1

**Input:**

```text
2
2 1 5
3 3 7
5