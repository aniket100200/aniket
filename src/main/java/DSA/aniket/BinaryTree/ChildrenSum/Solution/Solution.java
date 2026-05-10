package DSA.aniket.BinaryTree.ChildrenSum.Solution;

import DSA.aniket.BinaryTree.ChildrenSum.ChildrenSum;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements ChildrenSum {

    @Override
    public boolean isSumProperty(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int leftRight = (root.left != null ? root.left.val : 0) + (root.right != null ? root.right.val : 0);
        return leftRight == root.val && isSumProperty(root.left) && isSumProperty(root.right);
    }
}