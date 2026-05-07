package DSA.aniket.BinaryTree.DiameterOfTree.Solution;

import DSA.aniket.BinaryTree.DiameterOfTree.DiameterOfTree;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements DiameterOfTree {

    @Override
    public int diameter(TreeNode root) {

        //base case
        if (root == null) return 0;

        int bestDiameterFromTheLeft = diameter(root.left);
        int bestDiameterFromTheRight = diameter(root.right);

        //Diameter Passing Through Me.
        int heighOfLeftSubtree = height(root.left);
        int heightOfRightSubtree = height(root.right);

        int diameterPassingThroughMe = heighOfLeftSubtree + 1 + heightOfRightSubtree;
        return Math.max(diameterPassingThroughMe, Math.max(bestDiameterFromTheLeft, bestDiameterFromTheRight));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int heighOfLeftSubtree = height(root.left);
        int heighOfRightSubtree = height(root.right);

        return 1 + Math.max(heighOfLeftSubtree, heighOfRightSubtree);
    }
}