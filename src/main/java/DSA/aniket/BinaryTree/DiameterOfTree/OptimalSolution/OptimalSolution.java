package DSA.aniket.BinaryTree.DiameterOfTree.OptimalSolution;

import DSA.aniket.BinaryTree.DiameterOfTree.DiameterOfTree;
import DSA.aniket.BinaryTree.TreeNode;

public class OptimalSolution implements DiameterOfTree {

    @Override
    public int diameter(TreeNode root) {
        return findDiameter(root).bestDiameter;
    }

    public Pair findDiameter(TreeNode root) {
        if (root == null) return new Pair(0, 0);
        Pair left = findDiameter(root.left);
        Pair right = findDiameter(root.right);

        int leftDia = left.bestDiameter;
        int rightDia = right.bestDiameter;
        int diaThroughRoot = left.height + 1 + right.height;

        Pair ans = new Pair(Math.max(leftDia, Math.max(rightDia, diaThroughRoot)), Math.max(left.height, right.height) + 1);

        return ans;
    }

    class Pair {
        int bestDiameter;
        int height;

        public Pair(int bestDiameter, int height) {
            this.bestDiameter = bestDiameter;
            this.height = height;
        }
    }


}