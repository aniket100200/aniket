package DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.LeastCapacityToShip.LeastCapacityToShip;

public class OptimalSolution implements LeastCapacityToShip {

    @Override
    public int shipWithinDays(int[] weights, int days) {

        if (weights == null || weights.length == 0) return -1;
        //let's define the range
        int low = 0, high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        //low will be pointing wheere with that weight it is not possible to ship withing D days

        while (low <= high) {
            int weight = low + (high - low) / 2;

            if (isPossible(weight, weights, days)) high = weight - 1;
            else low = weight + 1;
        }

        return low; //due to opposite polarity
    }
}