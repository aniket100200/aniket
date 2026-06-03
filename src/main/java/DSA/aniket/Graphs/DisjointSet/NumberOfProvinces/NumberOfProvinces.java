package DSA.aniket.Graphs.DisjointSet.NumberOfProvinces;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

public class NumberOfProvinces implements DSA.aniket.Graphs.NumberOfProvinces.NumberOfProvinces {

    /**
     * @param graph
     * @return
     */
    @Override
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        DisjointSet set = new UnionBySize(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (graph[i][j] == 1) {
                    //there is an edge between i and j
                    set.union(i, j);
                }
            }
        }

        int numberOfProvinces = 0;
        int[] parent = set.getParentArray();
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) numberOfProvinces++;
        }

        return numberOfProvinces;
    }
}