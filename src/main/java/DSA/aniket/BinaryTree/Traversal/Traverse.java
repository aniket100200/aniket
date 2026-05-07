package DSA.aniket.BinaryTree.Traversal;

import DSA.aniket.BinaryTree.TreeNode;

import java.util.List;

public interface Traverse {
    List<Integer> traverse(TreeNode node);

    default List<List<Integer>> traverseLevel(TreeNode node) {
        return null;
    }
}
