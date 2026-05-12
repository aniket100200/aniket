package DSA.aniket.BinaryTree.BST.Construction.FromPreOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;

public class FromPreOrder implements Construction {

    public static void main(String[] args) {
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        TreeNode root = new FromPreOrder().constructBST(preOrder);

        root = root;
        System.out.println(root);
    }

    @Override
    public TreeNode constructBST(int[] preOrder) {
        return construct(preOrder, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] pre, int[] idx, int l, int r) {
        if (idx[0] == pre.length) return null;
        int curr = pre[idx[0]];
        if (curr < l || curr > r) {
            return null;
        }

        idx[0]++;
        TreeNode node = new TreeNode(curr);
        node.left = construct(pre, idx, l, curr - 1);
        node.right = construct(pre, idx, curr + 1, r);
        return node;
    }
}