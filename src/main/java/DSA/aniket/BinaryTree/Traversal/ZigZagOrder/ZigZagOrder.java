package DSA.aniket.BinaryTree.Traversal.ZigZagOrder;

import DSA.aniket.BinaryTree.Traversal.InOrder.InOrder;
import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode node) {
        InOrder inOrder = new InOrder();
        return inOrder.traverse(node);
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

                if (rNode.left != null) que.add(rNode.left);
                if (rNode.right != null) que.add(rNode.right);
            }

            if (level % 2 == 0) ans.add(currentLevel);
            else {
                ans.add(reverse(currentLevel));
            }

            level++;
        }
        return ans;
    }

    private List<Integer> reverse(List<Integer> arr) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            ++left;
            --right;
        }

        return arr;
    }
}