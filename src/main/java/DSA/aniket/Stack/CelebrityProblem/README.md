# Points to remember

- It will be solved using `Stack`
- First add all elements to the stack and try to eleminate each other
- at last there will one element.
- check for last element `everyone should knows him and he should not know anyone`

# Time Complexity O(N)

- as we are traversing the N elements only
- horizontall and digonally N
- Overall TC will `O(N)`

# Space Complexity O(N)

- as we are Stack ONLY

# Solution

```java

class Solution {
    int findCelebrity(int M[][], int n) {
        // compare between two two only you'll left with the one person at last who
        // is potential celebrity
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            // let's check
            if (M[a][b] == 1) {
                // this means a knows b means a is not celebrity
                st.push(b);
            } else {
                // as don't know b so b is not celebrity
                st.push(a);
            }
        }

        // you'll only left with one element let's check if everyone knows him
        // and he don't know anyone.

        int pc = st.pop();

        // let's check if he don't know anyone
        for (int i = 0; i < n; i++) {
            if (pc == i) continue;
            if (M[pc][i] == 1) return -1;
            if (M[i][pc] == 0) return -1;
        }

        return pc;
    }
}

```