# Points to Remember

- to tackle `Integer Overflow` you can use long and based on condition you can return answer.

# Time Complexity O(1)

- total will be `O(1)`

# Space Complexity O(1)

- as we are not using any extra space that's why it is `O(1)`

# Solution

```java
class Solution {
    public int reverse(int x) {

        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;

        return (int) ans;
    }
}

```
