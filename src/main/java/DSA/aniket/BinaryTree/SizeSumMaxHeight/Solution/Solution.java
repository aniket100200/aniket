package DSA.aniket.BinaryTree.SizeSumMaxHeight.Solution;

import DSA.aniket.BinaryTree.SizeSumMaxHeight.SizeSumMaxHeight;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements SizeSumMaxHeight {
    @Override
    public int getSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getSize(root.left) + getSize(root.right);
    }

    @Override
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    @Override
    public int getMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));
    }

    @Override
    public int getHeight(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        int level = 0;
//        if (root != null)
//            queue.add(root);
//        while (queue.size() > 0) {
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode curr = queue.poll();
//                if (curr.left != null) queue.add(curr.left);
//                if (curr.right != null) queue.add(curr.right);
//            }
//
//            level++;
//        }
//        return level;
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}