package DSA.aniket.BinaryTree.views.Top;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Top implements View {

    @Override
    public List<Integer> draw(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        Deque<Integer> ans = new ArrayDeque<>();

        while (que.size() > 0) {
            int size = que.size();

            TreeNode first = que.getFirst();
            TreeNode last = que.getLast();

            if (first == last)
                ans.add(first.val);
            else {
                ans.addFirst(first.val);
                ans.addLast(last.val);
            }

            while (size-- > 0) {
                TreeNode rNode = que.removeFirst();
                if (rNode.left != null) que.addLast(rNode.left);
                if (rNode.right != null) que.addLast(rNode.right);
            }

        }
        return ans.stream().collect(Collectors.toList());
    }
}