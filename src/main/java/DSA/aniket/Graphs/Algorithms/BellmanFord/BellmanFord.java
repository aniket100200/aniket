package DSA.aniket.Graphs.Algorithms.BellmanFord;

import DSA.aniket.Graphs.Graph;

public interface BellmanFord extends Graph {
    int[] bellmanFord(int V, int[][] edges, int src);
}
