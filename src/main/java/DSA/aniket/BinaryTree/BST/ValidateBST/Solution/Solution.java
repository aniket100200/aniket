package DSA.aniket.BinaryTree.BST.ValidateBST.Solution;

import DSA.aniket.BinaryTree.BST.ValidateBST.ValidateBST;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements ValidateBST {

    @Override
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValid(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val < left || root.val > right) return false;
        /**
         * cast root.val is in integer cast it to long to support edge cases
         */
        return isValid(root.left, left, (long) root.val - 1) && isValid(root.right, (long) root.val + 1, right);
    }
}