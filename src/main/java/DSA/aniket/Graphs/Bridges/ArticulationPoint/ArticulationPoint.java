package DSA.aniket.Graphs.Bridges.ArticulationPoint;

import java.util.ArrayList;

public interface ArticulationPoint {
    ArrayList<Integer> articulationPoints(
            int V,
            ArrayList<ArrayList<Integer>> adj
    );
}