package DSA.aniket.BinaryTree.SingleChildNode.BrutzForceSolution;

import DSA.aniket.BinaryTree.SingleChildNode.SingleChildNode;

import java.util.ArrayList;
import java.util.List;

public class BrutzForceSolution implements SingleChildNode {

    @Override
    public List<Integer> getSingleChildren(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        dfs(root, null, ans);

        return ans;
    }

    public void dfs(TreeNode node, TreeNode parentNode, List<Integer> ans) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            //the current node is the child node.
            if (parentNode == null) {
                ans.add(node.val);
                return;
            }
            if (parentNode.left == null || parentNode.right == null) {
                //I'm the single child
                ans.add(parentNode.val);
            }
            return;
        }

        dfs(node.left, node, ans);
        dfs(node.right, node, ans);
    }
}