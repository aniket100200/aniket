package DSA.aniket.BinaryTree.views.Right;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Right implements View {

    @Override
    public List<Integer> draw(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        ans.add(root.val);

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode rNode = que.removeFirst();
                if (rNode.left != null) que.addLast(rNode.left);
                if (rNode.right != null) que.addLast(rNode.right);
            }

            if (que.size() > 0) {
                ans.add(que.getLast().val);
            }
        }

        return ans;
    }
}