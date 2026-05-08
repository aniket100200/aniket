package DSA.aniket.BinaryTree.Traversal.BoundaryOrder;

import DSA.aniket.BinaryTree.Traversal.Traverse;
import DSA.aniket.BinaryTree.TreeNode;
import DSA.aniket.BinaryTree.views.Bottom.Bottom;
import DSA.aniket.BinaryTree.views.Left.Left;
import DSA.aniket.BinaryTree.views.Right.Right;
import DSA.aniket.BinaryTree.views.Top.Top;
import DSA.aniket.BinaryTree.views.View;

import java.util.LinkedList;
import java.util.List;

public class BoundaryOrder implements Traverse {

    @Override
    public List<Integer> traverse(TreeNode root) {
        /**
         * it is combination of Top,Left,Bottom & Right View
         */

        View top = new Top();
        View left = new Left();
        View bottom = new Bottom();
        View righView = new Right();

        List<Integer>[] abc = new List[]{top.draw(root), left.draw(root), bottom.draw(root), righView.draw(root)};

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < 4; i++) {

        }

        return ans;

    }
}