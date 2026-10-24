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
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        search(root);
        return ans;
    }

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        k --;
        if (k == 0) {
            ans = node.val;
        }
        search(node.right);
        return; 
    }
}
