package DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.PrintShortestPath;

import DSA.aniket.Graphs.Weighted.Undirected.ShortestPath.ShortestPath;

import java.util.List;

public interface PrintShortestPath extends ShortestPath {
    List<Integer> shortestPath(int n, int m, int[][] edges);
}