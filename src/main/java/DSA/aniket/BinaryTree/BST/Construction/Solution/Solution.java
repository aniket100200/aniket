package DSA.aniket.BinaryTree.BST.Construction.Solution;

import DSA.aniket.BinaryTree.BST.Construction.Construction;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements Construction {
    @Override
    public TreeNode constructBST(int[] in) {
        return construct(in, 0, in.length - 1);
    }

    public TreeNode construct(int[] arr, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = construct(arr, l, mid - 1);
        node.right = construct(arr, mid + 1, r);
        return node;
    }
}