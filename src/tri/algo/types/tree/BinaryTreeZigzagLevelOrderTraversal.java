package tri.algo.types.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, result, 0);
        return result;
    }

    private void levelOrder(TreeNode treeNode, List<List<Integer>> result, int level) {
        if (treeNode == null) {
            return;
        }

        levelOrder(treeNode.left, result, level + 1);

        while (result.size() <= level) {
            result.add(new LinkedList<>());
        }
        if (level % 2 == 1) {
            ((LinkedList<Integer>) result.get(level)).addFirst(treeNode.val);
        } else {
            ((LinkedList<Integer>) result.get(level)).addLast(treeNode.val);
        }

        levelOrder(treeNode.right, result, level + 1);
    }
}
