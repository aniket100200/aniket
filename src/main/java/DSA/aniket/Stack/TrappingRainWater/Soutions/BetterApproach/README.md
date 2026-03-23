# Points to remember

- It will be solved using Stack to solve.
- User the Power of Monotonic Stack.
- while finding the nextGreater element to right you can calculate the water area in unite
  it can store so
- `ele >= height[st.peek()` you should handle it for the same. as you are storing the water above it.
-

# Time Complexity O(N)

- as we are using Monotonic Stack so we'll be traversion each element once.
- So Overall TC `O(N)`

# Space Complexity O(N)

- as we are Storing index indices of the array so at max in worst-case we'll have `N` elements in the Stack.
- so that's why it'll be `O(N)`

# Solution

```java
class Solution {
    public int trap(int[] height) {
        // will be using power of monotonic stack
        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int total = 0;

        // we are finding the element next greater element to right index wise
        // stack will be sorted in descending order
        for (int i = 0; i < n; i++) {
            int ele = height[i];
            while (st.size() > 0 && ele >= height[st.peek()]) {
                int rightBoundary = ele;
                int heightOfTheColumn = height[st.pop()];

                if (st.size() > 0) {
                    int leftBoundary = height[st.peek()];
                    int width = i - st.peek() - 1;
                    int minColumn = Math.min(leftBoundary, rightBoundary);

                    int waterAboveMe = minColumn - heightOfTheColumn;
                    total += (width * waterAboveMe);
                }
            }

            st.push(i);
        }

        return total;
    }
}
```