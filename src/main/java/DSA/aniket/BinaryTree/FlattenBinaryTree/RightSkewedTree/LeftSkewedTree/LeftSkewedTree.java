package DSA.aniket.BinaryTree.FlattenBinaryTree.RightSkewedTree.LeftSkewedTree;

import DSA.aniket.BinaryTree.FlattenBinaryTree.FlattenBinaryTree;
import DSA.aniket.BinaryTree.TreeNode;

public class LeftSkewedTree implements FlattenBinaryTree {

    @Override
    public TreeNode flatten(TreeNode root) {
        if (root == null) return root;

        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        root.right = null;
        while (right != null) {
            root.left = right;
            while (right.left != null) right = right.left;
            right.left = left;
        }
        return root;
    }
}