package DSA.aniket.Graphs.BipartiteGraph;

import DSA.aniket.Graphs.Graph;

import java.util.ArrayList;

public interface BipartiteGraph extends Graph {
    boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj);
}