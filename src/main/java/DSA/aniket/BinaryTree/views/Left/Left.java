package DSA.aniket.BinaryTree.views.Left;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Left implements View {

    @Override
    public List<Integer> draw(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (que.size() > 0) {
            int size = que.size();
            TreeNode peek = que.peek();
            ans.add(peek.val);
            while (size-- > 0) {
                TreeNode rNode = que.poll();
                if (rNode.left != null) que.add(rNode.left);
                if (rNode.right != null) que.add(rNode.right);
            }
        }

        return ans;
    }
}