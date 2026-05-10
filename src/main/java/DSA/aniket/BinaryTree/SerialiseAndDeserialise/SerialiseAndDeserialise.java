package DSA.aniket.BinaryTree.SerialiseAndDeserialise;

import DSA.aniket.BinaryTree.TreeNode;

public interface SerialiseAndDeserialise {
    String serialise(TreeNode root);

    TreeNode deSerialise(String serialise);
}