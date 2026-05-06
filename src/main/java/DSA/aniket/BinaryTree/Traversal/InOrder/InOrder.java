package DSA.aniket.BinaryTree.Traversal.InOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrder implements Traverse {
    @Override
    public List<Integer> traverse(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        dfs(node, ans);
        return ans;
    }

    void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        /**
         * Include root node After left child and before right child node
         */

        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}