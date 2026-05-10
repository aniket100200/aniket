package DSA.aniket.BinaryTree.FlattenBinaryTree.RightSkewedTree;

import DSA.aniket.BinaryTree.FlattenBinaryTree.FlattenBinaryTree;
import DSA.aniket.BinaryTree.TreeNode;

public class RightSkewedTree implements FlattenBinaryTree {

    @Override
    public TreeNode flatten(TreeNode root) {

        if (root == null) return root;

        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = right;
        }
        return root;
    }
}