package DSA.aniket.BinaryTree.Traversal.PreOrderTraversal.Solution;

import DSA.aniket.BinaryTree.Traversal.PreOrderTraversal.PreOrderTraversal;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution implements PreOrderTraversal {

    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);

        return ans;
    }

    void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        /**
         * Include root Node Before Left and Righ Child Node
         */

        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}