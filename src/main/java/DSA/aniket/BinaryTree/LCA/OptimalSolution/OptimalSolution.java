package DSA.aniket.BinaryTree.LCA.OptimalSolution;

import DSA.aniket.BinaryTree.LCA.LCA;
import DSA.aniket.BinaryTree.TreeNode;

public class OptimalSolution implements LCA {

    @Override
    public Integer findLca(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.val == n1) return root.val;
        if (root.val == n2) return n2;
        Integer left = findLca(root.left, n1, n2);
        Integer right = findLca(root.right, n1, n2);
        if (left != null && right != null) return root.val;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}