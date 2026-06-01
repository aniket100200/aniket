package DSA.aniket.Graphs.MinimumSpanningTree.PrimsAlgorithm;

import DSA.aniket.Graphs.Graph;

public interface PrimsAlgorithm extends Graph {
    int spanningTree(int V, int[][] edges);
}