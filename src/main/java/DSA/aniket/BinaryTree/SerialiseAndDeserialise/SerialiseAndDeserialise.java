package DSA.aniket.BinaryTree.SerialiseAndDeserialise;

import DSA.aniket.BinaryTree.TreeNode;

public interface SerialiseAndDeserialise {
    String serialize(TreeNode root);

    TreeNode deserialize(String serialise);
}