package DSA.aniket.Graphs.DisjointSet.NumberOfIslandsII.Solution;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.NumberOfIslandsII.NumberOfIslandsII;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

import java.util.ArrayList;
import java.util.List;

public class Solution implements NumberOfIslandsII {

    /**
     * @param n
     * @param m
     * @param operators
     * @return
     */
    @Override
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet set = new UnionBySize(n * m);
        int[][] vis = new int[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];
            if (vis[row][col] != 0) {
                ans.add(count);
                continue;
            }

            vis[row][col] = 1;
            count++;
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, -1, 0, 1};
            for (int idx = 0; idx < 4; idx++) {
                var adjr = row + dr[idx];
                var adjc = col + dc[idx];
                if (isValid(adjr, adjc, n, m) && vis[adjr][adjc] != 0) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = adjr * m + adjc;

                    if (set.findParent(nodeNo) != set.findParent(adjNodeNo)) {
                        count--;
                        set.union(nodeNo, adjNodeNo);
                    }
                }
            }

            ans.add(count);
        }

        return ans;
    }

    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
}