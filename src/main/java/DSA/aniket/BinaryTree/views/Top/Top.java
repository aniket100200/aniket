package DSA.aniket.BinaryTree.views.Top;

import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Top implements View {

    int leftEnd;
    int rightEnd;

    @Override
    public List<Integer> draw(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> verticalOrder = verticalOrderTraversal(root);
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> level : verticalOrder) {
            ans.add(level.get(0));
        }

        return ans;

    }

    private List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        leftEnd = Integer.MAX_VALUE;
        rightEnd = Integer.MIN_VALUE;
        dfs(root, 0);

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root, -leftEnd));
        List<List<Integer>> ans = new ArrayList<>();
        int totalLevels = rightEnd - leftEnd + 1;
        for (int i = 0; i < totalLevels; i++) ans.add(new ArrayList<>());

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rPair = que.poll();
                TreeNode node = rPair.node;
                int level = rPair.level;
                ans.get(level).add(node.val);

                if (node.left != null) que.add(new Pair(node.left, level - 1));
                if (node.right != null) que.add(new Pair(node.right, level + 1));
            }
        }

        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        leftEnd = Math.min(level, leftEnd);
        rightEnd = Math.max(level, rightEnd);
        dfs(root.right, level + 1);
        dfs(root.left, level - 1);
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.level == o.level) {
                return this.node.val - o.node.val;
            } else return this.level - o.level;
        }
    }


}