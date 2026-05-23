package DSA.aniket.Graphs.traversal;

import DSA.aniket.Graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public interface Traversal extends Graph {
    List<Integer> traversal(int V, ArrayList<ArrayList<Integer>> graph);

    List<Integer> traversal(int V, int[][] adj);
}
