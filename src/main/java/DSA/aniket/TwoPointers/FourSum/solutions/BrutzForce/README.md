# Points to remember

- It will be solved using Four Loops
- You have to sort it first then you can eliminate the duplicates.

# Time Complexity O(N4)

- as we are

# Space Complexity O(N)

- as we are as we'll be storing N elements in different cofigurations at most.

# Solution

```java
public class BrutzForce implements FourSum {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (1L * nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        }
                        while (l + 1 < n && nums[l + 1] == nums[l]) l++;
                    }
                    while (k + 1 < n && nums[k + 1] == nums[k]) k++;
                }
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return ans;
    }
}
```