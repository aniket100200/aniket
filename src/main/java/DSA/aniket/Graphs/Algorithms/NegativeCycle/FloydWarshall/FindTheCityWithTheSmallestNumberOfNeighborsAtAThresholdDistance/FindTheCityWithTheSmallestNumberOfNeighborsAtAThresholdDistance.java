package DSA.aniket.Graphs.Algorithms.NegativeCycle.FloydWarshall.FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

import DSA.aniket.Graphs.Graph;

public interface FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance extends Graph {
    int findTheCity(int n, int[][] edges, int distanceThreshold);
}