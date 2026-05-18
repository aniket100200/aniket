package DSA.aniket.Graphs.traversal.BFS;

import DSA.aniket.Graphs.traversal.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS implements Traversal {


    @Override
    public List<Integer> traversal(int V, ArrayList<ArrayList<Integer>> graph) {
        /**
         * O Based Indxing
         */
        int[] visited = new int[V];
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        que.add(0);

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int rVertex = que.poll();
                ans.add(rVertex);
                visited[rVertex]++;
                ArrayList<Integer> neighbours = graph.get(rVertex);
                for (int neighbour : neighbours) {
                    if (visited[neighbour] == 0) que.add(neighbour);
                }
            }
        }


        return ans;
    }

    @Override
    public List<Integer> traversal(int V, int[][] adj) {
        return List.of();
    }
}