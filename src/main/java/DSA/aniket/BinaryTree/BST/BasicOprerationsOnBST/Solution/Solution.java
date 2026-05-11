package DSA.aniket.BinaryTree.BST.BasicOprerationsOnBST.Solution;

import DSA.aniket.BinaryTree.BST.BasicOprerationsOnBST.BasicOprerationsOnBST;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements BasicOprerationsOnBST {

    @Override
    public int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public int sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    @Override
    public int max(TreeNode node) {
        if (node == null) return 0;
        if (node.right == null) return node.val;

        return max(node.right);
    }

    @Override
    public int min(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null) return node.val;

        return min(node.left);
    }

    @Override
    public boolean find(TreeNode node, int data) {
        /**
         * apply Binary Search
         */
        if (node == null) return false;
        if (node.val == data) return true;
        if (node.val < data) {
            return find(node.right, data);
        }
        return find(node.left, data);
    }
}