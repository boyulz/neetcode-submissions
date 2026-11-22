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
        search(root);
        return max;
    }

    private int search(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = search(root.left);
        int rightMax = search(root.right);
        max = Math.max(max, leftMax + rightMax + root.val);
        return Math.max(Math.max(leftMax, rightMax) + root.val, 0);
    }
}
