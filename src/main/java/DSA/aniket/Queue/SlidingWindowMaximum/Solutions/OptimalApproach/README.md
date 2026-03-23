# Points to remember

- It will be solved using Deque to Solve.
- as we are using the power of `Monotonic Stack` our Maximum element in window will be
- bottom most in the stack for a window.
- there will `n-k+1`windows
- Use Deque as Stack with operation `getLast()` to Peek and `addLast()` to push and `removeLast()` to mimic `pop()`
  operation.
- to get lastElement of the Stack we can use the `getFirst()` method of the `Deque<Integer>`

# Time Complexity O(N)

- as we are traversing over the array once
- so overall time complexity will be `O(N)`

# Space Complexity O(N)

- as we are using Auxilary space to store the answer and there will at most `N`elements in the stack
- so it will be `O(N)` only

# Solution

```java
class Solution {
    public int[] SlidingWindowMaximum(int n, int k, int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>(); // I'm using it like a stack
        // as we are calculating the next greater element withing the window.
        // my window size will K
        // we are using the power of monotonic Stack
        // we are using Deque as stack with addLast() and RemoveLast() operations
        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // I'll have to remove the scrap
            while (dq.size() > 0 && i - dq.getFirst() >= k) dq.removeFirst();
            // as we are looking for next greater element in the stack
            int ele = nums[i];
            while (dq.size() > 0 && ele > nums[dq.getLast()])
                dq.removeLast(); // as they are smaller than me means they are useless
            dq.addLast(i);
            // now when to start calculating answers..
            if (i >= k - 1) {
                ans[idx++] = nums[dq.getFirst()];
            }
        }

        return ans;
    }
}

```