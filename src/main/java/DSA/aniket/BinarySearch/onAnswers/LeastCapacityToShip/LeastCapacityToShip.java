package DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip;

public interface LeastCapacityToShip {
    int shipWithinDays(int[] weights, int days);

    default boolean isPossible(int maxWeight, int[] weights, int maxDays) {
        int totalDays = 0;
        int currentWeight = 0;

        for (int weight : weights) {
            if (weight + currentWeight <= maxWeight) {
                currentWeight += weight;
            } else {
                //you cannot take that weight
                totalDays++;
                currentWeight = weight;
            }
        }

        if (currentWeight != 0) totalDays++;

        return totalDays <= maxDays;
    }
}