package DSA.aniket.BinaryTree.Traversal.VerticalOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrder implements Traverse {

    int leftMIN = Integer.MAX_VALUE;
    int rightMax = Integer.MIN_VALUE;

    @Override
    public List<Integer> traverse(TreeNode node) {
        return List.of();
    }

    @Override
    public List<List<Integer>> traverseLevel(TreeNode node) {

        if (node == null) return new ArrayList<>();
        leftMIN = Integer.MAX_VALUE;
        rightMax = Integer.MIN_VALUE;
        dfs(node, 0);
//        if (leftMIN == Integer.MIN_VALUE) leftMIN = 0;
//        if (rightMax == Integer.MAX_VALUE) rightMax = 0;
        int totalLevels = rightMax - leftMIN + 1;
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        que.add(new Pair(node, -1 * leftMIN));

        List<Integer>[] verticalLevels = new List[totalLevels];

        for (int i = 0; i < verticalLevels.length; i++) {
            verticalLevels[i] = new ArrayList<>();
        }
        while (que.size() > 0) {
            int size = que.size();
            PriorityQueue<Pair> nextLevelPq = new PriorityQueue<>();
            while (size-- > 0) {
                Pair rPair = que.remove();
                TreeNode currNode = rPair.node;
                int level = rPair.level;
                verticalLevels[level].add(currNode.val);

                if (currNode.left != null) nextLevelPq.add(new Pair(currNode.left, level - 1));
                if (currNode.right != null) nextLevelPq.add(new Pair(currNode.right, level + 1));

            }

            que = nextLevelPq;
        }

        return Arrays.stream(verticalLevels).toList();
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;

        leftMIN = Math.min(level, leftMIN);
        rightMax = Math.max(level, rightMax);

        dfs(node.left, level - 1);
        dfs(node.right, level + 1);
    }
}

class Pair implements Comparable<Pair> {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

    @Override
    public int compareTo(Pair other) {
        /**
         * -ve value this element is smaller
         * 0
         * +ve value other element is smaller
         */


        if (this.level == other.level) {
            return this.node.val - other.node.val;
        } else return this.level - other.level; //this shows the default Behaviour smallest value first
    }
}