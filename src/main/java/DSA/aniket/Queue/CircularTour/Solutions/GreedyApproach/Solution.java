package DSA.aniket.Queue.CircularTour.Solutions.GreedyApproach;

import DSA.aniket.Queue.CircularTour.CircularTour;

public class Solution implements CircularTour {
  @Override
  public int tour(int[] petrol, int[] distance) {
    // will greedily check  if the answer exists?
    int total = 0;
    int n = petrol.length;
    for (int i = 0; i < n; i++) {
      total += (petrol[i] - distance[i]);
    }

    if (total < 0) return -1;

    // here means answer does exit
    int pans = -1;
    int totalPetrolLeft = 0;
    for (int i = 0; i < n; i++) {
      int totalPetrol = totalPetrolLeft + petrol[i];
      int distanceToMove = distance[i];
      if (totalPetrol >= distanceToMove) {
        totalPetrolLeft = totalPetrol - distanceToMove;
        if (pans == -1) {
          pans = i;
        }
      } else {
        pans = -1;
        totalPetrolLeft = 0;
      }
    }

    return pans;
  }
}
