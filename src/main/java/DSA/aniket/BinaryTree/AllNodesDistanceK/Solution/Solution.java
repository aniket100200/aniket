package DSA.aniket.BinaryTree.AllNodesDistanceK.Solution;

import DSA.aniket.BinaryTree.AllNodesDistanceK.AllNodesDistanceK;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.*;

public class Solution implements AllNodesDistanceK {

    @Override
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        dfs(root, null, childParentMap);

        TreeNode src = target;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(src);
        visited.add(src);
        int level = 0;


        while (que.size() > 0) {

            if (level == k) {
                while (que.size() > 0) {
                    ans.add(que.poll().val);
                }

                return ans;
            }
            int size = que.size();
            while (size-- > 0) {
                TreeNode rNode = que.poll();

                if (rNode.left != null && !visited.contains(rNode.left)) {
                    que.add(rNode.left);
                    visited.add(rNode.left);
                }

                if (rNode.right != null && !visited.contains(rNode.right)) {
                    que.add(rNode.right);
                    visited.add(rNode.right);
                }

                if (childParentMap.containsKey(rNode)) {
                    TreeNode parent = childParentMap.get(rNode);
                    if (parent != null && !visited.contains(parent)) {
                        visited.add(parent);
                        que.add(parent);
                    }
                }
            }

            level++;

        }

        return ans;
    }

    void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        map.put(node, parent);
        dfs(node.left, node, map);
        dfs(node.right, node, map);
    }

    TreeNode find(TreeNode root, TreeNode target) {
        if (root == null) return null;

        if (root.val == target.val) return root;

        var left = find(root.left, target);
        if (left != null) return left;
        return find(root.right, target);

    }
}