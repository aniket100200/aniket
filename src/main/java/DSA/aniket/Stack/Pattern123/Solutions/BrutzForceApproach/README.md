# Points to remember

- It will be solved using three nested loops
- generate all the subsequences of Size 3
- and compare with each other

# Time Complexity O(N3)

- as we are using three nested loops

# Space Complexity O(1)

- as we are not using any exgtra space.

# Solution

```java
class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        // will generate subsequences
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j] && nums[i] < nums[k]) return true;
                }
            }
        }

        return false;
    }
}

```