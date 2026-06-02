package DSA.aniket.Graphs.DisjointSet.UnionByRank;

import DSA.aniket.Graphs.DisjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class UnionByRank implements DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public UnionByRank(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    /**
     * @param node
     * @return
     */
    @Override
    public int findParent(int node) {
        List<Integer> myParent = parent;
        if (parent.get(node) == node) return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    /**
     * @param u
     * @param v
     */
    @Override
    public void union(int u, int v) {
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);

        if (ultimateParentOfU == ultimateParentOfV) return;
        if (rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV)) {
            parent.set(ultimateParentOfU, ultimateParentOfV);
        } else if (rank.get(ultimateParentOfV) < rank.get(ultimateParentOfU)) {
            parent.set(ultimateParentOfV, ultimateParentOfU);
        } else {
            /**
             * here means rank is similar
             * height will be increasing
             */
            parent.set(ultimateParentOfV, ultimateParentOfU);
            int rankOfU = rank.get(ultimateParentOfU);
            rank.set(ultimateParentOfU, rankOfU + 1);

        }
    }


    /**
     * @return
     */
    @Override
    public List<Integer> getRankList() {
        return rank;
    }

    /**
     * @return
     */
    @Override
    public List<Integer> getParentList() {
        return parent;
    }
}