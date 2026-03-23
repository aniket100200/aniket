# Points to remember

- It will be solved using Stack
- you can use monotonic stack approach to solve it.
- finding next minimum on both right and left side.
- then calculate the number of subarrays where that particular element is minimum.
    - formula be like # `noOfSubArrays=(idx-lb)*(rb-idx)`.

# Time Complexity O(N)

- as we are doing it in single go

# Space Complexity O(N)

- as we are using `Stack<Integer> st` at max there will be `N` number of elements in the stack.

# Solution

```java
class Solution {
    final long mod = 1000000007;

    public long minSubarraySum(int n, int a[]) {
        // write code here
        // let's use the monotonic stack

        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // I've to find the next smaller element to left and right
            // to calculate noOfSubarray where that perticular element is minimum
            // noOfSubarraysWhereElementAtIdxWill be mininmum is = (idx-lb)*(rb-idx);

            int ele = a[i];
            while (st.size() > 0 && ele < a[st.peek()]) {
                // got the right boundry
                int idx = st.pop();
                int rb = i;
                int lb = -1;
                if (st.size() > 0) lb = st.peek();

                int noOfSubarray = (idx - lb) * (rb - idx);
                ans = (ans % mod + (noOfSubarray % mod * a[idx] % mod) % mod) % mod;
            }

            // current element will also looks for next smaller element
            st.push(i);
        }

        // there will be some elements who didn't found their next smallest element so for them
        // rb will n
        while (st.size() > 0) {
            int idx = st.pop();
            int rb = n;
            int lb = -1;
            if (st.size() > 0) lb = st.peek();

            int noOfSubArrays = (idx - lb) * (rb - idx);
            ans = (ans % mod + (noOfSubArrays % mod * a[idx] % mod) % mod) % mod;
        }

        return ans % mod;
    }
}
```