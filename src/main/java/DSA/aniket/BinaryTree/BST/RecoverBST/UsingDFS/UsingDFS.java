package DSA.aniket.BinaryTree.BST.RecoverBST.UsingDFS;

import DSA.aniket.BinaryTree.BST.RecoverBST.RecoverBST;
import DSA.aniket.BinaryTree.TreeNode;

public class UsingDFS implements RecoverBST {

    TreeNode pre;
    TreeNode curr;

    TreeNode a;
    TreeNode b;

    @Override
    public TreeNode recoverTree(TreeNode root) {
        pre = null;
        curr = null;

        a = null;
        b = null;

        inOrderTraversal(root);

        if (pre.val > curr.val) {
            b = curr;
        }

        if (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        if (pre == null) {
            pre = curr;
            curr = root;
        } else {
            //here means previous is not null you can compare the values
            if (pre.val > curr.val) {
                //if it's first time
                if (a == null) {
                    a = pre;
                    b = curr;
                } else b = curr;
            }

            pre = curr;
            curr = root;
        }

        inOrderTraversal(root.right);

    }
}