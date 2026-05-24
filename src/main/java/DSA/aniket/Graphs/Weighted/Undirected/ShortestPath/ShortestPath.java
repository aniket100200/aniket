package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath;

import DSA.aniket.Graphs.Graph;

public interface ShortestPath extends Graph {
    int[] shortestPath(int V, int[][] edges, int src);
}