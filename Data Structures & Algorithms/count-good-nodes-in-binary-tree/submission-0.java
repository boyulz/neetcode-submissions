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
        search(root, root.val);
        return ans;
    }

    private void search(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            ans ++;
            max = node.val;
        }
        search(node.left, max);
        search(node.right, max);
    }
}
