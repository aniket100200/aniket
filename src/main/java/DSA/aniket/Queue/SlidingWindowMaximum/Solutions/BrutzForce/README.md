# Points to remember

- It will be solved using Two Loops
- one loop runs n-k times and other loop runs K times
- there will be `N-K+1` subbarrays of Size `K`

# Time Complexity O(N*K)

- as we are running first loop for N-K+1
- and other loop for K times
- Overall Time Complexity will be `O(N*K)`

# Space Complexity O(N)

- as we are using array of size of `N-K+1`
- which will be N in worst case so it will be `O(N)`

# Solution

```java
class Solution {
    public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
        // generate all the subarrays of Size k
        // there will n-k+1;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }

        return ans;
    }
}
```