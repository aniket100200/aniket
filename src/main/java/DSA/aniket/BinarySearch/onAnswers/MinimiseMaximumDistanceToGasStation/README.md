# Minimize Max Distance to Gas Station

**Difficulty:** Hard  
**Topics:** Binary Search (Floating-Point), Greedy Algorithm, Array

## Problem Statement

We have a horizontal number line with gas stations at positions `stations[0], stations[1], ..., stations[n-1]`.

Now, we add `k` more gas stations so that `d`, the maximum distance between adjacent gas stations, is minimized. We have
to find the smallest possible value of `d`.

Find the answer exactly to **6 decimal places**.
*Note: `stations` is provided in a strictly increasing order.*

## Examples

**Example 1:**
> **Input:** `stations[] = [1, 2, 3, 4, 5]`, `k = 2`  
> **Output:** `1.000000`  
> **Explanation:** Since all gaps are already equal (1 unit each), adding extra stations in between does not reduce the
> maximum distance.

**Example 2:**
> **Input:** `stations[] = [3, 6, 12, 19, 33]`, `k = 3`  
> **Output:** `6.000000`  
> **Explanation:** The largest gap is 14 (between 19 and 33). Adding 2 stations splits it into ~4.67. The next largest
> gap is 7 (between 12 and 19). Adding 1 station splits it into 3.5. Now the maximum gap left is 6 (between 6 and 12).

## Constraints

* `1 <= stations.size() <= 10^5`
* `0 <= stations[i] <= 10^6`
* `0 <= k <= 10^5`