package DSA.aniket.BinaryTree.PathToGivenNode.Solution;

import DSA.aniket.BinaryTree.NodeToRootPath.NodeToRootPath;
import DSA.aniket.BinaryTree.PathToGivenNode.PathToGivenNode;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.List;

public class Solution implements PathToGivenNode {


    @Override
    public List<Integer> solve(TreeNode root, int b) {
        NodeToRootPath path = new DSA.aniket.BinaryTree.NodeToRootPath.Solution.Solution();
        return path.find(root, b).reversed();
    }
}