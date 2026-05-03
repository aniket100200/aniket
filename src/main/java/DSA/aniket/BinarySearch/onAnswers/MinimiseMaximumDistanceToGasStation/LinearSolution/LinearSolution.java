package DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation.LinearSolution;

import DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation.MinimiseMaximumDistanceToGasStation;

public class LinearSolution implements MinimiseMaximumDistanceToGasStation {

    @Override
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        int[] howMany = new int[n - 1];

        for (int gasStations = 1; gasStations <= K; gasStations++) {
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = stations[i + 1] - stations[i];
                double sectionLength = diff / (howMany[i] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }

            howMany[maxInd]++;
        }

        double maxAns = -1;

        for (int i = 0; i < n - 1; i++) {
            double diff = stations[i + 1] - stations[i];
            double sectionLength = diff / (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
}