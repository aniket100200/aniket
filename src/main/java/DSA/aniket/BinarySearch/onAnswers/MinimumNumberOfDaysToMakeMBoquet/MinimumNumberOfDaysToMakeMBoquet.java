package DSA.aniket.BinarySearch.onAnswers.MinimumNumberOfDaysToMakeMBoquet;

public interface MinimumNumberOfDaysToMakeMBoquet {
    int minDays(int[] bloomDay, int m, int k);

    default boolean isPossible(int minDays, int[] bloomDay, int m, int k) {
        int bouquetCount = 0;
        int currentCountOfFlowers = 0;
        for (int flower : bloomDay) {
            if (flower <= minDays) {
                currentCountOfFlowers++;
            } else {
                bouquetCount += currentCountOfFlowers / k;
                currentCountOfFlowers = 0;
            }
        }

        bouquetCount += currentCountOfFlowers / k;

        return bouquetCount >= m;
    }


}