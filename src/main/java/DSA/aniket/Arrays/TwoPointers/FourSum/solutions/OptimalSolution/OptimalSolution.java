package DSA.aniket.Arrays.TwoPointers.FourSum.solutions.OptimalSolution;

import DSA.aniket.Arrays.TwoPointers.FourSum.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalSolution implements FourSum {

    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * we'll use the Power of Two Sum
         */
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long tar1 = target - nums[i];
            for (int j = i + 1; j < n; j++) {
                long tar2 = tar1 - nums[j];
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long currTotal = nums[left] * 1L + nums[right] * 1L;
                    if (currTotal == tar2) {
                        ans.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        int prev = nums[left];
                        while (left < n && prev == nums[left]) left++;
                        prev = nums[right];
                        while (right >= 0 && prev == nums[right]) right--;
                    } else if (currTotal > tar2) {
                        int prev = nums[right];
                        while (right >= 0 && nums[right] == prev) right--;
                    } else {
                        int prev = nums[left];
                        while (left < n && nums[left] == prev) left++;
                    }
                }

                while (j + 1 < n && nums[j] == nums[j + 1]) j++;

            }

            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        }

        return ans;
    }
}