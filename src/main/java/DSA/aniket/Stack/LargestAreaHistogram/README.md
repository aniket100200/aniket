# Points to Remember

- you can solve it using Stack.
- using Monotonic stack
- first find the next smaller element to right or left.
- then figure out the right boundry and left boundry
- and try to maximize the Aread
- you can calculate the `width=(rb-lb-1);` and height for peritcular index would have been given.

# Time Complexity O(N)

- as we are using single loop `O(N)`
- to calculate other things it will take at `O(N)`
- total will be `O(N)`

# Space Complexity O(N)

- in the stack there will be at most `N` elements.
- that's why it will be `O(N)`

# Solution

```java
class Solution {
    public static long maximumArea(long hist[], long n) {
        // If I'm able to find the next smaller elment to right and left
        // with height and width I can find the Area for perticular height in the histogram

        // let's do it using monotonic stack
        Stack<Integer> st = new Stack<>();
        // will look for the next smaller element in the right

        long ans = 0; // area never be negative

        for (int i = 0; i < hist.length; i++) {
            long ele = hist[i];
            // so in the stack elements will be there in asceding order increasing order
            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.pop();
                // for this index
                int rb = i;
                int lb = -1;
                if (st.size() > 0) lb = st.peek();

                int width = rb - lb - 1;
                long height = hist[idx];
                long area = (long) width * height;
                ans = Math.max(area, ans);
            }

            // I'll be looking for the smaller element for it'sself as well
            st.push(i);
        }

        // here means were not able to find the smaller elment
        // elment in the stack are sorted in asceding order from bottom to top.

        while (st.size() > 0) {
            int idx = st.pop();
            int rb = hist.length;
            int lb = -1;
            if (st.size() > 0) lb = st.peek();

            int width = rb - lb - 1;
            long height = hist[idx];
            long area = (long) width * height;
            ans = Math.max(area, ans);
        }

        return ans;
    }
}
```