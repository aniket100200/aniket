package DSA.aniket.BinaryTree.BST.LCA.Solution;

import DSA.aniket.BinaryTree.BST.LCA.LCA;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements LCA {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val < q.val) return root;

        if (p.val > q.val) return lowestCommonAncestor(root, q, p);

        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}