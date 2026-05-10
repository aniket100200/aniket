package DSA.aniket.BinaryTree.SerialiseAndDeserialise.Solution;

import DSA.aniket.BinaryTree.SerialiseAndDeserialise.SerialiseAndDeserialise;
import DSA.aniket.BinaryTree.TreeNode;

public class Solution implements SerialiseAndDeserialise {

    @Override
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder("");
        preOrderTraversal(root, pre);
        return pre.toString();
    }

    @Override
    public TreeNode deserialize(String serialise) {
        String[] arr = serialise.split(",");
        TreeNode root = buildTree(arr, new int[1]);
        return root;
    }


    public TreeNode buildTree(String[] arr, int[] idx) {
        if (idx[0] == arr.length) return null;

        if (arr[idx[0]].equals("null")) {
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;

        root.left = buildTree(arr, idx);
        root.right = buildTree(arr, idx);

        return root;
    }

    void preOrderTraversal(TreeNode root, StringBuilder pre) {
        if (root == null) {
            pre.append("null,");
            return;
        }

        pre.append(root.val + ",");
        preOrderTraversal(root.left, pre);
        preOrderTraversal(root.right, pre);
    }
}


