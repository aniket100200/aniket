# Points to remember

- It will be solved using Using Next greater element to right.
- You can use stack for the same
- after finding that you have to calculate the answer and `noOfSlidingWindowsOfSizeK=n-k+1`
- iterate over the array gain till the `size of Answer`
- and try to find the max withing the window `using ngeri`

# Time Complexity O(N)

- as we are calculating ngeri it take `O(N)` time and after
- we are iterating over the loop so it will be also `O(N)`
- So overall will be `O(N)` only.
-

# Space Complexity O(N)

- as we are using Stack and at max there will `N` elements in the stack.
- so it'll be `O(N)`

# Solution

```java
class Solution {


    public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
        // there will n-k+1 subarrays..
        int[] ans = new int[n - k + 1];
        // we'll use Stack approach
        // we'll calculate the ngeri element
        int[] ngeri = nextGreaterElement(nums, n);
        // as there will be total n-k+1 windows
        int j = 0;
        for (int i = 0; i < ans.length; i++) {
            if (j < i) j = i;
            while (ngeri[j] < i + k) j = ngeri[j];

            ans[i] = nums[j];
        }

        return ans;
    }

    public int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            while (st.size() > 0 && ele > arr[st.peek()]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }

        while (st.size() > 0) {
            ans[st.pop()] = n;
        }

        return ans;
    }
}

```