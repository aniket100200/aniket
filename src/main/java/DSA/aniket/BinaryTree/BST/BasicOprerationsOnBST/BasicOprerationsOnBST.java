package DSA.aniket.BinaryTree.BST.BasicOprerationsOnBST;

import DSA.aniket.BinaryTree.TreeNode;

public interface BasicOprerationsOnBST {
    int size(TreeNode node);

    int sum(TreeNode node);

    int max(TreeNode node);

    int min(TreeNode node);

    boolean find(TreeNode node, int data);
}