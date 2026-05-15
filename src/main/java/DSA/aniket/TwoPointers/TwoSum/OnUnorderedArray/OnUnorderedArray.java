package DSA.aniket.TwoPointers.TwoSum.OnUnorderedArray;

import DSA.aniket.TwoPointers.TwoSum.TwoSum;

import java.util.HashMap;

public class OnUnorderedArray implements TwoSum {

    @Override
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int key = target - arr[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key) + 1, i + 1};
            }

            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}