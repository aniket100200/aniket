package DSA.aniket.BinaryTree.SingleChildNode;

import java.util.List;

public interface SingleChildNode {
    List<Integer> getSingleChildren(TreeNode root);

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}