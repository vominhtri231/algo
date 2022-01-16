package leetcode.tree;

import java.util.Stack;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> sums = new Stack<>();

        sums.add(root);

        while (!sums.empty()) {

            TreeNode currentNode = sums.pop();
            if (currentNode.val == targetSum) {
                return true;
            }

            if (currentNode.left != null) {
                currentNode.left.val = currentNode.left.val + currentNode.val;
                sums.push(currentNode.left);
            }

            if (currentNode.right != null) {
                currentNode.right.val = currentNode.right.val + currentNode.val;
                sums.push(currentNode.right);
            }
        }

        return false;
    }
}
