# Points to remember

- It will be solved using Stack
- When you encounter `d` keep pushing elements to the stack
- when you encounter `i` push the element and append it the answer
- at last append the answer

# Time Complexity O(1)

- as we are iterating once over the String of length 8 `O(8)`

# Space Complexity O(1)

- as we are we have to store at `max 8` Integers

# Solution

```java
class Solution {
    public String smallestNumber(String str) {
        // write code here
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (char ch : str.toCharArray()) {
            if (ch == 'd') {
                st.push(count++);
            } else {
                st.push(count++);
                // as soon as you got 'i' you can reverse the numbers and append it so reversing thing stack
                // will do
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }

        st.push(count);
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
}

```