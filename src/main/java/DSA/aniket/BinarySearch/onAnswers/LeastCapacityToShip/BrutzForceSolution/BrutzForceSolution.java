package DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip.BrutzForceSolution;

import DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip.LeastCapacityToShip;

public class BrutzForceSolution implements LeastCapacityToShip {

    @Override
    public int shipWithinDays(int[] weights, int days) {

        if (weights == null || weights.length == 0) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight); // if you take heigest at once
            high += weight; // if you take all the weights at once
        }

        for (int weight = low; weight <= high; weight++) {
            if (isPossible(weight, weights, days)) {
                return weight;
            }
        }

        return -1;
    }
}