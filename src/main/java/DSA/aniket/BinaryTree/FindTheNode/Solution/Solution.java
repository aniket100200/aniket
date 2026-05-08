package DSA.aniket.BinaryTree.FindTheNode.Solution;

import DSA.aniket.BinaryTree.FindTheNode.FindTheNode;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements FindTheNode {

    @Override
    public TreeNode searchNode(TreeNode root, int tar) {
        if (root == null) return null;
        if (root.val == tar) return root;
        TreeNode ans = searchNode(root.left, tar);
        if (ans != null) return ans;
        ans = searchNode(root.right, tar);
        return ans;

    }
}