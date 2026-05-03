package DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation.BetterApproach;

import DSA.aniket.BinarySearch.onAnswers.MinimiseMaximumDistanceToGasStation.MinimiseMaximumDistanceToGasStation;

import java.util.PriorityQueue;

public class BetterSolution implements MinimiseMaximumDistanceToGasStation {

    @Override
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.sectionLength >= p2.sectionLength) return -1;
            else if (p1.sectionLength < p2.sectionLength) return 1;
            else {
                if (p1.sectionIndex >= p2.sectionIndex) return -1;
                else if (p1.sectionIndex < p2.sectionIndex) return 1;
                else return 0;
            }

        });
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }

        for (int gasStations = 1; gasStations <= K; gasStations++) {
            Pair p1 = pq.poll();

            //secInd -> Section Index
            int secInd = p1.sectionIndex;
            howMany[secInd]++;
            double initialDiff = stations[secInd + 1] - stations[secInd];
            double newSectionLength = initialDiff / (howMany[secInd] + 1);
            pq.add(new Pair(newSectionLength, secInd));
        }
        return pq.peek().sectionLength;
    }

    class Pair {
        double sectionLength;
        int sectionIndex;

        public Pair(double sectionLength, int sectionIndex) {
            this.sectionIndex = sectionIndex;
            this.sectionLength = sectionLength;
        }
    }


}