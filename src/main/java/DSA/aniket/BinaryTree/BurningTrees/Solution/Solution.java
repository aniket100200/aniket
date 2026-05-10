package DSA.aniket.BinaryTree.BurningTrees.Solution;

import DSA.aniket.BinaryTree.BurningTrees.BurningTrees;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.*;

public class Solution implements BurningTrees {

    @Override
    public int minTime(TreeNode root, int target) {
        if (root == null) return 0;

        TreeNode src = findTarget(root, target);
        if (src == null) return 0;
        int level = 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();

        createChildParentMap(root, null, childParentMap);

        Set<TreeNode> visited = new HashSet<>();

        que.add(src);
        visited.add(src);
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode rNode = que.poll();
                //this will be never null
                if (rNode.left != null && !visited.contains(rNode.left)) {
                    visited.add(rNode.left);
                    que.add(rNode.left);
                }

                if (rNode.right != null && !visited.contains(rNode.right)) {
                    visited.add(rNode.right);
                    que.add(rNode.right);
                }

                if (childParentMap.containsKey(rNode)) {
                    TreeNode parent = childParentMap.get(rNode);

                    if (parent != null) {
                        if (!visited.contains(parent)) {
                            que.add(parent);
                            visited.add(parent);
                        }
                    }

                }

            }

            level++;
        }


        return level - 1;
    }

    void createChildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        map.put(node, parent);
        if (node.left != null)
            createChildParentMap(node.left, node, map);
        if (node.right != null) createChildParentMap(node.right, node, map);

    }

    TreeNode findTarget(TreeNode root, int target) {
        if (root == null) return null;

        if (root.val == target) return root;

        var left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
}