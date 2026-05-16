package DSA.aniket.Arrays.RangeQueries.PrefixSum.MakeSumDivisibleByP.Solution;

import DSA.aniket.Arrays.RangeQueries.PrefixSum.MakeSumDivisibleByP.MakeSumDivisibleByP;

import java.util.HashMap;
import java.util.Map;

public class Solution implements MakeSumDivisibleByP {

    @Override
    public int minSubarray(int[] arr, int p) {
        long total = 0;
        for (int i : arr) {
            total = (total + i * 1L) % p;
        }

        int remainder = (int) total % p;
        if (remainder == 0) return 0;

        //key -> remainder value -> index
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0 * 1L, -1);
        int min = arr.length;
        total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = (total + arr[i] * 1L) % p;
            long key = total - remainder;
            if (remainderIndexMap.containsKey(key)) {
                min = Math.min(min, i - remainderIndexMap.get(key));
            }
            key = key + p;
            if (remainderIndexMap.containsKey(key)) {
                min = Math.min(min, i - remainderIndexMap.get(key));
            }
            remainderIndexMap.put(total, i);


        }

        return min == arr.length ? -1 : min;
    }

}