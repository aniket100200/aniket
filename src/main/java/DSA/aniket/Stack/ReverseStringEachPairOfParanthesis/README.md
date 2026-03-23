# Points to remember

- It will be solved using Stack to reverse the string between two paranthesis
- just push the chars to the Stack and if you encounter `)` then reverse the string you can use `Queue`
- and use String Builder to Build the Answer after iterating over the `Stack`

# Time Complexity O(N)

- as we are iterating over the `String` time complexity will depend on `length of the String`.

# Space Complexity O(N)

- as we are Using `Stack` at `Max` there will be all the `characters of the String`.

# Solution

```java
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        // your code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                Queue<Character> que = new ArrayDeque<>();
                while (!st.isEmpty() && st.peek() != '(') {
                    que.add(st.pop());
                }
                st.pop();

                while (que.size() > 0) st.push(que.poll());

            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) sb.append(ch);

        return sb.toString();
    }
}
```