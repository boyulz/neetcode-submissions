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
    public boolean isValidBST(TreeNode root) {
        return f(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean f(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        boolean l = f(node.left, min, node.val);
        boolean r = f(node.right, node.val, max);
        return node.val > min && node.val < max && l && r;
    }
}
