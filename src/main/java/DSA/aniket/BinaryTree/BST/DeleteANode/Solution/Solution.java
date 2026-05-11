package DSA.aniket.BinaryTree.BST.DeleteANode.Solution;

import DSA.aniket.BinaryTree.BST.DeleteANode.DeleteANode;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements DeleteANode {

    @Override
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) {
            /**
             * case 1: If leaf Node
             */
            if (root.left == null && root.right == null) {
                return null;
            }

            /**
             * case 2: If it has both left and right node
             */

            if (root.left != null && root.right != null) {
                TreeNode rightSubtree = root.right;
                TreeNode temp = rightSubtree;
                while (temp.left != null) {
                    temp = temp.left;
                }

                temp.left = root.left;
                return rightSubtree;
            }

            if (root.left != null) {
                return root.left;
            }

            if (root.right != null) {
                return root.right;
            }

        }

        if (root.val < val) {
            //search on the right side
            TreeNode rightSubtree = deleteNode(root.right, val);
            root.right = rightSubtree;
        } else {

            TreeNode leftSubtree = deleteNode(root.left, val);
            root.left = leftSubtree;

        }
        return root;
    }
}