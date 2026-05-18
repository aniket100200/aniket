package DSA.aniket.Graphs.traversal;

import java.util.ArrayList;
import java.util.List;

public interface Traversal {
    List<Integer> traversal(int V, ArrayList<ArrayList<Integer>> graph);

    List<Integer> traversal(int V, int[][] adj);
}
