package DSA.aniket.TwoPointers.FourSum.solutions.BrutzForce;

import DSA.aniket.TwoPointers.FourSum.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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