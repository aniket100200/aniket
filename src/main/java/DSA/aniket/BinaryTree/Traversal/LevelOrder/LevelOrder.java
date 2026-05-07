package DSA.aniket.BinaryTree.Traversal.LevelOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if (node == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);

        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode rNode = que.poll();
                ans.add(rNode.val);
                if (rNode.left != null)
                    que.add(rNode.left);
                if (rNode.right != null)
                    que.add(rNode.right);
            }

            level++;
        }

        return ans;
    }

    @Override
    public List<List<Integer>> traverseLevel(TreeNode node) {

        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);

        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            List<Integer> currentLevel = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rNode = que.poll();
                currentLevel.add(rNode.val);
                if (rNode.left != null)
                    que.add(rNode.left);
                if (rNode.right != null)
                    que.add(rNode.right);
            }

            level++;

            ans.add(currentLevel);
        }

        return ans;

    }
}