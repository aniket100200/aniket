package DSA.aniket.BinaryTree.NodeToRootPath.Solution;

import DSA.aniket.BinaryTree.NodeToRootPath.NodeToRootPath;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution implements NodeToRootPath {

    List<Integer> ans = new ArrayList<>();

    @Override
    public List<Integer> find(TreeNode root, int target) {
        dfs(root, target);

        return ans;
    }

    boolean dfs(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) {
            ans.add(root.val);
            return true;
        }

        boolean isInLeft = dfs(root.left, target);
        boolean isRight = dfs(root.right, target);
        if (isRight || isInLeft) {
            ans.add(root.val);
            return true;
        }
        return false;
    }
}