package DSA.aniket.BinarySearch.onAnswers.FindTheSmallestDivisor;

public interface FindTheSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold);

    default boolean isPossible(int divisor, int[] nums, int threshold) {
        long total = 0;
        for (int val : nums) {
            total += Math.ceilDiv(val, divisor);
            if (total > threshold) return false;
        }

        return total <= threshold;
    }
}