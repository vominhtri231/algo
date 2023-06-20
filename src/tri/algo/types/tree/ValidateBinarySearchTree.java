package tri.algo.types.tree;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode tree, long min, long max) {
        if (tree == null) {
            return true;
        }

        if (tree.val >= max || tree.val <= min) {
            return false;
        }

        return isValidBST(tree.left, min, Math.min(max, tree.val))
                && isValidBST(tree.right, Math.max(min, tree.val), max);
    }
}
