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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        f(root);
        return max;
    }

    private int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(f(root.left), 0);
        int r = Math.max(f(root.right), 0);
        max = Math.max(max, l + r + root.val);
        return Math.max(r, l) + root.val;
    }
}
