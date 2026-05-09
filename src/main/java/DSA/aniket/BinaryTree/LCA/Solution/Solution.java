package DSA.aniket.BinaryTree.LCA.Solution;

import DSA.aniket.BinaryTree.LCA.LCA;
import DSA.aniket.BinaryTree.NodeToRootPath.NodeToRootPath;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements LCA {


    @Override
    public int findLca(TreeNode root, int n1, int n2) {
        NodeToRootPath path = new DSA.aniket.BinaryTree.NodeToRootPath.Solution.Solution();
        var p1 = path.find(root, n1);
        var p2 = path.find(root, n2);
        int l1 = p1.size() - 1;
        int l2 = p2.size() - 1;
        int pans = -1;
        while (p1.get(l1) != p2.get(l2)) {
            pans = p1.get(l1);
            l1--;
            l2--;
        }


        return pans;
    }
}