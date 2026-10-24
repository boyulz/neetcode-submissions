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
    private int ans = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return ans;
    }

    private void traverse(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            ans ++;
        }
        traverse(node.left, Math.max(node.val, max));
        traverse(node.right, Math.max(node.val, max));
    }
}
