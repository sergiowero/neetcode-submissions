/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public static class Result{
        public boolean balanced;
        public int height;

        public Result(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    public Result dfs(TreeNode node) {

        if (node == null) return new Result(true, 0);

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        isBalanced = isBalanced && left.balanced && right.balanced;
        return new Result(isBalanced, Math.max(left.height, right.height) + 1);
    }
}
