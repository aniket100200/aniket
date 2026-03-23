# Points to remember

## Transformation Equations

- x₀′ = x₀ + y ---> (Eq1)
- x₁′ = x₁ + y ---> (Eq2)
- x₂′ = x₂ + y ---> (Eq3)

---

- You have to relate this equations
- Eq2 - Eq1
- x₁′-x₀′ = x₁-x₀

- Eq3-Eq2
- x₂′-x₁′ = x₂-x₁
- If you relate this equations.
- like `x₂-x₁#x₁-x₀` if you find this next time then there is relative differenc
- you can calculate the answer.

---

# Time Complexity O(N)

- as we are traversing over the array so Overall it will be `O(N)`

# Space Complexity O(N)

- as we are using Map to store the Keys so It'll take `O(N)`

# Solution

```java
class Solution {
    public int longestSubarray(int[] arr) {
        int n = arr.length;
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count0++;
            else if (arr[i] == 1) count1++;
            else count2++;

            String key = (count2 - count1) + "#" + (count1 - count0);
            if (map.containsKey(key)) {
                int dist = i - map.get(key);
                if (dist > ans) ans = dist;
            }

            if (!map.containsKey(key)) map.put(key, i);
        }

        return ans;
    }
}
```