package DSA.aniket.BinaryTree.Traversal.PostOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        dfs(node, ans);
        return ans;
    }

    void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        /**
         * Include root node after it's childs are included
         */


        dfs(root.left, ans);
        dfs(root.right, ans);

        ans.add(root.val);
    }
}