package DSA.aniket.BinaryTree.BalancedBinaryTree.Solution;

import DSA.aniket.BinaryTree.BalancedBinaryTree.BalancedBinaryTree;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements BalancedBinaryTree {

    @Override
    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root).isBalanced;
    }


    public Pair isBalanced_(TreeNode root) {
        if (root == null) return new Pair(true, 0);

        Pair left = isBalanced_(root.left);
        Pair right = isBalanced_(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        Pair ans = new Pair(isBalanced, Math.max(left.height, right.height) + 1);

        return ans;
    }

    class Pair {
        boolean isBalanced;
        int height;

        public Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}