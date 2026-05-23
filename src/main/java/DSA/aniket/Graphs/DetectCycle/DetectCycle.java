package DSA.aniket.Graphs.DetectCycle;

import DSA.aniket.Graphs.Graph;

import java.util.ArrayList;

public interface DetectCycle extends Graph {
    boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj);
}