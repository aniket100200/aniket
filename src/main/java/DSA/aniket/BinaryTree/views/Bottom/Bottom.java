package DSA.aniket.BinaryTree.views.Bottom;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.Traversal.VerticalOrder.VerticalOrder;
import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bottom implements View {

    @Override
    public List<Integer> draw(TreeNode root) {
        if (root == null) return new ArrayList<>();
        /**
         * find the vertical Order Traversal
         */
        Traverse traverse = new VerticalOrder();
        List<List<Integer>> verticalLevels = traverse.traverseLevel(root);

        return verticalLevels.stream().map(x -> x.get(x.size() - 1)).collect(Collectors.toList());
    }
}