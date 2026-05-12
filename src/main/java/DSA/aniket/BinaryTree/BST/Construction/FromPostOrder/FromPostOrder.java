package DSA.aniket.BinaryTree.BST.Construction.FromPostOrder;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;

public class FromPostOrder implements Construction {

    @Override
    public TreeNode constructBST(int[] post) {
        int[] idx = new int[1];
        idx[0] = post.length - 1;
        return construct(post, idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] post, int[] idx, int l, int r) {
        if (idx[0] < 0) return null;
        int curr = post[idx[0]];
        if (curr < l || curr > r) return null;

        --idx[0];
        TreeNode node = new TreeNode(curr);
        node.right = construct(post, idx, curr + 1, r);
        node.left = construct(post, idx, l, curr - 1);
        return node;
    }
}