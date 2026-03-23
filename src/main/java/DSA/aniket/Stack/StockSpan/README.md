# Points to remember

- You can solve it using `Previous Smallest Element`

# Time Complexity O(N)

- as we are using two separate loops it is `O(N)+O(N)=2*O(N)`
- Overall it is `O(N)`

# Space Complexity O(N)

- as we are using `Stack<Integer> st` at max there will be `N` number of elements in the stack.

```java
class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    static int[] stockSpan(int[] a) {
        int n = a.length;
        // find the previous greater value for the current stock
        int[] prevGreater = previousGreaterElement(a, n);

        int[] ans = new int[a.length];

        for (int i = 0; i < n; i++) {
            // if you have 3 elemnets like
            // 100 80 90
            // 0   1  2
            // 1   1(1-0)  2(2-0)
            ans[i] = i - prevGreater[i];
        }

        return ans;
    }

    static int[] previousGreaterElement(int[] a, int n) {
        int[] ans = new int[n];

        Stack<Pair> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int ele = a[i];
            while (st.size() > 0 && ele > st.peek().val) {
                Pair p = st.pop();
                int idx = p.idx;
                ans[idx] = i;
            }

            // I'll also look for my nextGreater element
            st.push(new Pair(a[i], i));
        }

        // If I don't get any then
        while (st.size() > 0) {
            // those are the greatest
            Pair p = st.pop();
            ans[p.idx] = -1;
        }

        return ans;
    }
}
```