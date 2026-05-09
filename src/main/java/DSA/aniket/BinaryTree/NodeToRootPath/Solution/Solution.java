package DSA.aniket.BinaryTree.NodeToRootPath.Solution;

import DSA.aniket.BinaryTree.NodeToRootPath.NodeToRootPath;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution implements NodeToRootPath {


    @Override
    public List<Integer> find(TreeNode root, int target) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, target, ans);

        return ans;
    }

    boolean dfs(TreeNode root, int target, List<Integer> ans) {
        if (root == null) return false;
        if (root.val == target) {
            ans.add(root.val);
            return true;
        }

        boolean isInLeft = dfs(root.left, target, ans);
        boolean isRight = dfs(root.right, target, ans);
        if (isRight || isInLeft) {
            ans.add(root.val);
            return true;
        }
        return false;
    }
}